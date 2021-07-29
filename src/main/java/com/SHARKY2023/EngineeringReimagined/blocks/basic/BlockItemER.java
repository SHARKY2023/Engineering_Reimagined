package com.SHARKY2023.EngineeringReimagined.blocks.basic;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


public class BlockItemER extends BlockItem {

    private int burnTime;

    public BlockItemER(Block block, Item.Properties props) {

        super(block, props);
    }

    public BlockItemER(Block block) {
        this(block, new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined));
        setRegistryName(block.getRegistryName());

    }

    public BlockItemER setBurnTime(int burnTime)
    {
        this.burnTime = burnTime;
        return this;
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        return this.burnTime;
    }
}
