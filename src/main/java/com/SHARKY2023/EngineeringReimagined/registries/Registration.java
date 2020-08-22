package com.SHARKY2023.EngineeringReimagined.registries;


import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.blocks.basic.BlockMachine;
import com.SHARKY2023.EngineeringReimagined.blocks.basic.BlockResource;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.Battery;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.BatteryTier;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.Container.AdvancedBatteryContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.Container.BasicBatteryContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.Container.BatteryContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.Container.UltimateBatteryContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.tile.AdvancedBatteryTile;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.tile.BasicBatteryTile;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.tile.UltimateBatteryTile;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.AdvancedSolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.BasicSolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.UltimateSolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanel;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.Container.SolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.tier.AdvancedSolarPanelTile;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.tier.BasicSolarPanelTile;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.tier.UltimateSolarPanelTile;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.sterling.SterlingBlock;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.sterling.SterlingContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.sterling.SterlingTile;
import com.SHARKY2023.EngineeringReimagined.items.ItemBase;
import com.SHARKY2023.EngineeringReimagined.util.SolarPanelTier;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
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
        DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ;

    }

    //Blocks
    public static final RegistryObject<BlockResource> SILVER_BLOCK = BLOCKS.register("block_silver", BlockResource::new);
    public static final RegistryObject<BlockResource> BRONZE_BLOCK = BLOCKS.register("block_bronze", BlockResource::new);
    public static final RegistryObject<BlockResource> INVAR_BLOCK = BLOCKS.register("block_invar", BlockResource::new);
    public static final RegistryObject<BlockResource> CHARCOAL_BLOCK = BLOCKS.register("block_charcoal", BlockResource::new);
    public static final RegistryObject<BlockResource> ALUMINUM_BLOCK = BLOCKS.register("block_aluminum", BlockResource::new);
    public static final RegistryObject<BlockResource> STEEL_BLOCK = BLOCKS.register("block_steel", BlockResource::new);
    public static final RegistryObject<BlockResource> COPPER_BLOCK = BLOCKS.register("block_copper", BlockResource::new);
    public static final RegistryObject<BlockResource> TIN_BLOCK = BLOCKS.register("block_tin", BlockResource::new);
    public static final RegistryObject<BlockResource> NICKEL_BLOCK = BLOCKS.register("block_nickel", BlockResource::new);
    public static final RegistryObject<BlockResource> LEAD_BLOCK = BLOCKS.register("block_lead", BlockResource::new);
    public static final RegistryObject<BlockResource> ZINC_BLOCK = BLOCKS.register("block_zinc", BlockResource::new);
    public static final RegistryObject<BlockResource> BRASS_BLOCK = BLOCKS.register("block_brass", BlockResource::new);
    public static final RegistryObject<BlockResource> URANIUM_BLOCK = BLOCKS.register("block_uranium", BlockResource::new);
    public static final RegistryObject<BlockResource> ELECTRUM_BLOCK = BLOCKS.register("block_electrum", BlockResource::new);
    public static final RegistryObject<BlockResource> PLATINUM_BLOCK = BLOCKS.register("block_platinum", BlockResource::new);

    //Machines
    public static final RegistryObject<Block> MACHINE_CASING = BLOCKS.register("machine_casing", BlockMachine::new);
    public static final RegistryObject<Block> ADV_MACHINE_CASING = BLOCKS.register("advanced_machine_casing", BlockMachine::new);

    public static final RegistryObject<Block> STERLING_GENERATOR = BLOCKS.register("sterling_generator", SterlingBlock::new);
    public static final RegistryObject<SolarPanel> SOLAR_PANEL_BASIC = BLOCKS.register("solar_panel_basic", () -> new SolarPanel(SolarPanelTier.Basic));
    public static final RegistryObject<SolarPanel> SOLAR_PANEL_ADVANCED = BLOCKS.register("solar_panel_advanced", () -> new SolarPanel(SolarPanelTier.Advanced));
    public static final RegistryObject<SolarPanel> SOLAR_PANEL_ULTIMATE = BLOCKS.register("solar_panel_ultimate", () -> new SolarPanel(SolarPanelTier.Ultimate));
    public static final RegistryObject<Battery> BASIC_BATTERY = BLOCKS.register("basic_battery", () -> new Battery(BatteryTier.Basic));
    public static final RegistryObject<Battery> ADVANCED_BATTERY = BLOCKS.register("advanced_battery", () -> new Battery(BatteryTier.Advanced));
    public static final RegistryObject<Battery> ULTIMATE_BATTERY = BLOCKS.register("ultimate_battery", () -> new Battery(BatteryTier.Ultimate));

    public static final RegistryObject<Block> METAL_FORMER = BLOCKS.register("metal_former", BlockMachine::new);
    public static final RegistryObject<Block> GRINDER = BLOCKS.register("grinder", BlockMachine::new);
    public static final RegistryObject<Block> SMELTER= BLOCKS.register("smelter", BlockMachine::new);

    //ItemBlocks
    public static final RegistryObject<Item> SILVER_BLOCK_ITEM = ITEMS.register("block_silver",  () -> new BlockItem(SILVER_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> BRONZE_BLOCK_ITEM = ITEMS.register("block_bronze",() -> new BlockItem(BRONZE_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> INVAR_BLOCK_ITEM = ITEMS.register("block_invar", () -> new BlockItem(INVAR_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> CHARCOAL_BLOCK_ITEM = ITEMS.register("block_charcoal", () -> new BlockItem(CHARCOAL_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> ALUMINUM_BLOCK_ITEM = ITEMS.register("block_aluminum",() -> new BlockItem(ALUMINUM_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> STEEL_BLOCK_ITEM = ITEMS.register("block_steel", () -> new BlockItem(STEEL_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> COPPER_BLOCK_ITEM = ITEMS.register("block_copper", () -> new BlockItem(COPPER_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> TIN_BLOCK_ITEM = ITEMS.register("block_tin", () -> new BlockItem(TIN_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> NICKEL_BLOCK_ITEM = ITEMS.register("block_nickel", () -> new BlockItem(NICKEL_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> LEAD_BLOCK_ITEM = ITEMS.register("block_lead", () -> new BlockItem(LEAD_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> ZINC_BLOCK_ITEM = ITEMS.register("block_zinc", () -> new BlockItem(ZINC_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> BRASS_BLOCK_ITEM = ITEMS.register("block_brass", () -> new BlockItem(BRASS_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> URANIUM_BLOCK_ITEM = ITEMS.register("block_uranium",() -> new BlockItem(URANIUM_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> ELECTRUM_BLOCK_ITEM = ITEMS.register("block_electrum", () -> new BlockItem(ELECTRUM_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> PLATINUM_BLOCK_ITEM = ITEMS.register("block_platinum", () -> new BlockItem(PLATINUM_BLOCK.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> MACHINE_CASING_ITEM = ITEMS.register("machine_casing", () -> new BlockItem(MACHINE_CASING.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> ADV_MACHINE_CASING_ITEM = ITEMS.register("advanced_machine_casing", () -> new BlockItem(ADV_MACHINE_CASING.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> METAL_FORMER_ITEM = ITEMS.register("metal_former", () -> new BlockItem(METAL_FORMER.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> GRINDER_ITEM = ITEMS.register("grinder", () -> new BlockItem(GRINDER.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> SMELTER_ITEM = ITEMS.register("smelter", () -> new BlockItem(SMELTER.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> STERLING_GENERATOR_ITEM = ITEMS.register("sterling_generator", () -> new BlockItem(STERLING_GENERATOR.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> SOLAR_PANEL_BASIC_ITEM = ITEMS.register("solar_panel_basic", () -> new BlockItem(SOLAR_PANEL_BASIC.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> SOLAR_PANEL_ADVANCED_ITEM = ITEMS.register("solar_panel_advanced", () -> new BlockItem(SOLAR_PANEL_ADVANCED.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> SOLAR_PANEL_ULTIMATE_ITEM = ITEMS.register("solar_panel_ultimate", () -> new BlockItem(SOLAR_PANEL_ULTIMATE.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> BASIC_BATTERY_ITEM = ITEMS.register("basic_battery", () -> new BlockItem(BASIC_BATTERY.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> ADVANCED_BATTERY_ITEM = ITEMS.register("advanced_battery", () -> new BlockItem(ADVANCED_BATTERY.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> ULTIMATE_BATTERY_ITEM = ITEMS.register("ultimate_battery", () -> new BlockItem(ULTIMATE_BATTERY.get(), new Item.Properties().group(EngineeringReimagined.TabEnginneringReimagined)));

    //Tiles
    public static final RegistryObject<TileEntityType<SterlingTile>> STERLING_TILE = TILES.register("sterling_generator", () -> TileEntityType.Builder.create(SterlingTile::new, STERLING_GENERATOR.get()).build(null));
    public static final RegistryObject<TileEntityType<BasicSolarPanelTile>> SOLAR_TILE_BASIC = TILES.register("solar_panel_basic", () -> TileEntityType.Builder.create(BasicSolarPanelTile::new, SOLAR_PANEL_BASIC.get()).build(null));
    public static final RegistryObject<TileEntityType<AdvancedSolarPanelTile>> SOLAR_TILE_ADVANCED = TILES.register("solar_panel_advanced", () -> TileEntityType.Builder.create(AdvancedSolarPanelTile::new, SOLAR_PANEL_ADVANCED.get()).build(null));
    public static final RegistryObject<TileEntityType<UltimateSolarPanelTile>> SOLAR_TILE_ULTIMATE = TILES.register("solar_panel_ultimate", () -> TileEntityType.Builder.create(UltimateSolarPanelTile::new, SOLAR_PANEL_ULTIMATE.get()).build(null));
    public static final RegistryObject<TileEntityType<BasicBatteryTile>> BASIC_BATTERY_TILE = TILES.register("basic_battery", () -> TileEntityType.Builder.create(BasicBatteryTile::new, BASIC_BATTERY.get()).build(null));
    public static final RegistryObject<TileEntityType<AdvancedBatteryTile>> ADVANCED_BATTERY_TILE = TILES.register("advanced_battery", () -> TileEntityType.Builder.create(AdvancedBatteryTile::new, BASIC_BATTERY.get()).build(null));
    public static final RegistryObject<TileEntityType<UltimateBatteryTile>> ULTIMATE_BATTERY_TILE = TILES.register("ultimate_battery", () -> TileEntityType.Builder.create(UltimateBatteryTile::new, BASIC_BATTERY.get()).build(null));
    //Containers
    public static final RegistryObject<ContainerType<SterlingContainer>> STERLING_CONTAINER = CONTAINERS.register("sterling_generator", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new SterlingContainer(windowId, world, pos, inv, inv.player);
    }));
    public static final RegistryObject<ContainerType<SolarPanelContainer>> BASIC_SOLAR_CONTAINER = CONTAINERS.register("solar_panel_basic", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new BasicSolarPanelContainer(windowId, world, pos,  inv.player);
    }));
    public static final RegistryObject<ContainerType<SolarPanelContainer>> ADVANCED_SOLAR_CONTAINER = CONTAINERS.register("solar_panel_advanced", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new AdvancedSolarPanelContainer(windowId, world, pos,  inv.player);
    }));
    public static final RegistryObject<ContainerType<SolarPanelContainer>> ULTIMATE_SOLAR_CONTAINER = CONTAINERS.register("solar_panel_ultimate", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new UltimateSolarPanelContainer(windowId, world, pos, inv.player);
    }));
    public static final RegistryObject<ContainerType<BatteryContainer>> BASIC_BATTERY_CONTAINER = CONTAINERS.register("basic_battery", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new BasicBatteryContainer(windowId, world, pos, inv.player);
    }));
    public static final RegistryObject<ContainerType<BatteryContainer>> ADVANCED_BATTERY_CONTAINER = CONTAINERS.register("advanced_battery", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new AdvancedBatteryContainer(windowId, world, pos, inv.player);
    }));
    public static final RegistryObject<ContainerType<BatteryContainer>> ULTIMATE_BATTERY_CONTAINER = CONTAINERS.register("ultimate_battery", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new UltimateBatteryContainer(windowId, world, pos, inv.player);
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


























