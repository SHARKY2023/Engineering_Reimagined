package com.SHARKY2023.EngineeringReimagined.blocks.generator.solar;


//import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.BasicSolarPanelContainer;
//import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanelContainer;
//import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.tier.AdvancedSolarPanelTile;
//import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.tier.BasicSolarPanelTile;
//import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.tier.UltimateSolarPanelTile;
import com.SHARKY2023.EngineeringReimagined.util.SolarPanelTier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SolarPanel extends Block {

    private SolarPanelTier levelSolarPanel;

    public SolarPanel(SolarPanelTier levelSolarPanel) {
            super(Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .strength(5.0f));

        this.levelSolarPanel = levelSolarPanel;
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
        public BlockEntity createTileEntity(BlockState state, BlockGetter world) {
            return new SolarPanelTile(levelSolarPanel);
        }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
    }
    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit)
    {
        if(!worldIn.isClientSide)
        {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if(tileEntity instanceof MenuProvider)
            {
                NetworkHooks.openGui((ServerPlayer) player, (MenuProvider) tileEntity, tileEntity.getBlockPos());
            }
            else
            {
                throw new IllegalStateException("Our named container provider is missing!");
            }
        }
        return InteractionResult.SUCCESS;
    }

        @Override
        protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
            builder.add(BlockStateProperties.FACING, BlockStateProperties.POWERED);
        }
}


