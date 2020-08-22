package com.SHARKY2023.EngineeringReimagined.blocks.battery.Container;

import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AdvancedBatteryContainer extends BatteryContainer{

    public AdvancedBatteryContainer(int windowId, World world, BlockPos pos, PlayerEntity player)
    {
        super(Registration.ADVANCED_BATTERY_CONTAINER.get(), windowId, world, pos, player);
    }
}