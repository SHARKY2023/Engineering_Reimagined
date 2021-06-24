package com.SHARKY2023.EngineeringReimagined.setup;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.network.Networking;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static com.SHARKY2023.EngineeringReimagined.registries.Registration.SILVER_BLOCK;

@Mod.EventBusSubscriber(modid = EngineeringReimagined.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {


    public static void init(final FMLCommonSetupEvent event) {
        Networking.registerMessages();
    }
/*
    @SubscribeEvent
    public static void serverLoad(FMLServerStartingEvent event) {
        ModCommands.register(event.getCommandDispatcher());
    }

    @SubscribeEvent
    public static void onDimensionRegistry(RegisterDimensionsEvent event) {
        ModDimensions.DIMENSION_TYPE = DimensionManager.registerOrGetDimension(ModDimensions.DIMENSION_ID, Registration.DIMENSION.get(), null, true);
    }


 */

}