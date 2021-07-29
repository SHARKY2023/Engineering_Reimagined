package com.SHARKY2023.EngineeringReimagined.util.providers;
import javax.annotation.Nonnull;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

public interface IBlockProvider extends IItemProvider {

    @Nonnull
    Block getBlock();

    default boolean blockMatches(ItemStack otherStack) {
        Item item = otherStack.getItem();
        return item instanceof BlockItem && blockMatches(((BlockItem) item).getBlock());
    }

    default boolean blockMatches(Block other) {
        return getBlock() == other;
    }

    @Override
    default ResourceLocation getRegistryName() {
        //Make sure to use the block's registry name in case it somehow doesn't match
        return getBlock().getRegistryName();
    }
/*
    @Override
    default String getTranslationKey() {
        return getBlock().getTranslationKey();
    }

    */
}