package com.SHARKY2023.engineeringreimagined.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MachineBase extends Block {
    public MachineBase() {
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(3).harvestLevel(3).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL));
    }
}
