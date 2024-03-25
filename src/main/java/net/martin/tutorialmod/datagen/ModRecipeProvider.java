package net.martin.tutorialmod.datagen;

import net.martin.tutorialmod.TutorialMod;
import net.martin.tutorialmod.block.ModBlocks;
import net.martin.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

import static net.minecraft.world.item.Items.STICK;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> HABER_SMELTABLES = List.of(
            ModBlocks.RAW_HABER_BLOCK.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter,HABER_SMELTABLES,RecipeCategory.MISC,ModItems.HABER.get(),0.25f,200,"haber");
        oreBlasting(pWriter,HABER_SMELTABLES,RecipeCategory.MISC,ModItems.HABER.get(),0.25f,200,"haber");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HABER_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.HABER.get())
                .unlockedBy(getHasName(ModItems.HABER.get()), has(ModItems.HABER.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.HABER.get(),9)
                .requires(ModBlocks.HABER_BLOCK.get()
                ).unlockedBy(getHasName(ModBlocks.HABER_BLOCK.get()),
                        has(ModBlocks.HABER_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HABER_WAPON.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('P', ModItems.HABER.get())
                .define('S', STICK)
                .unlockedBy(getHasName(ModItems.HABER.get()), has(ModItems.HABER.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,STICK,8)
                .requires(ModItems.HABER.get()
                ).unlockedBy(getHasName(ModItems.HABER.get()),
                        has(ModItems.HABER.get()))
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
                    .save(pFinishedRecipeConsumer,  TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
