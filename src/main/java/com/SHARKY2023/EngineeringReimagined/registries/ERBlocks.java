package com.SHARKY2023.EngineeringReimagined.registries;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.blocks.basic.BlockResource;
import com.SHARKY2023.EngineeringReimagined.items.ItemBlockResource;
import com.SHARKY2023.EngineeringReimagined.registration.impl.BlockDeferredRegister;
import com.SHARKY2023.EngineeringReimagined.registration.impl.BlockRegistryObject;
import com.SHARKY2023.EngineeringReimagined.resources.BlockResourceInfo;


public class ERBlocks {

    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(EngineeringReimagined.MOD_ID);

   public static final BlockRegistryObject<BlockResource, ItemBlockResource> SILVER_BLOCK = registerResourceBlock(BlockResourceInfo.SILVER);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> BRONZE_BLOCK = registerResourceBlock(BlockResourceInfo.BRONZE);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> INVAR_BLOCK = registerResourceBlock(BlockResourceInfo.INVAR);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> CHARCOAL_BLOCK = registerResourceBlock(BlockResourceInfo.CHARCOAL);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> ALUMINUM_BLOCK = registerResourceBlock(BlockResourceInfo.ALUMINIUM);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> STEEL_BLOCK = registerResourceBlock(BlockResourceInfo.STEEL);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> COPPER_BLOCK = registerResourceBlock(BlockResourceInfo.COPPER);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> TIN_BLOCK = registerResourceBlock(BlockResourceInfo.TIN);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> NICKEL_BLOCK = registerResourceBlock(BlockResourceInfo.NICKEL);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> LEAD_BLOCK = registerResourceBlock(BlockResourceInfo.LEAD);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> ZINC_BLOCK = registerResourceBlock(BlockResourceInfo.ZINC);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> BRASS_BLOCK = registerResourceBlock(BlockResourceInfo.BRASS);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> URANIUM_BLOCK = registerResourceBlock(BlockResourceInfo.URANIUM);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> ELECTRUM_BLOCK = registerResourceBlock(BlockResourceInfo.ELECTRUM);
    public static final BlockRegistryObject<BlockResource, ItemBlockResource> PLATINUM_BLOCK = registerResourceBlock(BlockResourceInfo.PLATINUM);
























    private static BlockRegistryObject<BlockResource, ItemBlockResource> registerResourceBlock(BlockResourceInfo resource) {
        return BLOCKS.register("block_" + resource.getRegistrySuffix(), () -> new BlockResource(resource), ItemBlockResource::new);
    }

}
