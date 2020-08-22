package com.SHARKY2023.EngineeringReimagined.blocks.battery.Container;


import com.SHARKY2023.EngineeringReimagined.blocks.battery.tile.BatteryTile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BatteryContainer extends Container {

        public final BatteryTile tile;
        private final PlayerEntity player;

        public BatteryContainer(ContainerType<?> type, int windowId, World world, BlockPos pos, PlayerEntity player)
        {
            super(type, windowId);
            this.tile = (BatteryTile) world.getTileEntity(pos);
            this.player = player;
        }

        @Override
        public boolean canInteractWith(PlayerEntity playerIn)
        {
            return isWithinUsableDistance(IWorldPosCallable.of(tile.getWorld(), tile.getPos()), player, tile.getBlockState().getBlock());
        }
}
