package com.SHARKY2023.EngineeringReimagined.blocks.generator.solar;


import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.BasicSolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.SolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.tier.AdvancedSolarPanelTile;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.tier.BasicSolarPanelTile;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.tier.UltimateSolarPanelTile;
import com.SHARKY2023.EngineeringReimagined.util.SolarPanelTier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class SolarPanel extends Block {

    private SolarPanelTier tierSolarPanel;

    public SolarPanel(SolarPanelTier tierSolarPanel) {
            super(Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .strength(5.0f));

        this.tierSolarPanel = tierSolarPanel;
        }
/*
        @Override
        public int getLightValue(BlockState state) {
            return state.get(BlockStateProperties.POWERED) ? super.getLightValue(state) : 0;
        }

 */

        @Override
        public boolean hasTileEntity(BlockState state) {return true;}

        @Nullable
        @Override
        public TileEntity createTileEntity(BlockState state, IBlockReader world) {
            switch (this.tierSolarPanel)
            {
                case Basic:
                    return new BasicSolarPanelTile();
                case Advanced:
                    return new AdvancedSolarPanelTile();
                case Ultimate:
                    return new UltimateSolarPanelTile();
                default:
                    return null;
            }
        }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return defaultBlockState().setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
    }
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
        if(!worldIn.isClientSide)
        {
            TileEntity tileEntity = worldIn.getBlockEntity(pos);
            if(tileEntity instanceof INamedContainerProvider)
            {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getBlockPos());
            }
            else
            {
                throw new IllegalStateException("Our named container provider is missing!");
            }
        }
        return ActionResultType.SUCCESS;
    }

        @Override
        protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
            builder.add(BlockStateProperties.FACING, BlockStateProperties.POWERED);
        }
}


