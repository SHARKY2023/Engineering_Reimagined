package com.SHARKY2023.EngineeringReimagined.registries;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.items.ItemBase;
import com.SHARKY2023.EngineeringReimagined.registration.impl.ItemDeferredRegister;
import com.SHARKY2023.EngineeringReimagined.registration.impl.ItemRegistryObject;
import com.SHARKY2023.EngineeringReimagined.resources.INamedResource;
import com.SHARKY2023.EngineeringReimagined.resources.ResourceType;
import net.minecraft.item.Item;


public class ERItems {

    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(EngineeringReimagined.MOD_ID);


    //Items
    public static final ItemRegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final ItemRegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", ItemBase::new);

    //Ingots
    public static final ItemRegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot");
    public static final ItemRegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot");
    public static final ItemRegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot");
    public static final ItemRegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot");
    public static final ItemRegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot");
    public static final ItemRegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot");
    public static final ItemRegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot");
    public static final ItemRegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot");
    public static final ItemRegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot");
    public static final ItemRegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot");
    public static final ItemRegistryObject<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot");
    public static final ItemRegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot");

    //Gear
    public static final ItemRegistryObject<Item> COPPER_GEAR = ITEMS.register("copper_gear", ItemBase::new);
    public static final ItemRegistryObject<Item> TIN_GEAR = ITEMS.register("tin_gear", ItemBase::new);
    public static final ItemRegistryObject<Item> STEEL_GEAR = ITEMS.register("steel_gear", ItemBase::new);
    public static final ItemRegistryObject<Item> BRONZE_GEAR = ITEMS.register("bronze_gear", ItemBase::new);
    public static final ItemRegistryObject<Item> ZINC_GEAR = ITEMS.register("zinc_gear", ItemBase::new);
    public static final ItemRegistryObject<Item> BRASS_GEAR = ITEMS.register("brass_gear", ItemBase::new);
    public static final ItemRegistryObject<Item> PLATINUM_GEAR = ITEMS.register("platinum_gear", ItemBase::new);
    public static final ItemRegistryObject<Item> LEAD_GEAR = ITEMS.register("lead_gear", ItemBase::new);
    public static final ItemRegistryObject<Item> SILVER_GEAR = ITEMS.register("silver_gear", ItemBase::new);
    public static final ItemRegistryObject<Item> ELECTRUM_GEAR = ITEMS.register("electrum_gear", ItemBase::new);
    public static final ItemRegistryObject<Item> NICKEL_GEAR = ITEMS.register("nickel_gear", ItemBase::new);

    //Plate
    public static final ItemRegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate", ItemBase::new);
    public static final ItemRegistryObject<Item> TIN_PLATE = ITEMS.register("tin_plate", ItemBase::new);
    public static final ItemRegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", ItemBase::new);
    public static final ItemRegistryObject<Item> BRONZE_PLATE = ITEMS.register("bronze_plate", ItemBase::new);
    public static final ItemRegistryObject<Item> ZINC_PLATE = ITEMS.register("zinc_plate", ItemBase::new);
    public static final ItemRegistryObject<Item> BRASS_PLATE = ITEMS.register("brass_plate", ItemBase::new);
    public static final ItemRegistryObject<Item> PLATINUM_PLATE = ITEMS.register("platinum_plate", ItemBase::new);
    public static final ItemRegistryObject<Item> LEAD_PLATE = ITEMS.register("lead_plate", ItemBase::new);
    public static final ItemRegistryObject<Item> SILVER_PLATE = ITEMS.register("silver_plate", ItemBase::new);
    public static final ItemRegistryObject<Item> ELECTRUM_PLATE = ITEMS.register("electrum_plate", ItemBase::new);
    public static final ItemRegistryObject<Item> NICKEL_PLATE = ITEMS.register("nickel_plate", ItemBase::new);
    public static final ItemRegistryObject<Item> BASIC_CIRCUIT = ITEMS.register("basic_circuit", ItemBase::new);

    //Crafting Items
    public static final ItemRegistryObject<Item> RUBBER = ITEMS.register("rubber", ItemBase::new);
    public static final ItemRegistryObject<Item> CONDUIT_CASING = ITEMS.register("conduit_casing", ItemBase::new);
    public static final ItemRegistryObject<Item> HAMMER = ITEMS.register("hammer", ItemBase::new);
    public static final ItemRegistryObject<Item> ADV_CIRCUIT = ITEMS.register("advanced_circuit", ItemBase::new);

    private static ItemRegistryObject<Item> registerResource(ResourceType type, INamedResource resource) {
        return ITEMS.register(type.getRegistryPrefix() + "_" + resource.getRegistrySuffix());
        //Plate

    }
}

