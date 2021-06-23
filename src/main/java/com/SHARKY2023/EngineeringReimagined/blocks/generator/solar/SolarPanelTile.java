package com.SHARKY2023.EngineeringReimagined.blocks.generator.solar;

import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.AdvancedSolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.BasicSolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.UltimateSolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.config.Config;
import com.SHARKY2023.EngineeringReimagined.energy.CustomEnergyStorage;
import com.SHARKY2023.EngineeringReimagined.network.PacketHandler;
import com.SHARKY2023.EngineeringReimagined.network.packet.UpdateSolarPanel;
import com.SHARKY2023.EngineeringReimagined.util.SolarPanelTier;
import com.SHARKY2023.EngineeringReimagined.util.SolarProduction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.network.PacketDistributor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

public class SolarPanelTile extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

    // Energy
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergy);
    private int energyGeneration, maxEnergyOutput;
    public int maxEnergy, capacity;
    private CustomEnergyStorage energyStorage = (CustomEnergyStorage) createEnergy();

    private SolarPanelTier tierSolarPanel;
    public int energyClient, energyProductionClient;

    public SolarPanelTile(SolarPanelTier tierSolarPanel, TileEntityType<?> SolarPanelTile) {
        super(SolarPanelTile);
        this.tierSolarPanel = tierSolarPanel;
        energyGeneration = (int) Math.pow(8, tierSolarPanel.ordinal());
        maxEnergyOutput = energyGeneration * 2;
        maxEnergy = energyGeneration * 1000;
        energyClient = energyProductionClient = -1;
    }

    private IEnergyStorage createEnergy() {
        return new CustomEnergyStorage(maxEnergyOutput, maxEnergy);
    }

    @Override
    public void tick() {
        if (!level.isClientSide) {

        energy.ifPresent(e -> ((CustomEnergyStorage) e).generatePower(currentAmountEnergyProduced()));
        sendEnergy();
        if (energyClient != getEnergy() || energyProductionClient != currentAmountEnergyProduced()) {
            int energyProduced = (getEnergy() != getMaxEnergy()) ? currentAmountEnergyProduced() : 0;
            PacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), new UpdateSolarPanel(getBlockPos(), getEnergy(), energyProduced)); }
            if ( energyClient >= maxEnergy ){
                cullEnergyStored();}
                }}


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
        return (int) (energyGeneration * SolarProduction.computeSunIntensity(level, getBlockPos(), tierSolarPanel));
    }

   public void setEnergyStored(int energy) {
         energyClient = Math.max(0, energy);
    }

    public void cullEnergyStored() {
       if (energyClient > maxEnergy) {
           setEnergyStored(maxEnergy);
       }}


    private void sendEnergy()
    {
        energy.ifPresent(energy -> {
            AtomicInteger capacity = new AtomicInteger(energy.getEnergyStored());

            for(int i = 0; (i < Direction.values().length) && (capacity.get() > 0); i++)
            {
                Direction facing = Direction.values()[i];
                if(facing != Direction.UP)
                {
                    TileEntity tileEntity = level.getBlockEntity(worldPosition.relative(facing));
                    if(tileEntity != null)
                    {
                        tileEntity.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite()).ifPresent(handler -> {
                            if(handler.canReceive())
                            {
                                int received = handler.receiveEnergy(Math.min(capacity.get(), maxEnergyOutput), false);
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
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, Direction facing)
    {
        if(capability == CapabilityEnergy.ENERGY && facing != Direction.UP)
        {
            return energy.cast();
        }
        return super.getCapability(capability, facing);
    }

        @SuppressWarnings("unchecked")
        @Override
        public void load(BlockState state, CompoundNBT compound)
        {
            CompoundNBT energyTag = compound.getCompound("energy");
            energy.ifPresent(h -> ((INBTSerializable<CompoundNBT>) h).deserializeNBT(energyTag));
            super.load(state, compound);
        }

        @SuppressWarnings("unchecked")
        @Override
        public CompoundNBT save(CompoundNBT compound)
        {
            energy.ifPresent(h -> {
                CompoundNBT tag = ((INBTSerializable<CompoundNBT>) h).serializeNBT();
                compound.put("energy", tag);
            });
            return super.save(compound);
        }
    @Nullable
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity)
    {
        switch (tierSolarPanel)
        {
            case Basic:
                return new BasicSolarPanelContainer(id, level, getBlockPos(), playerEntity);
            case Advanced:
                return new AdvancedSolarPanelContainer(id, level, getBlockPos(), playerEntity);
            case Ultimate:
                return new UltimateSolarPanelContainer(id, level, getBlockPos(), playerEntity);
            default:
                return null;
        }
    }
    @Override
    public ITextComponent getDisplayName()
    {
        return new TranslationTextComponent(this.getBlockState().getBlock().getDescriptionId());
    }
}






