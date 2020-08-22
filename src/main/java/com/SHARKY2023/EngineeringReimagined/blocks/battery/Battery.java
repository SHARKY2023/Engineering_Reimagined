package com.SHARKY2023.EngineeringReimagined.blocks.battery;

import com.SHARKY2023.EngineeringReimagined.blocks.battery.tile.AdvancedBatteryTile;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.tile.BasicBatteryTile;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.tile.UltimateBatteryTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class Battery extends Block {

    private BatteryTier  tierBattery;

    public Battery(BatteryTier tierBattery) {
            super(Properties.create(Material.IRON)
            .sound(SoundType.METAL)
                .hardnessAndResistance(5.0f)
                .lightValue(14));
            this.tierBattery = tierBattery;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {return true;}

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        switch (this.tierBattery)
        {
            case Basic:
                return new BasicBatteryTile();
            case Advanced:
                return new AdvancedBatteryTile();
            case Ultimate:
                return new UltimateBatteryTile();
            default:
                return null;
        }
    }
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return getDefaultState().with(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
    }
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
        if(!worldIn.isRemote)
        {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(tileEntity instanceof INamedContainerProvider)
            {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getPos());
            }
            else
            {
                throw new IllegalStateException("Our named container provider is missing!");
            }
        }
        return ActionResultType.SUCCESS;
    }


    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING, BlockStateProperties.POWERED);
    }
}




