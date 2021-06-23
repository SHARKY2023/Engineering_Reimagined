package com.SHARKY2023.EngineeringReimagined.setup;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.sterling.SterlingScreen;
import com.SHARKY2023.EngineeringReimagined.gui.BatteryScreen;
import com.SHARKY2023.EngineeringReimagined.gui.SolarPanelScreen;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EngineeringReimagined.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(final FMLClientSetupEvent event) {
     ScreenManager.register(Registration.STERLING_CONTAINER.get(), SterlingScreen::new);
     ScreenManager.register(Registration.BASIC_SOLAR_CONTAINER.get(), SolarPanelScreen::new);
     ScreenManager.register(Registration.ADVANCED_SOLAR_CONTAINER.get(), SolarPanelScreen::new);
     ScreenManager.register(Registration.ULTIMATE_SOLAR_CONTAINER.get(), SolarPanelScreen::new);
     ScreenManager.register(Registration.BASIC_BATTERY_CONTAINER.get(), BatteryScreen::new);
     ScreenManager.register(Registration.ADVANCED_BATTERY_CONTAINER.get(), BatteryScreen::new);
     ScreenManager.register(Registration.ULTIMATE_BATTERY_CONTAINER.get(), BatteryScreen::new);
/*
        MinecraftForge.EVENT_BUS.addListener(InWorldRenderer::render);
        MinecraftForge.EVENT_BUS.addListener(AfterLivingRenderer::render);





    @SubscribeEvent
    public static void onItemColor(ColorHandlerEvent.Item event) {
        event.getItemColors().register((stack, i) -> 0xff0000, Registration.WEIRDMOB_EGG.get());
    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (!event.getMap().getTextureLocation().equals(AtlasTexture.LOCATION_BLOCKS_TEXTURE)) {
            return;
        }

        event.addSprite(MAGICBLOCK_TEXTURE);
    }

    @SubscribeEvent
    public void onTooltipPre(RenderTooltipEvent.Pre event) {
        Item item = event.getStack().getItem();
        if (item.getRegistryName().getNamespace().equals(MyTutorial.MODID)) {
            event.setMaxWidth(200);
        }
    }

 */
}}