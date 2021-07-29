package com.SHARKY2023.EngineeringReimagined.blocks.battery;

import com.SHARKY2023.EngineeringReimagined.config.Config;
import com.SHARKY2023.EngineeringReimagined.energy.CustomEnergyStorage;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.TickableBlockEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
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

public class BatteryTile extends BlockEntity implements TickableBlockEntity, MenuProvider, IEnergyStorage {

    public int capacity;
    public int maxEnergy;
    private int maxTransfer;
    private int Energy;
    private int maxReceive;

    private CustomEnergyStorage energyStorage = createEnergy();

  //  private LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergy);
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
  //  private CustomEnergyStorage energyStorage = new CustomEnergyStorage(getMaxTransfer(),getMaxReceive(), getMaxEnergy());


    public int energyStored;
    public int energyReceived;

    private BatteryTier levelBattery;

    public BatteryTile(BatteryTier levelBattery) {
        super(Registration.BATTERY_TILE.get(levelBattery).get());
        this.levelBattery = levelBattery;
        maxEnergy = (int) Math.pow(levelBattery.ordinal() + 2, levelBattery.ordinal() + 2) * 64000;
        maxTransfer = (int) Math.pow(8, levelBattery.ordinal()) + 1;
       // energyStored = energyStoredClient =-1;
        maxTransfer = maxReceive;

    }

    @Override
    public void setRemoved() {
        super.setRemoved();
      //  handler.invalidate();
        energy.invalidate();
    }
    private CustomEnergyStorage createEnergy() {
        return new CustomEnergyStorage(getMaxTransfer(), getMaxEnergy()) {
        };
    }


    @Override
    public void tick() {
        if (!level.isClientSide) {
//
        //    if (canReceive() != true)
          //  receiveEnergy(maxReceive, false);
            //capacity = capacity + energyReceived;
        }
     //   receiveEnergy();
     //   extractEnergy();
        sendOutEnergy();

    }
 /*
    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int retval = super.receiveEnergy(maxReceive, simulate);
        if (!simulate) {
            setChanged();
            level.sendBlockUpdated(getBlockPos(), level.getBlockState(getBlockPos()), level.getBlockState(getBlockPos()), 2);
        }
        return retval;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int retval = super.extractEnergy(maxExtract, simulate);
        if (!simulate) {
            setChanged();
            level.sendBlockUpdated(getBlockPos(), level.getBlockState(getBlockPos()), level.getBlockState(getBlockPos()), 2);
        }
        return retval;
    }


  */

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return 0;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored() {
        return getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getEnergyStored).orElse(0);
    }

    @Override
    public int getMaxEnergyStored() {
        return maxEnergy;
        //return getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getMaxEnergyStored).orElse(0);
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return false;
    }


    private void sendOutEnergy() {
        AtomicInteger capacity = new AtomicInteger(energyStorage.getEnergyStored());
        if (capacity.get() > 0) {
            for (Direction direction : Direction.values()) {
                BlockEntity te = level.getBlockEntity(worldPosition.relative(direction));
                if (te != null) {
                    boolean doContinue = te.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
                                if (handler.canReceive()) {
                                    int received = handler.receiveEnergy(Math.min(capacity.get(), maxTransfer), false);
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
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, Direction facing) {
        if (capability == CapabilityEnergy.ENERGY) {
            return energy.cast();

        }
        return super.getCapability(capability, facing);
    }

@SuppressWarnings("unchecked")
    @Override
    public void load(BlockState state, CompoundTag compound) {
        CompoundTag energyTag = compound.getCompound("energy");
        energy.ifPresent(h -> ((INBTSerializable<CompoundTag>) h).deserializeNBT(energyTag));
        super.load(state, compound);
    }

    @SuppressWarnings("unchecked")
    @Override
    public CompoundTag save(CompoundTag compound) {
        energy.ifPresent(h ->
        {
            CompoundTag tag = ((INBTSerializable<CompoundTag>) h).serializeNBT();
            compound.put("energy", tag);
        });
        return super.save(compound);
    }



    @Nullable
    public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player playerEntity) {
        {
            return new BatteryContainer(id, playerEntity, playerInventory ,this, levelBattery);
        }
    }


    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(this.getBlockState().getBlock().getDescriptionId());
    }


    private int getEnergy()
    {
        return getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getEnergyStored).orElse(0);
    }
    private int getMaxEnergy()
    {
        return maxEnergy;
        //return getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getMaxEnergyStored).orElse(0);
    }
    private int getMaxTransfer()
    {
        return maxTransfer;
    }
    private int getMaxReceive()
    {
        return  maxReceive;
    }



/*


    @Override
    public int getEnergyStored() {
        return getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getEnergyStored).orElse(0);

    }

    @Override
    public int getMaxEnergyStored() {
        return getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getMaxEnergyStored).orElse(0);
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return true;
    }

 */

}

