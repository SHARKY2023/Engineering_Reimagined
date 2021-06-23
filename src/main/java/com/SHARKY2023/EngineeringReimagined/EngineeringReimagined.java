package com.SHARKY2023.EngineeringReimagined;

import com.SHARKY2023.EngineeringReimagined.network.PacketHandler;
import com.SHARKY2023.EngineeringReimagined.registries.Registration;
import com.SHARKY2023.EngineeringReimagined.setup.ClientSetup;
import com.SHARKY2023.EngineeringReimagined.setup.ModSetup;
import com.SHARKY2023.EngineeringReimagined.setup.proxy.IProxy;
import com.SHARKY2023.EngineeringReimagined.setup.proxy.Proxy;
import com.SHARKY2023.EngineeringReimagined.setup.proxy.ProxyClient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.SHARKY2023.EngineeringReimagined.registries.Registration.SILVER_BLOCK;

@Mod(EngineeringReimagined.MOD_ID)
@Mod.EventBusSubscriber(modid = EngineeringReimagined.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EngineeringReimagined {

  public static IProxy proxy = DistExecutor.safeRunForDist(() -> ProxyClient::new, () -> Proxy::new);

    public static final String MOD_ID = "er2023";

    public static ItemGroup TabEnginneringReimagined = new ItemGroup(EngineeringReimagined.MOD_ID +"Tab") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(SILVER_BLOCK.get());
        }};

    private final Logger LOGGER = LogManager.getLogger();

    public EngineeringReimagined() {
        Registration.init();
      //  FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
        PacketHandler.init(); }
}



