package net.elghed.astralytemod.datagen;

import net.elghed.astralytemod.AstralyteMod;
import net.elghed.astralytemod.block.ModBlocks;
import net.elghed.astralytemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ASTRALYTE_SMELTABLES = List.of(ModItems.RAW_ASTRALYTE.get(),
            ModBlocks.ASTRALYTE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, ASTRALYTE_SMELTABLES, RecipeCategory.MISC, ModItems.ASTRALYTE_INGOT.get(), 0.25f, 200, "astralyte");
        oreBlasting(pWriter, ASTRALYTE_SMELTABLES, RecipeCategory.MISC, ModItems.ASTRALYTE_INGOT.get(), 0.25f, 100, "astralyte");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ASTRALYTE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.ASTRALYTE_INGOT.get())
                .unlockedBy(getHasName(ModItems.ASTRALYTE_INGOT.get()), has(ModItems.ASTRALYTE_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ASTRALYTE_INGOT.get(), 9)
                .requires(ModBlocks.ASTRALYTE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ASTRALYTE_BLOCK.get()), has(ModBlocks.ASTRALYTE_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  AstralyteMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
