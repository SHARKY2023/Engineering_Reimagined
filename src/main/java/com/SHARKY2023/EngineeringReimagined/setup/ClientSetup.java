package com.SHARKY2023.EngineeringReimagined.setup;

import com.SHARKY2023.EngineeringReimagined.blocks.battery.BatteryTier;
import com.SHARKY2023.EngineeringReimagined.gui.CapacitorScreen;
import com.SHARKY2023.EngineeringReimagined.gui.SterlingScreen;
import com.SHARKY2023.EngineeringReimagined.gui.BatteryScreen;
import com.SHARKY2023.EngineeringReimagined.gui.SolarPanelScreen;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import com.SHARKY2023.EngineeringReimagined.util.SolarPanelTier;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

    public static void init(final FMLClientSetupEvent event) {


        ScreenManager.register(Registration.STERLING_CONTAINER.get(), SterlingScreen::new);

        ScreenManager.register(Registration.CAPACITOR_CONTAINER.get(), CapacitorScreen::new);


        for (SolarPanelTier level : SolarPanelTier.values()) {
            ScreenManager.register(Registration.SOLAR_PANEL_CONTAINER.get(level).get(), SolarPanelScreen::new);
        }

        for (BatteryTier level : BatteryTier.values()) {
            ScreenManager.register(Registration.BATTERY_CONTAINER.get(level).get(), BatteryScreen::new);
        }

    }
/*
        MinecraftForge.EVENT_BUS.addListener(InWorldRenderer::render);
        MinecraftForge.EVENT_BUS.addListener(AfterLivingRenderer::render);




}
    }

 */
}