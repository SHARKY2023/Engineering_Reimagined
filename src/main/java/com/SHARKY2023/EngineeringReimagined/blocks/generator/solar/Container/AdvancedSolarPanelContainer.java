package com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container;

import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AdvancedSolarPanelContainer extends SolarPanelContainer{

    public AdvancedSolarPanelContainer(int windowId, World world, BlockPos pos, PlayerEntity player)
    {
        super(Registration.ADVANCED_SOLAR_CONTAINER.get(), windowId, world, pos, player);
    }
}


