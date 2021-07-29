package com.SHARKY2023.EngineeringReimagined.blocks.generator.sterling;

import com.SHARKY2023.EngineeringReimagined.config.Config;
import com.SHARKY2023.EngineeringReimagined.energy.CustomEnergyStorage;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.entity.TickableBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

import static com.SHARKY2023.EngineeringReimagined.registries.Registration.STERLING_TILE;

public class SterlingTile extends BlockEntity implements TickableBlockEntity {

    private ItemStackHandler itemHandler = createHandler();
    private CustomEnergyStorage energyStorage = createEnergy();

    // Never create lazy optionals in getCapability. Always place them as fields in the tile entity:
    private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);

    private int counter;

    public SterlingTile() {
            super(STERLING_TILE.get());
    }


    @Override
    public void setRemoved() {
        super.setRemoved();
        handler.invalidate();
        energy.invalidate();
    }

    @Override
    public void tick() {
        if (level.isClientSide) { return;
        }
            if (counter > 0) {
                counter--;
                if (counter > 0) {
                    energyStorage.generatePower(40);
                }
                setChanged();
            }
            if (counter <= 0) {
                ItemStack stack = itemHandler.getStackInSlot(0);
                if (stack.getItem() == Items.COAL) {
                    itemHandler.extractItem(0, 1, false);
                    counter = 2000;
                    setChanged();
                }
            }
        BlockState blockState = level.getBlockState(worldPosition);
        if (blockState.getValue(BlockStateProperties.POWERED) != counter > 0) {
            level.setBlock(worldPosition, blockState.setValue(BlockStateProperties.POWERED, counter > 0),
                    Constants.BlockFlags.NOTIFY_NEIGHBORS + Constants.BlockFlags.BLOCK_UPDATE);
        }
            sendOutPower();
        }

        private void sendOutPower() {
            AtomicInteger capacity = new AtomicInteger(energyStorage.getEnergyStored());
            if (capacity.get() > 0) {
                for (Direction direction : Direction.values()) {
                    BlockEntity te = level.getBlockEntity(worldPosition.relative(direction));
                    if (te != null) {
                        boolean doContinue = te.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
                                    if (handler.canReceive()) {
                                        int received = handler.receiveEnergy(Math.min(capacity.get(), Config.STERLING_SEND.get()), false);
                                        capacity.addAndGet(-received);
                                        energyStorage.consumePower(received);
                                        setChanged();
                                        return capacity.get() > 0;
                                    } else {
                                        return true;
                                    }
                                }
                        ).orElse(true);
                        if (!doContinue) {
                            return;
                        }
                    }
                }
            }
        }

        @Override
        public void load(BlockState state, CompoundTag tag) {
            itemHandler.deserializeNBT(tag.getCompound("inv"));
            energyStorage.deserializeNBT(tag.getCompound("energy"));

            counter = tag.getInt("counter");
            super.load(state, tag);
        }

        @Override
        public CompoundTag save(CompoundTag tag) {
            tag.put("inv", itemHandler.serializeNBT());
            tag.put("energy", energyStorage.serializeNBT());

            tag.putInt("counter", counter);
            return super.save(tag);
        }

        private ItemStackHandler createHandler() {
            return new ItemStackHandler(1) {

                @Override
                protected void onContentsChanged(int slot) {
                    // To make sure the TE persists when the chunk is saved later we need to
                    // mark it dirty every time the item handler changes
                    setChanged();
                }

                @Override
                public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                    return stack.getItem() == Items.COAL;
                }

                @Nonnull
                @Override
                public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                    if (stack.getItem() != Items.COAL) {
                        return stack;
                    }
                    return super.insertItem(slot, stack, simulate);
                }
            };
        }

        private CustomEnergyStorage createEnergy() {
            return new CustomEnergyStorage(2000, 20000) {
                @Override
                protected void onEnergyChanged() {
                    setChanged();
                }
            };
        }

        @Nonnull
        @Override
        public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
            if (cap.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)) {
                return handler.cast();
            }
            if (cap.equals(CapabilityEnergy.ENERGY)) {
                return energy.cast();
            }
            return super.getCapability(cap, side);
        }
    }