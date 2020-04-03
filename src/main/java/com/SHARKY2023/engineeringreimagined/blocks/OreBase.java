package com.SHARKY2023.engineeringreimagined.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class OreBase extends OreBlock {
    public OreBase() {
        super(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE));
    }
}
