package com.SHARKY2023.EngineeringReimagined;


import com.SHARKY2023.EngineeringReimagined.proxy.ClientProxy;
import com.SHARKY2023.EngineeringReimagined.proxy.IProxy;
import com.SHARKY2023.EngineeringReimagined.proxy.ServerProxy;
import com.SHARKY2023.EngineeringReimagined.registries.ERBlocks;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import com.SHARKY2023.EngineeringReimagined.setup.ClientSetup;
import com.SHARKY2023.EngineeringReimagined.setup.ModSetup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EngineeringReimagined.MOD_ID)
@Mod.EventBusSubscriber(modid = EngineeringReimagined.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EngineeringReimagined {


    public static ItemGroup TabEnginneringReimagined = new ItemGroup(EngineeringReimagined.MOD_ID +"Tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Registration.SILVER_BLOCK);
       }
    };


    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "er2023";





    public EngineeringReimagined() {

        Registration.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);


    }
}



