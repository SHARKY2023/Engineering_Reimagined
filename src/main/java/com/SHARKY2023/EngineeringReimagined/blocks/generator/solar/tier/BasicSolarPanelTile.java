package com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.tier;

import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanelTile;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import com.SHARKY2023.EngineeringReimagined.util.SolarPanelTier;


public class BasicSolarPanelTile extends SolarPanelTile {

    public BasicSolarPanelTile() {
        super(SolarPanelTier.Basic, Registration.SOLAR_TILE_BASIC.get());
    }
}
