package com.SHARKY2023.EngineeringReimagined.util.providers;
import com.SHARKY2023.EngineeringReimagined.util.providers.IBaseProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public interface IItemProvider extends IBaseProvider, net.minecraft.util.IItemProvider {

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