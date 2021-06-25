package com.SHARKY2023.EngineeringReimagined.blocks.battery;

import com.SHARKY2023.EngineeringReimagined.energy.CustomEnergyStorage;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

public class BatteryTile extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

    public int maxEnergy;
    private int maxTransfer;
    private int maxReceive;

    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergy);
    private CustomEnergyStorage energyStorage = new CustomEnergyStorage(maxTransfer,maxReceive, maxEnergy);

    private IEnergyStorage createEnergy() {
        return new CustomEnergyStorage(maxTransfer, maxEnergy);
    }

    private int Energy;


    public int energyStored, energyProductionClient;
    public int energyReceived;

    private BatteryTier levelBattery;

    public BatteryTile(BatteryTier levelBattery) {
        super(Registration.BATTERY_TILE.get(levelBattery).get());
        this.levelBattery = levelBattery;
        maxEnergy = (int) Math.pow(levelBattery.ordinal() + 2, levelBattery.ordinal() + 2) * 64000;
        maxTransfer = (int) Math.pow(8, levelBattery.ordinal()) + 1;


    }

    @Override
    public void tick() {
        if (!level.isClientSide)

            sendEnergy();
    }

   // private int recieveEnergy(int maxTransfer) {
   //      return maxTransfer;
   //  }


    private void sendEnergy() {
        energy.ifPresent(energy ->
        {
            AtomicInteger capacity = new AtomicInteger(energy.getEnergyStored());
            for (int i = 0; (i < Direction.values().length) && (capacity.get() > 0); i++) {
                Direction facing = Direction.values()[i];
                if (facing != Direction.UP) {
                    TileEntity tileEntity = level.getBlockEntity(worldPosition.relative(facing));
                    if (tileEntity != null) {
                        tileEntity.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite()).ifPresent(handler -> {
                            if (handler.canReceive()) {
                                int received = handler.receiveEnergy(Math.min(capacity.get(), maxTransfer), false);
                                capacity.addAndGet(-received);
                                ((CustomEnergyStorage) energy).consumePower(received);
                            }
                        });
                    }
                }
            }
        });
        }



    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, Direction facing) {
        if (capability == CapabilityEnergy.ENERGY && facing != Direction.UP) {
            return energy.cast();

        }
        return super.getCapability(capability, facing);
    }

@SuppressWarnings("unchecked")
    @Override
    public void load(BlockState state, CompoundNBT compound) {
        CompoundNBT energyTag = compound.getCompound("energy");
        energy.ifPresent(h -> ((INBTSerializable<CompoundNBT>) h).deserializeNBT(energyTag));
        super.load(state, compound);
    }

    @SuppressWarnings("unchecked")
    @Override
    public CompoundNBT save(CompoundNBT compound) {
        energy.ifPresent(h ->
        {
            CompoundNBT tag = ((INBTSerializable<CompoundNBT>) h).serializeNBT();
            compound.put("energy", tag);
        });
        return super.save(compound);
    }



    @Nullable
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        {
            return new BatteryContainer(id, playerEntity, playerInventory ,this, levelBattery);
        }
    }


    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(this.getBlockState().getBlock().getDescriptionId());
    }


    private int getEnergy()
    {
        return getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getEnergyStored).orElse(0);
    }
    private int getMaxEnergy()
    {
        return getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getMaxEnergyStored).orElse(0);
    }



}

