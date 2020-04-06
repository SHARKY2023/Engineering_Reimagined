package com.SHARKY2023.EngineeringReimagined.registration.impl;
import javax.annotation.Nonnull;

import com.SHARKY2023.EngineeringReimagined.registration.DoubleWrappedRegistryObject;
import com.SHARKY2023.EngineeringReimagined.util.providers.IBlockProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class BlockRegistryObject<BLOCK extends Block, ITEM extends Item> extends DoubleWrappedRegistryObject<BLOCK, ITEM> implements IBlockProvider {

    public BlockRegistryObject(RegistryObject<BLOCK> blockRegistryObject, RegistryObject<ITEM> itemRegistryObject) {
        super(blockRegistryObject, itemRegistryObject);
    }

    @Nonnull
    @Override
    public BLOCK getBlock() {
        return getPrimary();
    }

    @Nonnull
    @Override
    public ITEM getItem() {
        return getSecondary();
    }
}