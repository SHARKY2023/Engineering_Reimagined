package com.SHARKY2023.EngineeringReimagined.registries;

import com.SHARKY2023.EngineeringReimagined.blocks.generator.sterling.SterlingTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.SHARKY2023.EngineeringReimagined.EngineeringReimagined.MOD_ID;
import static com.SHARKY2023.EngineeringReimagined.registries.ERBlocks.STERLING_GENERATOR;

public class ERTiles {

    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MOD_ID);
    public static void init() {
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }



}
