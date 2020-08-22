package com.SHARKY2023.EngineeringReimagined.blocks.battery.tile;

import com.SHARKY2023.EngineeringReimagined.blocks.battery.BatteryTier;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.Container.AdvancedBatteryContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.Container.BasicBatteryContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.Container.UltimateBatteryContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.AdvancedSolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.BasicSolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.UltimateSolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.energy.CustomEnergyStorage;
import com.SHARKY2023.EngineeringReimagined.util.SolarProduction;
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
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

public class BatteryTile extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergy);


    private IEnergyStorage createEnergy()
    {
        return new CustomEnergyStorage(maxEnergyOut, maxEnergyIn, maxEnergy);
    }

    private int maxEnergyIn;
    private int maxEnergyOut;
    public int maxEnergy;
    public int energyStored, energyProductionClient;
    public int energyReceived;

    private BatteryTier tierBattery;

    public BatteryTile(BatteryTier tierBattery, TileEntityType<?> BatteryTile) {
        super(BatteryTile);
        this.tierBattery = tierBattery;
        maxEnergy = (int) Math.pow(8, tierBattery.ordinal());
        maxEnergyOut = (int) Math.pow(16, tierBattery.ordinal()) + 1;
        maxEnergyIn = maxEnergyOut;

    }




    private int maxEnergy() {
        return maxEnergy;
    }

    private int getMaxEnergy() {
        return getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getMaxEnergyStored).orElse(0);
    }

    private int getEnergy() {
        return getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getEnergyStored).orElse(0);
    }

    @Override
    public void tick() {

        energyStored = energyStored + energyReceived;
        sendEnergy();
       // if( getEnergy() != getMaxEnergy()? canRecieve()
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
                                int received = handler.receiveEnergy(Math.min(capacity.get(), maxEnergyOut), false);
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
    public void read(CompoundNBT compound) {
        CompoundNBT energyTag = compound.getCompound("energy");
        energy.ifPresent(h -> ((INBTSerializable<CompoundNBT>) h).deserializeNBT(energyTag));
        super.read(compound);
    }

    @SuppressWarnings("unchecked")
    @Override
    public CompoundNBT write(CompoundNBT compound) {
        energy.ifPresent(h ->
        {
            CompoundNBT tag = ((INBTSerializable<CompoundNBT>) h).serializeNBT();
            compound.put("energy", tag);
        });
        return super.write(compound);
    }

    @Nullable
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        switch (tierBattery) {
            case Basic:
                return new BasicBatteryContainer(id, world, pos, playerEntity);
            case Advanced:
                return new AdvancedBatteryContainer(id, world, pos, playerEntity);
            case Ultimate:
                return new UltimateBatteryContainer(id, world, pos, playerEntity);
            default:
                return null;
        }
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(this.getBlockState().getBlock().getTranslationKey());
    }

}