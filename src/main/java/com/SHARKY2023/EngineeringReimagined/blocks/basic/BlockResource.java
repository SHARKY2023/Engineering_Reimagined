package com.SHARKY2023.EngineeringReimagined.blocks.basic;

import com.SHARKY2023.EngineeringReimagined.resources.BlockResourceInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;

public class BlockResource extends Block {

    public BlockResource() {
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f,10.0f).lightValue(0)
                .harvestTool(ToolType.PICKAXE).harvestLevel(2));

    }
}

