package com.SHARKY2023.EngineeringReimagined.energy;

import net.minecraft.item.ItemStack;
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

    public void generatePower(int energy) {
        {
            this.energy += energy;
            if (this.energy > capacity)
                this.energy = capacity;
        }
        onEnergyChanged();
    }

    public void consumePower(int energy)
    {{
        this.energy -= energy;
        if(this.energy < 0)
        {
            this.energy = 0;
        }
    }
    onEnergyChanged();
    }

    public boolean isFullEnergy()
    {
        return getEnergyStored() >= getMaxEnergyStored();
    }

    @Override
    public CompoundNBT serializeNBT()
    {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("energy", getEnergyStored());
        return tag;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate)
    {
        return super.extractEnergy(maxExtract, simulate);
    }


    protected void onEnergyChanged() {

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
    public void deserializeNBT(CompoundNBT nbt)
    {
        setEnergy(nbt.getInt("energy"));
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

}



