package com.SHARKY2023.EngineeringReimagined.registries;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.registration.impl.BlockDeferredRegister;
import com.SHARKY2023.EngineeringReimagined.resources.BlockResource;


public class ERBlocks {

    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(EngineeringReimagined.MOD_ID);

    public static final BlockRegistryObject<BlockResource, ItemBlockResource> OSMIUM_BLOCK = registerResourceBlock(BlockResourceInfo.OSMIUM);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> BRONZE_BLOCK = registerResourceBlock(BlockResourceInfo.BRONZE);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> REFINED_OBSIDIAN_BLOCK = registerResourceBlock(BlockResourceInfo.REFINED_OBSIDIAN);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> CHARCOAL_BLOCK = registerResourceBlock(BlockResourceInfo.CHARCOAL);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> REFINED_GLOWSTONE_BLOCK = registerResourceBlock(BlockResourceInfo.REFINED_GLOWSTONE);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> STEEL_BLOCK = registerResourceBlock(BlockResourceInfo.STEEL);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> COPPER_BLOCK = registerResourceBlock(BlockResourceInfo.COPPER);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> TIN_BLOCK = registerResourceBlock(BlockResourceInfo.TIN);



}
