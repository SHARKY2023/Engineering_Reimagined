package com.SHARKY2023.EngineeringReimagined.list;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemList {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, EngineeringReimagined.MOD_ID);


 /*   public static void inititem() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
  */

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

    //Crafting Items
    public static final RegistryObject<Item> BASIC_CIRCUIT = ITEMS.register("basic_circuit", ItemBase::new);
    public static final RegistryObject<Item> ADV_CIRCUIT = ITEMS.register("advanced_circuit", ItemBase::new);
    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber", ItemBase::new);
    public static final RegistryObject<Item> CONDUIT_CASING = ITEMS.register("conduit_casing", ItemBase::new);
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", ItemBase::new);
}