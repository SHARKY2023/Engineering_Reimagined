package com.SHARKY2023.EngineeringReimagined.registries;

import com.SHARKY2023.EngineeringReimagined.blocks.basic.BlockResource;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.sterling.SterlingBlock;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.sterling.SterlingContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.sterling.SterlingTile;
import com.SHARKY2023.EngineeringReimagined.items.ItemBase;
import com.SHARKY2023.EngineeringReimagined.resources.BlockResourceInfo;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.SHARKY2023.EngineeringReimagined.EngineeringReimagined.MOD_ID;


public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MOD_ID);
    private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MOD_ID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);
    private static final DeferredRegister<ModDimension> DIMENSIONS = DeferredRegister.create(ForgeRegistries.MOD_DIMENSIONS, MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());;
    }

//Blocks
    public static final RegistryObject<SterlingBlock> STERLING_GENERATOR = BLOCKS.register("sterlinggenerator", SterlingBlock::new);

    public static final RegistryObject<BlockResource> SILVER_BLOCK = BLOCKS.register("block_silver", BlockResourceInfo.SILVER::new);
    public static final RegistryObject<BlockResource> BRONZE_BLOCK = BLOCKS.register(BlockResourceInfo.BRONZE);
    public static final RegistryObject<BlockResource> INVAR_BLOCK = BLOCKS.register(BlockResourceInfo.INVAR);
    public static final RegistryObject<BlockResource> CHARCOAL_BLOCK = BLOCKS.register(BlockResourceInfo.CHARCOAL);
    public static final RegistryObject<BlockResource> ALUMINUM_BLOCK = BLOCKS.register(BlockResourceInfo.ALUMINIUM);
    public static final RegistryObject<BlockResource> STEEL_BLOCK = BLOCKS.register(BlockResourceInfo.STEEL);
    public static final RegistryObject<BlockResource> COPPER_BLOCK = BLOCKS.register(BlockResourceInfo.COPPER);
    public static final RegistryObject<BlockResource> TIN_BLOCK = BLOCKS.register(BlockResourceInfo.TIN);
    public static final RegistryObject<BlockResource> NICKEL_BLOCK = BLOCKS.register(BlockResourceInfo.NICKEL);
    public static final RegistryObject<BlockResource> LEAD_BLOCK = BLOCKS.register(BlockResourceInfo.LEAD);
    public static final RegistryObject<BlockResource> ZINC_BLOCK = BLOCKS.register(BlockResourceInfo.ZINC);
    public static final RegistryObject<BlockResource> BRASS_BLOCK = BLOCKS.register(BlockResourceInfo.BRASS);
    public static final RegistryObject<BlockResource> URANIUM_BLOCK = BLOCKS.register(BlockResourceInfo.URANIUM);
    public static final RegistryObject<BlockResource> ELECTRUM_BLOCK = BLOCKS.register(BlockResourceInfo.ELECTRUM);
    public static final RegistryObject<BlockResource> PLATINUM_BLOCK = BLOCKS.register(BlockResourceInfo.PLATINUM)




    public static final RegistryObject<TileEntityType<SterlingTile>> STERLING_TILE = TILES.register("sterlinggenerator", () -> TileEntityType.Builder.create(SterlingTile::new, STERLING_GENERATOR.get()).build(null));







//Containers
    public static final RegistryObject<ContainerType<SterlingContainer>> STERLING_CONTAINER = CONTAINERS.register("sterlinggenerator", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new SterlingContainer(windowId, world, pos, inv, inv.player);
    }));







//Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", ItemBase::new);

    //Ingots
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", ItemBase::new);
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", ItemBase::new);
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", ItemBase::new);
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", ItemBase::new);
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", ItemBase::new);
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", ItemBase::new);
    public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot", ItemBase::new);
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", ItemBase::new);
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", ItemBase::new);
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", ItemBase::new);
    public static final RegistryObject<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot", ItemBase::new);
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", ItemBase::new);

    //Gear
    public static final RegistryObject<Item> COPPER_GEAR = ITEMS.register("copper_gear", ItemBase::new);
    public static final RegistryObject<Item> TIN_GEAR = ITEMS.register("tin_gear", ItemBase::new);
    public static final RegistryObject<Item> STEEL_GEAR = ITEMS.register("steel_gear", ItemBase::new);
    public static final RegistryObject<Item> BRONZE_GEAR = ITEMS.register("bronze_gear", ItemBase::new);
    public static final RegistryObject<Item> ZINC_GEAR = ITEMS.register("zinc_gear", ItemBase::new);
    public static final RegistryObject<Item> BRASS_GEAR = ITEMS.register("brass_gear", ItemBase::new);
    public static final RegistryObject<Item> PLATINUM_GEAR = ITEMS.register("platinum_gear", ItemBase::new);
    public static final RegistryObject<Item> LEAD_GEAR = ITEMS.register("lead_gear", ItemBase::new);
    public static final RegistryObject<Item> SILVER_GEAR = ITEMS.register("silver_gear", ItemBase::new);
    public static final RegistryObject<Item> ELECTRUM_GEAR = ITEMS.register("electrum_gear", ItemBase::new);
    public static final RegistryObject<Item> NICKEL_GEAR = ITEMS.register("nickel_gear", ItemBase::new);

    //Plate
    public static final RegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate", ItemBase::new);
    public static final RegistryObject<Item> TIN_PLATE = ITEMS.register("tin_plate", ItemBase::new);
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", ItemBase::new);
    public static final RegistryObject<Item> BRONZE_PLATE = ITEMS.register("bronze_plate", ItemBase::new);
    public static final RegistryObject<Item> ZINC_PLATE = ITEMS.register("zinc_plate", ItemBase::new);
    public static final RegistryObject<Item> BRASS_PLATE = ITEMS.register("brass_plate", ItemBase::new);
    public static final RegistryObject<Item> PLATINUM_PLATE = ITEMS.register("platinum_plate", ItemBase::new);
    public static final RegistryObject<Item> LEAD_PLATE = ITEMS.register("lead_plate", ItemBase::new);
    public static final RegistryObject<Item> SILVER_PLATE = ITEMS.register("silver_plate", ItemBase::new);
    public static final RegistryObject<Item> ELECTRUM_PLATE = ITEMS.register("electrum_plate", ItemBase::new);
    public static final RegistryObject<Item> NICKEL_PLATE = ITEMS.register("nickel_plate", ItemBase::new);
    public static final RegistryObject<Item> BASIC_CIRCUIT = ITEMS.register("basic_circuit", ItemBase::new);

    //Crafting Items
    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber", ItemBase::new);
    public static final RegistryObject<Item> CONDUIT_CASING = ITEMS.register("conduit_casing", ItemBase::new);
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", ItemBase::new);
    public static final RegistryObject<Item> ADV_CIRCUIT = ITEMS.register("advanced_circuit", ItemBase::new);

}


























