package com.SHARKY2023.EngineeringReimagined.blocks.generator.solar;

import com.SHARKY2023.EngineeringReimagined.energy.CustomEnergyStorage;
import com.SHARKY2023.EngineeringReimagined.energy.MyEnergyStorage;
import com.SHARKY2023.EngineeringReimagined.network.solar.PacketHandler;
import com.SHARKY2023.EngineeringReimagined.network.solar.UpdateSolarPanel;
import com.SHARKY2023.EngineeringReimagined.util.SolarPanelTier;
import com.SHARKY2023.EngineeringReimagined.util.SolarProduction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.network.PacketDistributor;

import javax.annotation.Nonnull;
import java.util.concurrent.atomic.AtomicInteger;

public class SolarPanelTile extends TileEntity implements ITickableTileEntity {


    // Energy
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergy);
    private int energyGeneration, maxEnergyOutput;
    public int maxEnergy;

    private SolarPanelTier tierSolarPanel;
    public int energyClient, energyProductionClient;

    public SolarPanelTile(SolarPanelTier tierSolarPanel, TileEntityType<?> tileEntitySolarPanel)
    {
        super(tileEntitySolarPanel);
        this.tierSolarPanel = tierSolarPanel;
        energyGeneration = (int) Math.pow(8, tierSolarPanel.ordinal());
        maxEnergyOutput = energyGeneration * 2;
        maxEnergy = energyGeneration * 1000;
        energyClient = energyProductionClient = -1;
    }
    private IEnergyStorage createEnergy()
    {
        return new MyEnergyStorage(maxEnergyOutput, maxEnergy);
    }

    @Override
    public void tick()
    {
        if(!world.isRemote)
        {
            energy.ifPresent(e -> ((MyEnergyStorage) e).generatePower(currentAmountEnergyProduced()));
            sendEnergy();
            if(energyClient != getEnergy() || energyProductionClient != currentAmountEnergyProduced())
            {
                int energyProduced = (getEnergy() != getMaxEnergy()) ? currentAmountEnergyProduced() : 0;
                PacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), new UpdateSolarPanel(getPos(), getEnergy(), energyProduced));
            }

        }
    }

    private int getMaxEnergy()
    {
        return getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getMaxEnergyStored).orElse(0);
    }

    private int getEnergy()
    {
        return getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getEnergyStored).orElse(0);
    }

    private int currentAmountEnergyProduced()
    {
        return (int) (energyGeneration * SolarProduction.computeSunIntensity(world, getPos(), tierSolarPanel));
    }


    private void sendEnergy() {
        energy.ifPresent(energy ->
        {
            AtomicInteger capacity = new AtomicInteger(energy.getEnergyStored());
            for (int i = 0; (i < Direction.values().length) && (capacity.get() > 0); i++) {
                Direction facing = Direction.values()[i];
                if (facing != Direction.UP) {
                    TileEntity tileEntity = world.getTileEntity(pos.offset(facing));
                    if (tileEntity != null) {
                        tileEntity.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite()).ifPresent(handler -> {
                            if (handler.canReceive()) {
                                int received = handler.receiveEnergy(Math.min(capacity.get(), maxEnergyOutput), false);
                                capacity.addAndGet(-received);
                                ((CustomEnergyStorage) energy).consumePower(received); }});}}}});
    }

    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, Direction facing) {
        if (capability == CapabilityEnergy.ENERGY && facing != Direction.UP) {
            return energy.cast(); }
        return super.getCapability(capability, facing);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void read(CompoundNBT compound)
    {
        CompoundNBT energyTag = compound.getCompound("energy");
        energy.ifPresent(h -> ((INBTSerializable<CompoundNBT>) h).deserializeNBT(energyTag));
        super.read(compound);
    }

    @SuppressWarnings("unchecked")
    @Override
    public CompoundNBT write(CompoundNBT compound)
    {
        energy.ifPresent(h ->
        {
            CompoundNBT tag = ((INBTSerializable<CompoundNBT>) h).serializeNBT();
            compound.put("energy", tag);
        });
        return super.write(compound);
    }
}





