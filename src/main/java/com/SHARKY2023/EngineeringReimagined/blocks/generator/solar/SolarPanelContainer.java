package com.SHARKY2023.EngineeringReimagined.blocks.generator.solar;

import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanelTile;

import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import com.SHARKY2023.EngineeringReimagined.util.SolarPanelTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;


public class SolarPanelContainer extends Container {

    public final SolarPanelTile tile;
    private final PlayerEntity player;

    public SolarPanelContainer(int windowId, PlayerEntity player, SolarPanelTile tile, SolarPanelTier level)
    {
        super(Registration.SOLAR_PANEL_CONTAINER.get(level).get(), windowId);
        this.tile = tile;
        this.player = player;
    }

    @Override
    public boolean stillValid(PlayerEntity playerIn)
    {
        return stillValid(IWorldPosCallable.create(tile.getLevel(), tile.getBlockPos()), player, tile.getBlockState().getBlock());
    }
}