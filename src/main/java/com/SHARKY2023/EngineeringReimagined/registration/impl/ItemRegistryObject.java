package com.SHARKY2023.EngineeringReimagined.registration.impl;

import javax.annotation.Nonnull;

import com.SHARKY2023.EngineeringReimagined.registration.WrappedRegistryObject;
import com.SHARKY2023.EngineeringReimagined.util.providers.IItemProvider;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ItemRegistryObject<ITEM extends Item> extends WrappedRegistryObject<ITEM> implements IItemProvider {

    public ItemRegistryObject(RegistryObject<ITEM> registryObject) {
        super(registryObject);
    }

    @Nonnull
    @Override
    public ITEM getItem() {
        return get();
    }
}