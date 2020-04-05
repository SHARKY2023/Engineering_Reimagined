package com.SHARKY2023.EngineeringReimagined.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockBase  extends Block {
    public BlockBase() {
        super(Block.Properties.create(Material.ROCK).hardnessAndResistance(3).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE));
    }
}
