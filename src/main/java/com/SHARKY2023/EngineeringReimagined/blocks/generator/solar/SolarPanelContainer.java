package com.SHARKY2023.EngineeringReimagined.blocks.generator.solar;

import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanelTile;

import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import com.SHARKY2023.EngineeringReimagined.util.SolarPanelTier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;


public class SolarPanelContainer extends AbstractContainerMenu {

    public final SolarPanelTile tile;
    private final Player player;

    public SolarPanelContainer(int windowId, Player player, SolarPanelTile tile, SolarPanelTier level)
    {
        super(Registration.SOLAR_PANEL_CONTAINER.get(level).get(), windowId);
        this.tile = tile;
        this.player = player;
    }

    @Override
    public boolean stillValid(Player playerIn)
    {
        return stillValid(ContainerLevelAccess.create(tile.getLevel(), tile.getBlockPos()), player, tile.getBlockState().getBlock());
    }
}