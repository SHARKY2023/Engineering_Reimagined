package com.SHARKY2023.EngineeringReimagined.blocks.basic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;

public class BlockResource extends BlockMekanism {

    @Nonnull
    private final BlockResourceo resource;

    //TODO: Isn't as "generic"? So make it be from one BlockType thing?
    public BlockResource(@Nonnull BlockResource resource) {
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(resource.getHardness(), resource.getResistance()).lightValue(resource.getLightValue())
                .harvestTool(ToolType.PICKAXE).harvestLevel(resource.getHarvestLevel()));
        this.resource = resource;
    }

    @Nonnull
    public BlockResource getResource() {
        return resource;
    }
}
