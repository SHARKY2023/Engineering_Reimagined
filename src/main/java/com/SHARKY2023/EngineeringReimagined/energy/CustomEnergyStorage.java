package com.SHARKY2023.EngineeringReimagined.energy;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.energy.EnergyStorage;

public class CustomEnergyStorage extends EnergyStorage implements INBTSerializable<CompoundNBT> {

    public CustomEnergyStorage(int energyTransfer, int energyCapacity)
    {
        super(energyCapacity, energyTransfer);
        this.maxReceive = 0;
    }
    public CustomEnergyStorage(int energyTransfer,int energyReceive, int energyCapacity)
    {
        super(energyCapacity, energyReceive, energyTransfer);

    }
    public void setEnergy(int energy)
    {
        this.energy = energy;
    }

    public void generatePower(int energy)
    {
        this.energy += energy;
        if(this.energy > capacity)
            this.energy = capacity;
    }

    public void consumePower(int energy)
    {
        this.energy -= energy;
        if(this.energy < 0)
        {
            this.energy = 0;
        }
    }

    public boolean isFullEnergy()
    {
        return getEnergyStored() >= getMaxEnergyStored();
    }

    @Override
    public CompoundNBT serializeNBT()
    {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("value", getEnergyStored());
        return tag;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate)
    {
        return super.extractEnergy(maxExtract, simulate);
    }








    @Override
    public void deserializeNBT(CompoundNBT nbt)
    {
        setEnergy(nbt.getInt("value"));
    }
}

 /*   public CustomEnergyStorage(int maxTransferOut, int capacity) {

        super(maxTransferOut, capacity);
        this.maxReceive = 0;
    }
    public CustomEnergyStorage(int maxTransferOut, int maxTransferIn, int capacity) {

        super(maxTransferOut, maxTransferIn,capacity);
    }

    public void setEnergy(int energy) {
        this.energy = energy;

    }

    public void generatePower(int energy) {
        this.energy += energy;
        if (this.energy > capacity) {
            this.energy = capacity;
        }
    }

    public void consumePower(int energy) {
        this.energy -= energy;
        if (this.energy < 0) {
            this.energy = 0;
        }

    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate)
    {
        return super.extractEnergy(maxExtract, simulate);
    }

    public int getEnergyStored(ItemStack container)
    {
        if(container.getTag() == null)
            return 0;
        return container.getTag().getInt("energy");
    }

    @Override
    public int getMaxEnergyStored()
    {
        return super.getMaxEnergyStored();
    }


    @Override
    public boolean canExtract()
    {
        return super.canExtract();
    }

    @Override
    public boolean canReceive()
    {
        return super.canReceive();
    }

    public boolean isFullEnergy()
    { return getEnergyStored() >= getMaxEnergyStored(); }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("energy", getEnergyStored());
        return tag;
    }


    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        setEnergy(nbt.getInt("energy"));
    }



}

  */

