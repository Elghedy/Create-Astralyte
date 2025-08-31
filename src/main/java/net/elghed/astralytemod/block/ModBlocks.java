package net.elghed.astralytemod.block;

import net.elghed.astralytemod.AstralyteMod;
import net.elghed.astralytemod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AstralyteMod.MOD_ID);

    public static final RegistryObject<Block> ASTRALYTE_ORE = registerBlock("astralyte_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS).sound(SoundType.STONE)
                    .strength(5f, 3600000.0f).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));
    public static final RegistryObject<Block> ASTRALYTE_BLOCK = registerBlock("astralyte_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).sound(SoundType.NETHERITE_BLOCK)
                    .strength(5f, 3600000.0f)));
    public static final RegistryObject<Block> RAW_ASTRALYTE_BLOCK = registerBlock("raw_astralyte_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS).sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(5f, 3600000.0f)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
