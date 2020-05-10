package com.SHARKY2023.EngineeringReimagined.blocks.generator.combustion;

import com.SHARKY2023.EngineeringReimagined.blocks.generator.TileGeneratorBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class TileCombustion extends TileGeneratorBase {


/*

    @Override
    protected void generate(World world) {
        final ItemStack fuelStack = this.inv.getStackInSlot(builtInSlots());
        if (this.nextBuff <= 0 && !fuelStack.isEmpty()) {
            this.buffer = ForgeHooks.getBurnTime(fuelStack) * Configs.GENERAL.fuelTicks.get();
            if (this.buffer <= 0) return;
            this.nextBuff = this.buffer;
            if (fuelStack.hasContainerItem())
                this.inv.setStack(1, fuelStack.getContainerItem());
            else {
                fuelStack.shrink(1);
            }
        }
    }
*/
}
