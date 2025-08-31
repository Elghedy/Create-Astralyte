package net.elghed.astralytemod.item;

import net.elghed.astralytemod.AstralyteMod;
import net.elghed.astralytemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AstralyteMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ASTRALYTE_INGOT.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_ASTRALYTE.get());
                        pOutput.accept(ModItems.ASTRALYTE_INGOT.get());

                        pOutput.accept(ModItems.ASTRALYTE_PICKAXE.get());
                        pOutput.accept(ModItems.ASTRALYTE_SWORD.get());
                        pOutput.accept(ModItems.ASTRALYTE_AXE.get());
                        pOutput.accept(ModItems.ASTRALYTE_SHOVEL.get());
                        pOutput.accept(ModItems.ASTRALYTE_HOE.get());

                        pOutput.accept(ModBlocks.ASTRALYTE_ORE.get());
                        pOutput.accept(ModBlocks.ASTRALYTE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_ASTRALYTE_BLOCK.get());

                        pOutput.accept(ModItems.ASTRALYTE_HELMET.get());
                        pOutput.accept(ModItems.ASTRALYTE_CHESTPLATE.get());
                        pOutput.accept(ModItems.ASTRALYTE_LEGGINGS.get());
                        pOutput.accept(ModItems.ASTRALYTE_BOOTS.get());
                    })

                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
