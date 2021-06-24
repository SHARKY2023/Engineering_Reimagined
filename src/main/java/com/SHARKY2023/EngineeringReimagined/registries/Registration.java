package com.SHARKY2023.EngineeringReimagined.registries;


import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.blocks.basic.BlockMachine;
import com.SHARKY2023.EngineeringReimagined.blocks.basic.BlockResource;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.Battery;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.BatteryTier;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.BatteryTile;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.BatteryContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanel;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanelContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanelTile;
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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


import java.util.HashMap;
import java.util.Map;

import static com.SHARKY2023.EngineeringReimagined.EngineeringReimagined.MOD_ID;


public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MOD_ID);
    private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MOD_ID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

        for(SolarPanelTier level : SolarPanelTier.values()) {
            SOLAR_PANEL_BLOCK.put(level, BLOCKS.register(level.getSolarPanelName(), () -> new SolarPanel(level)));
            SOLAR_PANEL_ITEM.put(level, ITEMS.register(level.getSolarPanelName(), () -> new BlockItem(SOLAR_PANEL_BLOCK.get(level).get(),new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined))));
            SOLAR_PANEL_TILE.put(level, TILES.register(level.getSolarPanelName(), () -> TileEntityType.Builder.of(() -> new SolarPanelTile(level), SOLAR_PANEL_BLOCK.get(level).get()).build(null)));
            SOLAR_PANEL_CONTAINER.put(level, CONTAINERS.register(level.getSolarPanelName(), () -> IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                TileEntity te = inv.player.getCommandSenderWorld().getBlockEntity(pos);
                if(!(te instanceof SolarPanelTile))
                {
                    EngineeringReimagined.logger.error("Wrong type of tile entity (expected TileEntitySolarPanel)!");
                    return null;
                }
                SolarPanelTile tile = (SolarPanelTile) te;
                return new SolarPanelContainer(windowId, inv.player, tile, level);
            })));


        }

        for(BatteryTier level : BatteryTier.values()) {
            BATTERY_BLOCK.put(level, BLOCKS.register(level.getBatteryName(), () -> new Battery(level)));
            BATTERY_ITEM.put(level, ITEMS.register(level.getBatteryName(), () -> new BlockItem(BATTERY_BLOCK.get(level).get(),new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined))));
            BATTERY_TILE.put(level, TILES.register(level.getBatteryName(), () -> TileEntityType.Builder.of(() -> new BatteryTile(level), BATTERY_BLOCK.get(level).get()).build(null)));
            BATTERY_CONTAINER.put(level, CONTAINERS.register(level.getBatteryName(), () -> IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                TileEntity te = inv.player.getCommandSenderWorld().getBlockEntity(pos);
                if(!(te instanceof BatteryTile))
                {
                    EngineeringReimagined.logger.error("Wrong type of tile entity (expected TileEntitySolarPanel)!");
                    return null;
                }
                BatteryTile tile = (BatteryTile) te;
                return new BatteryContainer(windowId, inv.player, tile, level);
            })));


        }
    }

    public static final Map<SolarPanelTier, RegistryObject<SolarPanel>> SOLAR_PANEL_BLOCK = new HashMap<>();
    public static final Map<SolarPanelTier, RegistryObject<Item>> SOLAR_PANEL_ITEM = new HashMap<>();
    public static final Map<SolarPanelTier, RegistryObject<TileEntityType<SolarPanelTile>>> SOLAR_PANEL_TILE = new HashMap<>();
    public static final Map<SolarPanelTier, RegistryObject<ContainerType<SolarPanelContainer>>> SOLAR_PANEL_CONTAINER = new HashMap<>();

    public static final Map<BatteryTier, RegistryObject<Battery>> BATTERY_BLOCK = new HashMap<>();
    public static final Map<BatteryTier, RegistryObject<Item>> BATTERY_ITEM = new HashMap<>();
    public static final Map<BatteryTier, RegistryObject<TileEntityType<BatteryTile>>> BATTERY_TILE = new HashMap<>();
    public static final Map<BatteryTier, RegistryObject<ContainerType<BatteryContainer>>> BATTERY_CONTAINER = new HashMap<>();


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
    public static final RegistryObject<Battery> BASIC_BATTERY = BLOCKS.register("basic_battery", () -> new Battery(BatteryTier.Basic));
    public static final RegistryObject<Battery> ADVANCED_BATTERY = BLOCKS.register("advanced_battery", () -> new Battery(BatteryTier.Advanced));
    public static final RegistryObject<Battery> ULTIMATE_BATTERY = BLOCKS.register("ultimate_battery", () -> new Battery(BatteryTier.Ultimate));

    public static final RegistryObject<Block> METAL_FORMER = BLOCKS.register("metal_former", BlockMachine::new);
    public static final RegistryObject<Block> GRINDER = BLOCKS.register("grinder", BlockMachine::new);
    public static final RegistryObject<Block> SMELTER= BLOCKS.register("smelter", BlockMachine::new);

    //ItemBlocks
    public static final RegistryObject<Item> SILVER_BLOCK_ITEM = ITEMS.register("block_silver",  () -> new BlockItem(SILVER_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> BRONZE_BLOCK_ITEM = ITEMS.register("block_bronze",() -> new BlockItem(BRONZE_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> INVAR_BLOCK_ITEM = ITEMS.register("block_invar", () -> new BlockItem(INVAR_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> CHARCOAL_BLOCK_ITEM = ITEMS.register("block_charcoal", () -> new BlockItem(CHARCOAL_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> ALUMINUM_BLOCK_ITEM = ITEMS.register("block_aluminum",() -> new BlockItem(ALUMINUM_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> STEEL_BLOCK_ITEM = ITEMS.register("block_steel", () -> new BlockItem(STEEL_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> COPPER_BLOCK_ITEM = ITEMS.register("block_copper", () -> new BlockItem(COPPER_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> TIN_BLOCK_ITEM = ITEMS.register("block_tin", () -> new BlockItem(TIN_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> NICKEL_BLOCK_ITEM = ITEMS.register("block_nickel", () -> new BlockItem(NICKEL_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> LEAD_BLOCK_ITEM = ITEMS.register("block_lead", () -> new BlockItem(LEAD_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> ZINC_BLOCK_ITEM = ITEMS.register("block_zinc", () -> new BlockItem(ZINC_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> BRASS_BLOCK_ITEM = ITEMS.register("block_brass", () -> new BlockItem(BRASS_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> URANIUM_BLOCK_ITEM = ITEMS.register("block_uranium",() -> new BlockItem(URANIUM_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> ELECTRUM_BLOCK_ITEM = ITEMS.register("block_electrum", () -> new BlockItem(ELECTRUM_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> PLATINUM_BLOCK_ITEM = ITEMS.register("block_platinum", () -> new BlockItem(PLATINUM_BLOCK.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> MACHINE_CASING_ITEM = ITEMS.register("machine_casing", () -> new BlockItem(MACHINE_CASING.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> ADV_MACHINE_CASING_ITEM = ITEMS.register("advanced_machine_casing", () -> new BlockItem(ADV_MACHINE_CASING.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> METAL_FORMER_ITEM = ITEMS.register("metal_former", () -> new BlockItem(METAL_FORMER.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> GRINDER_ITEM = ITEMS.register("grinder", () -> new BlockItem(GRINDER.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> SMELTER_ITEM = ITEMS.register("smelter", () -> new BlockItem(SMELTER.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));
    public static final RegistryObject<Item> STERLING_GENERATOR_ITEM = ITEMS.register("sterling_generator", () -> new BlockItem(STERLING_GENERATOR.get(), new Item.Properties().tab(EngineeringReimagined.TabEnginneringReimagined)));

    //Tiles
    public static final RegistryObject<TileEntityType<SterlingTile>> STERLING_TILE = TILES.register("sterling_generator", () -> TileEntityType.Builder.of(SterlingTile::new, STERLING_GENERATOR.get()).build(null));



    //Containers
    public static final RegistryObject<ContainerType<SterlingContainer>> STERLING_CONTAINER = CONTAINERS.register("sterling_generator", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getCommandSenderWorld();
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


























