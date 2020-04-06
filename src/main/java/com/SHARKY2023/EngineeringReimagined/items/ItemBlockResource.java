package com.SHARKY2023.EngineeringReimagined.items;

import com.SHARKY2023.EngineeringReimagined.resources.BlockResource;
import mekanism.common.block.basic.BlockResource;
import net.minecraft.item.ItemStack;

public class ItemBlockResource extends ItemBlockMekanism<BlockResource> {

    public ItemBlockResource(BlockResource block) {
        super(block);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        // If this is a block of charcoal, set burn time to 16000 ticks (per Minecraft standard)
        //TODO: Move burn time into the resource info
        if (getBlock().getResourceInfo() == BlockResource.CHARCOAL) {
            return 16000; // ticks
        }
        return super.getBurnTime(itemStack);
    }
}