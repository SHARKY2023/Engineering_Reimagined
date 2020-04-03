package com.SHARKY2023.engineeringreimagined;


import com.SHARKY2023.engineeringreimagined.list.BlockList;
import com.SHARKY2023.engineeringreimagined.list.ItemList;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MOD_ID)
@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Main {

    public static ItemGroup TabCBlock = new ItemGroup(Main.MOD_ID +"Blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockList.COPPER_BLOCK.get());
        }
    };
    public static ItemGroup TabCItems = new ItemGroup(Main.MOD_ID +"Items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemList.RUBY.get());
        }
    };


    public static Main instance;
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "er2023";



    public Main() {

        instance = this;

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        BlockList.BLOCKS.register(modEventBus);
        ItemList.ITEMS.register(modEventBus);

        /*
        ItemList.inititem();
        BlockList.initblock();
*/

    }


    @SubscribeEvent
    public static void createBlockItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockList.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(Main.TabCBlock);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event) { }





}



