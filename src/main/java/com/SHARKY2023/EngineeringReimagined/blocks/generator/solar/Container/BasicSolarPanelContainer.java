package com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container;

import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BasicSolarPanelContainer extends SolarPanelContainer {

    public BasicSolarPanelContainer(int windowId, World world, BlockPos pos, PlayerInventory inv, PlayerEntity player)
    {
        super(Registration.BASIC_SOLAR_CONTAINER.get(), windowId, world, pos, player);
    }
}

