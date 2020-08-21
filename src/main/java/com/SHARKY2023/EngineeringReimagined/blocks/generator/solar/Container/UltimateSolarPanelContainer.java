package com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container;

import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UltimateSolarPanelContainer extends SolarPanelContainer{

    public UltimateSolarPanelContainer(int windowId, World world, BlockPos pos, PlayerInventory inv, PlayerEntity player)
    {
        super(Registration.ULTIMATE_SOLAR_CONTAINER.get(), windowId, world, pos, player);
    }
}

