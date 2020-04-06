package com.SHARKY2023.EngineeringReimagined.registration.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.registration.WrappedDeferredRegister;
import com.SHARKY2023.EngineeringReimagined.util.providers.IItemProvider;

import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemDeferredRegister extends WrappedDeferredRegister<Item> {

    private List<IItemProvider> allItems = new ArrayList<>();

    public ItemDeferredRegister(String modid) {
        super(modid, ForgeRegistries.ITEMS);
    }

    //TODO: Move this somewhere else? At least add a secondary one for unstackable
    public static Item.Properties getMekBaseProperties() {
        return new Item.Properties().group(EngineeringReimagined.TabCItems);
    }

    public ItemRegistryObject<Item> register(String name) {
        return register(name, () -> new Item(getMekBaseProperties()));
    }

    public <ITEM extends Item> ItemRegistryObject<ITEM> register(String name, Function<Item.Properties, ITEM> sup) {
        return register(name, () -> sup.apply(getMekBaseProperties()));
    }

    //TODO: Do we want this or do we want to make all of them require the above register method??
    public <ITEM extends Item> ItemRegistryObject<ITEM> register(String name, Supplier<? extends ITEM> sup) {
        ItemRegistryObject<ITEM> registeredItem = register(name, sup, ItemRegistryObject::new);
        allItems.add(registeredItem);
        return registeredItem;
    }

    public List<IItemProvider> getAllItems() {
        return allItems;
    }
}