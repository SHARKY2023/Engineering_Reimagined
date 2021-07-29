package com.SHARKY2023.EngineeringReimagined.setup;

import com.SHARKY2023.EngineeringReimagined.blocks.battery.BatteryTier;
import com.SHARKY2023.EngineeringReimagined.blocks.machine.crusher.CrusherContainer;
import com.SHARKY2023.EngineeringReimagined.gui.*;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import com.SHARKY2023.EngineeringReimagined.util.SolarPanelTier;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

    public static void init(final FMLClientSetupEvent event) {


        MenuScreens.register(Registration.STERLING_CONTAINER.get(), SterlingScreen::new);


        MenuScreens.register(Registration.CAPACITOR_CONTAINER.get(), CapacitorScreen::new);

        MenuScreens.register(Registration.CRUSHER_CONTAINER.get(), CrusherScreen::new);


        for (SolarPanelTier level : SolarPanelTier.values()) {
            MenuScreens.register(Registration.SOLAR_PANEL_CONTAINER.get(level).get(), SolarPanelScreen::new);
        }

        for (BatteryTier level : BatteryTier.values()) {
            MenuScreens.register(Registration.BATTERY_CONTAINER.get(level).get(), BatteryScreen::new);
        }

    }
/*
        MinecraftForge.EVENT_BUS.addListener(InWorldRenderer::render);
        MinecraftForge.EVENT_BUS.addListener(AfterLivingRenderer::render);




}
    }

 */
}