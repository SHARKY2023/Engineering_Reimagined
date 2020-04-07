package com.SHARKY2023.EngineeringReimagined.items;

import com.SHARKY2023.EngineeringReimagined.blocks.basic.BlockResource;
import com.SHARKY2023.EngineeringReimagined.items.block.ItemBlockER;
import com.SHARKY2023.EngineeringReimagined.resources.BlockResourceInfo;
import net.minecraft.item.ItemStack;

public class ItemBlockResource extends ItemBlockER<BlockResource> {

    public ItemBlockResource(BlockResource block) {
        super(block);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        // If this is a block of charcoal, set burn time to 16000 ticks (per Minecraft standard)
        //TODO: Move burn time into the resource info
        if (getBlock().getResourceInfo() == BlockResourceInfo.CHARCOAL) {
            return 16000; // ticks
        }
        return super.getBurnTime(itemStack);
    }
}