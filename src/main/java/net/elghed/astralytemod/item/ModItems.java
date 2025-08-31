package net.elghed.astralytemod.item;

import net.elghed.astralytemod.AstralyteMod;
import net.elghed.astralytemod.item.custom.ModArmorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AstralyteMod.MOD_ID);

    public static final RegistryObject<Item> RAW_ASTRALYTE = ITEMS.register("raw_astralyte",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASTRALYTE_INGOT = ITEMS.register("astralyte_ingot",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> ASTRALYTE_SWORD = ITEMS.register("astralyte_sword",
            () -> new SwordItem(ModToolTiers.ASTRALYTE, 3, -2.1F, new Item.Properties()));
    public static final RegistryObject<Item> ASTRALYTE_PICKAXE = ITEMS.register("astralyte_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ASTRALYTE, 1, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> ASTRALYTE_AXE = ITEMS.register("astralyte_axe",
            () -> new AxeItem(ModToolTiers.ASTRALYTE, 5, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> ASTRALYTE_SHOVEL = ITEMS.register("astralyte_shovel",
            () -> new ShovelItem(ModToolTiers.ASTRALYTE, 1.5F, -2.7F, new Item.Properties()));
    public static final RegistryObject<Item> ASTRALYTE_HOE = ITEMS.register("astralyte_hoe",
            () -> new HoeItem(ModToolTiers.ASTRALYTE, -3, -1.0F, new Item.Properties()));


    public static final RegistryObject<Item> ASTRALYTE_HELMET = ITEMS.register("astralyte_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ASTRALYTE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ASTRALYTE_CHESTPLATE = ITEMS.register("astralyte_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ASTRALYTE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ASTRALYTE_LEGGINGS = ITEMS.register("astralyte_leggings",
            () -> new ArmorItem(ModArmorMaterials.ASTRALYTE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ASTRALYTE_BOOTS = ITEMS.register("astralyte_boots",
            () -> new ArmorItem(ModArmorMaterials.ASTRALYTE, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
