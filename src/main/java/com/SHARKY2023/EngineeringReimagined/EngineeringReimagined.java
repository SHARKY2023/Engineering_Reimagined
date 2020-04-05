package com.SHARKY2023.EngineeringReimagined;


import com.SHARKY2023.EngineeringReimagined.list.BlockList;
import com.SHARKY2023.EngineeringReimagined.list.ItemList;
import com.SHARKY2023.EngineeringReimagined.proxy.ClientProxy;
import com.SHARKY2023.EngineeringReimagined.proxy.IProxy;
import com.SHARKY2023.EngineeringReimagined.proxy.ServerProxy;
import javafx.beans.binding.ObjectBinding;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EngineeringReimagined.MOD_ID)
@Mod.EventBusSubscriber(modid = EngineeringReimagined.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EngineeringReimagined {

    public static ItemGroup TabCBlock = new ItemGroup(EngineeringReimagined.MOD_ID +"Blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockList.COPPER_BLOCK.get());
        }
    };
    public static ItemGroup TabCItems = new ItemGroup(EngineeringReimagined.MOD_ID +"Items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemList.RUBY.get());
        }
    };

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());


    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "er2023";



    public EngineeringReimagined() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
      //  MinecraftForge.EVENT_BUS.addListener(this::serverStarting);
      //  MinecraftForge.EVENT_BUS.addListener(this::serverStarted);


        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);



    }





    @SubscribeEvent
    public static void createBlockItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockList.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(EngineeringReimagined.TabCBlock);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }

    private void setup(final FMLCommonSetupEvent event) { }
    private void loadComplete(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event) { }





}



