package com.SHARKY2023.engineeringreimagined.list;

import com.SHARKY2023.engineeringreimagined.Main;
import com.SHARKY2023.engineeringreimagined.blocks.BlockBase;
import com.SHARKY2023.engineeringreimagined.blocks.MachineBase;
import com.SHARKY2023.engineeringreimagined.blocks.OreBase;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockList {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Main.MOD_ID);
/*
    public static void initblock() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
*/
    public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block", BlockBase::new);
    public static final RegistryObject<Block> TIN_BLOCK = BLOCKS.register("tin_block", BlockBase::new);
    public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", BlockBase::new);
    public static final RegistryObject<Block> BRONZE_BLOCK = BLOCKS.register("bronze_block", BlockBase::new);
    public static final RegistryObject<Block> LEAD_BLOCK = BLOCKS.register("lead_block", BlockBase::new);
    public static final RegistryObject<Block> ELECTRUM_BLOCK = BLOCKS.register("electrum_block", BlockBase::new);
    public static final RegistryObject<Block> PLATINUM_BLOCK = BLOCKS.register("platinum_block", BlockBase::new);
    public static final RegistryObject<Block> BRASS_BLOCK = BLOCKS.register("brass_block", BlockBase::new);
    public static final RegistryObject<Block> ZINC_BLOCK = BLOCKS.register("zinc_block", BlockBase::new);
    public static final RegistryObject<Block> NICKEL_BLOCK = BLOCKS.register("nickel_block", BlockBase::new);
    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", BlockBase::new);
    public static final RegistryObject<Block> ALUMINUM_BLOCK = BLOCKS.register("aluminum_block", BlockBase::new);
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", BlockBase::new);
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", BlockBase::new);
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ore_ruby", OreBase::new);


    public static final RegistryObject<Block> MACHINE_BLOCK = BLOCKS.register("machine_block" , MachineBase::new);

}

