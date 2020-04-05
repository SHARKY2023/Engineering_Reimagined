package com.SHARKY2023.EngineeringReimagined.blocks;

import net.minecraft.block.Block;

import java.util.EnumMap;
import java.util.Map;

public final class ERBlocks {


    private ERBlocks(){

    }

    public static final class Metals
    {
        public static Map<EnumMetals, Block> ores = new EnumMap<>(EnumMetals.class);
        public static Map<EnumMetals, Block> storage = new EnumMap<>(EnumMetals.class);
        public static Map<EnumMetals, Block> sheetmetal = new EnumMap<>(EnumMetals.class);
    }

}
