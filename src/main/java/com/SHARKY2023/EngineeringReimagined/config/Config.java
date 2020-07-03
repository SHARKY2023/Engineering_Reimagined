package com.SHARKY2023.EngineeringReimagined.config;

import com.SHARKY2023.EngineeringReimagined.registration.WrappedRegistryObject;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_POWER = "power";
    public static final String SUBCATEGORY_STERLING = "firstblock";


    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.IntValue STERLING_MAXPOWER;
    public static ForgeConfigSpec.IntValue STERLING_GENERATE;
    public static ForgeConfigSpec.IntValue STERLING_SEND;
    public static ForgeConfigSpec.IntValue STERLING_TICKS;



    static {

        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        CLIENT_BUILDER.comment("General settings").push(CATEGORY_GENERAL);
        CLIENT_BUILDER.pop();

        SERVER_BUILDER.comment("Power settings").push(CATEGORY_POWER);

        setupSterlingConfig(SERVER_BUILDER, CLIENT_BUILDER);

        SERVER_BUILDER.pop();


        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    private static void setupSterlingConfig(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        SERVER_BUILDER.comment("Sterling Generator settings").push(SUBCATEGORY_STERLING);

        STERLING_MAXPOWER = SERVER_BUILDER.comment("Maximum power for the Sterling generator. Default = 50'000FE")
                .defineInRange("maxPower", 50000, 0, Integer.MAX_VALUE);
        STERLING_GENERATE = SERVER_BUILDER.comment("Power generation per tick")
                .defineInRange("generate", 60, 0, Integer.MAX_VALUE);
        STERLING_SEND = SERVER_BUILDER.comment("Power generation to send per tick")
                .defineInRange("send", 1000, 0, Integer.MAX_VALUE);
        STERLING_TICKS = SERVER_BUILDER.comment("Ticks per coal")
                .defineInRange("ticks", 20, 0, Integer.MAX_VALUE);

        SERVER_BUILDER.pop();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {

    }

    @SubscribeEvent
    public static void onReload(final ModConfig.Reloading configEvent) {
    }


}