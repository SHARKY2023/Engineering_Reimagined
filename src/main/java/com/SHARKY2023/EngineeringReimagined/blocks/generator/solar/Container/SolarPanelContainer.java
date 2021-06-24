package com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container;

import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanelTile;

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

    public SolarPanelContainer(ContainerType<?> type, int windowId, World world, BlockPos pos, PlayerEntity player)
    {
        super(type, windowId);
        this.tile = (SolarPanelTile) world.getBlockEntity(pos);
        this.player = player;
    }

    @Override
    public boolean stillValid(PlayerEntity playerIn)
    {
        return stillValid(IWorldPosCallable.create(tile.getLevel(), tile.getBlockPos()), player, tile.getBlockState().getBlock());
    }

 public int getEnergy() {
      return tile.getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getEnergyStored).orElse(0);
 }


}