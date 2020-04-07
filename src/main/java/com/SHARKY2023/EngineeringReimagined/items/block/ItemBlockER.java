package com.SHARKY2023.EngineeringReimagined.items.block;

import javax.annotation.Nonnull;
import com.SHARKY2023.EngineeringReimagined.registration.impl.ItemDeferredRegister;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ItemBlockER<BLOCK extends Block> extends BlockItem {

    @Nonnull
    private final BLOCK block;

    public ItemBlockER(@Nonnull BLOCK block) {
        this(block, ItemDeferredRegister.getMekBaseProperties());
    }

    public ItemBlockER(@Nonnull BLOCK block, Item.Properties properties) {
        super(block, properties);
        this.block = block;
    }

    @Nonnull
    @Override
    public BLOCK getBlock() {
        return block;
    }
}