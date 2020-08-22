package com.SHARKY2023.EngineeringReimagined.blocks.battery.tile;

import com.SHARKY2023.EngineeringReimagined.blocks.battery.BatteryTier;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import net.minecraft.tileentity.TileEntityType;

public class BasicBatteryTile extends BatteryTile {

    public BasicBatteryTile() { super(BatteryTier.Basic, Registration.BASIC_BATTERY_TILE.get());
    }
}
