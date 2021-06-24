package com.SHARKY2023.EngineeringReimagined.blocks.battery;


import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanelTile;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import com.SHARKY2023.EngineeringReimagined.util.SolarPanelTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BatteryContainer extends Container {

        public final BatteryTile tile;
        private final PlayerEntity player;

        public BatteryContainer(int windowId, PlayerEntity player, BatteryTile tile, BatteryTier level)
        {
            super(Registration.BATTERY_CONTAINER.get(level).get(), windowId);
            this.tile = tile;
            this.player = player;
        }

        @Override
        public boolean stillValid(PlayerEntity playerIn)
        {
            return stillValid(IWorldPosCallable.create(tile.getLevel(), tile.getBlockPos()), player, tile.getBlockState().getBlock());
        }
}
