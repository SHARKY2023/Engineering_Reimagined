package com.SHARKY2023.engineeringreimagined.items;

import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ToolItem;

import java.util.Set;

public class ERPickaxe extends ToolItem {


    protected ERPickaxe(float attackDamageIn, float attackSpeedIn, IItemTier tier, Set<Block> effectiveBlocksIn, Properties builder) {
        super(attackDamageIn, attackSpeedIn, tier, effectiveBlocksIn, builder);
    }
}