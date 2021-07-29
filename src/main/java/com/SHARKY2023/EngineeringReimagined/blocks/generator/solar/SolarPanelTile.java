package com.SHARKY2023.EngineeringReimagined.blocks.generator.solar;

//import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.AdvancedSolarPanelContainer;
//import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.BasicSolarPanelContainer;
//import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.UltimateSolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.energy.CustomEnergyStorage;
import com.SHARKY2023.EngineeringReimagined.network.PacketHandler;
import com.SHARKY2023.EngineeringReimagined.network.packet.UpdateSolarPanel;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import com.SHARKY2023.EngineeringReimagined.util.ProductionSolarPanel;
import com.SHARKY2023.EngineeringReimagined.util.SolarPanelTier;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.TickableBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.network.PacketDistributor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

public class SolarPanelTile extends BlockEntity implements TickableBlockEntity, MenuProvider {

    // Energy
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergy);
    private int energyGeneration, maxEnergyOutput;
    public int maxEnergy;

    private SolarPanelTier levelSolarPanel;
    public int energyClient, energyProductionClient;

    public SolarPanelTile(SolarPanelTier levelSolarPanel)
    {
        super(Registration.SOLAR_PANEL_TILE.get(levelSolarPanel).get());
        this.levelSolarPanel = levelSolarPanel;
        energyGeneration = (int) Math.pow(8, levelSolarPanel.ordinal());
        maxEnergyOutput = energyGeneration * 2;
        maxEnergy = energyGeneration * 1000;
        energyClient = energyProductionClient = -1;
    }



    private IEnergyStorage createEnergy()
    {
        return new CustomEnergyStorage(maxEnergyOutput, maxEnergy);
    }

    @Override
    public void tick()
    {
        if(!level.isClientSide)
        {
            energy.ifPresent(e -> ((CustomEnergyStorage) e).generatePower(currentAmountEnergyProduced()));
            sendEnergy();
            if(energyClient != getEnergy() || energyProductionClient != currentAmountEnergyProduced())
            {
                int energyProduced = (getEnergy() != getMaxEnergy()) ? currentAmountEnergyProduced() : 0;
                PacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), new UpdateSolarPanel(getBlockPos(), getEnergy(), energyProduced));
            }
        }

        sendEnergy();
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
        return (int) (energyGeneration * ProductionSolarPanel.computeSunIntensity(level, worldPosition, levelSolarPanel));
    }

    private void sendEnergy()
    {
        energy.ifPresent(energy -> {
            AtomicInteger capacity = new AtomicInteger(energy.getEnergyStored());

            for(int i = 0; (i < Direction.values().length) && (capacity.get() > 0); i++)
            {
                Direction facing = Direction.values()[i];
                if(facing != Direction.UP)
                {
                    BlockEntity tileEntity = level.getBlockEntity(worldPosition.relative(facing));
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
    public void load(BlockState state, CompoundTag compound)
    {
        CompoundTag energyTag = compound.getCompound("energy");
        energy.ifPresent(h -> ((INBTSerializable<CompoundTag>) h).deserializeNBT(energyTag));
        super.load(state, compound);
    }

    @SuppressWarnings("unchecked")
    @Override
    public CompoundTag save(CompoundTag compound)
    {
        energy.ifPresent(h -> {
            CompoundTag tag = ((INBTSerializable<CompoundTag>) h).serializeNBT();
            compound.put("energy", tag);
        });
        return super.save(compound);
    }
    @Nullable
    public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player playerEntity) {
        {
            return new SolarPanelContainer(id, playerEntity, this, levelSolarPanel);
        }
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(this.getBlockState().getBlock().getDescriptionId());
    }

}




