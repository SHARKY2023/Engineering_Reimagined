package com.SHARKY2023.EngineeringReimagined.blocks.battery.tile;

import com.SHARKY2023.EngineeringReimagined.blocks.battery.BatteryTier;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import net.minecraft.tileentity.TileEntity;

public class UltimateBatteryTile extends BatteryTile {

    public UltimateBatteryTile() { super(BatteryTier.Ultimate, Registration.ULTIMATE_BATTERY_TILE.get());
    }
}

