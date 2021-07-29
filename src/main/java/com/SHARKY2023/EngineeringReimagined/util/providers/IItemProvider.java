package com.SHARKY2023.EngineeringReimagined.util.providers;
import com.SHARKY2023.EngineeringReimagined.util.providers.IBaseProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public interface IItemProvider extends IBaseProvider, net.minecraft.world.level.ItemLike {

    @Nonnull
    Item getItem();

    @Nonnull
    @Override
    default Item asItem() {
        return getItem();
    }

    @Nonnull
    default ItemStack getItemStack() {
        return getItemStack(1);
    }

    @Nonnull
    default ItemStack getItemStack(int size) {
        return new ItemStack(getItem(), size);
    }

    default boolean itemMatches(ItemStack otherStack) {
        return itemMatches(otherStack.getItem());
    }

    default boolean itemMatches(Item other) {
        return getItem() == other;
    }

    @Override
    default ResourceLocation getRegistryName() {
        return getItem().getRegistryName();
    }

}