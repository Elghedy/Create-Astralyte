package net.elghed.astralytemod;

import com.mojang.logging.LogUtils;
import net.elghed.astralytemod.block.ModBlocks;
import net.elghed.astralytemod.item.ModCreativeModTabs;
import net.elghed.astralytemod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AstralyteMod.MOD_ID)
public class AstralyteMod {
    public static final String MOD_ID = "astralytemod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AstralyteMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_ASTRALYTE);
            event.accept(ModItems.ASTRALYTE_INGOT);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.ASTRALYTE_PICKAXE);
            event.accept(ModItems.ASTRALYTE_SHOVEL);
            event.accept(ModItems.ASTRALYTE_HOE);
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.ASTRALYTE_SWORD);
            event.accept(ModItems.ASTRALYTE_AXE);
            event.accept(ModItems.ASTRALYTE_HELMET);
            event.accept(ModItems.ASTRALYTE_CHESTPLATE);
            event.accept(ModItems.ASTRALYTE_LEGGINGS);
            event.accept(ModItems.ASTRALYTE_BOOTS);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.ASTRALYTE_ORE);
            event.accept(ModBlocks.RAW_ASTRALYTE_BLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ASTRALYTE_BLOCK);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
