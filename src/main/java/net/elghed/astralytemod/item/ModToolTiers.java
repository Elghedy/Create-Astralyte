package net.elghed.astralytemod.item;

import net.elghed.astralytemod.AstralyteMod;
import net.elghed.astralytemod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier ASTRALYTE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2500, 11f, 5f, 20,
                    ModTags.Blocks.NEEDS_ASTRALYTE_TOOL, () -> Ingredient.of(ModItems.ASTRALYTE_INGOT.get())),
            new ResourceLocation(AstralyteMod.MOD_ID, "astralyte"), List.of(Tiers.NETHERITE), List.of());

}
