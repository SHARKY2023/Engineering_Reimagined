package com.SHARKY2023.EngineeringReimagined.blocks.battery.tile;

import com.SHARKY2023.EngineeringReimagined.blocks.battery.BatteryTier;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import net.minecraft.tileentity.TileEntity;

public class AdvancedBatteryTile extends BatteryTile {

    public AdvancedBatteryTile() { super(BatteryTier.Advanced, Registration.ADVANCED_BATTERY_TILE.get());
    }
}

