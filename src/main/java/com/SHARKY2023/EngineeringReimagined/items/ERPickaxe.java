package com.SHARKY2023.EngineeringReimagined.items;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.DiggerItem;

import java.util.Set;

import net.minecraft.world.item.Item.Properties;

public class ERPickaxe extends DiggerItem {


    protected ERPickaxe(float attackDamageIn, float attackSpeedIn, Tier tier, Set<Block> effectiveBlocksIn, Properties builder) {
        super(attackDamageIn, attackSpeedIn, tier, effectiveBlocksIn, builder);
    }
}