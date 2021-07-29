package com.SHARKY2023.EngineeringReimagined.blocks.capacitor;

import com.SHARKY2023.EngineeringReimagined.config.Config;
import com.SHARKY2023.EngineeringReimagined.energy.CustomEnergyStorage;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

import static com.SHARKY2023.EngineeringReimagined.registries.Registration.CAPACITOR_TILE;

public class CapacitorTile extends TileEntity implements IEnergyStorage, ICapabilityProvider, ITickableTileEntity {

    public int capacity;
  //  private int extract;
  //  private int transfer;


    public CapacitorTile() {
        super(CAPACITOR_TILE.get());

        capacity = 20000000;
        energyStorage = new CustomEnergyStorage(20000,20000,20000000);
    }

    CustomEnergyStorage energyStorage;
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);

  /*  private CustomEnergyStorage createEnergy() {
        return new CustomEnergyStorage(2000,2000, 20000000) {
            @Override
            protected void onEnergyChanged() {
                setChanged();
            }
        };
    }

   */


    @Override
    public void tick() {
        sendOutPower();
    }

    private void sendOutPower() {
        AtomicInteger capacity = new AtomicInteger(energyStorage.getEnergyStored());
        if (capacity.get() > 0) {
            for (Direction direction : Direction.values()) {
                TileEntity te = level.getBlockEntity(worldPosition.relative(direction));
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
        energyStorage.deserializeNBT(tag.getCompound("energy"));

        super.load(state, tag);
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.put("energy", energyStorage.serializeNBT());

        return super.save(tag);
    }


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
        return 0;
    }

    @Override
    public int getMaxEnergyStored() {
        return 0;
    }

    @Override
    public boolean canExtract() {
        return true;
    }

    @Override
    public boolean canReceive() {
        return true;
    }



    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap.equals(CapabilityEnergy.ENERGY)) {
            return energy.cast();
        }
        return super.getCapability(cap, side);
    }
}
