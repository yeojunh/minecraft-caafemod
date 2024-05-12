package net.caafe.caafemod.datagen;

import net.caafe.caafemod.block.ModBlocks;
import net.caafe.caafemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    // better used for ores that come in deep slate, nether, end stone, etc.
    private static final List<ItemLike> COFFEE_SMELTABLES = List.of(ModItems.COFFEE_BEAN.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        oreSmelting(recipeOutput, COFFEE_SMELTABLES, RecipeCategory.FOOD, ModItems.ROASTED_COFFEE_BEAN.get(), 0.1F, 200, "roasted_coffee_bean");

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlocks.BLOCK_OF_COFFEE_BEANS.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.COFFEE_BEAN.get())
                .unlockedBy(getHasName(ModItems.COFFEE_BEAN.get()), has(ModItems.COFFEE_BEAN.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COFFEE_BEAN.get(), 9)
                .requires(ModBlocks.BLOCK_OF_COFFEE_BEANS.get())
                .unlockedBy(getHasName(ModBlocks.BLOCK_OF_COFFEE_BEANS.get()), has(ModBlocks.BLOCK_OF_COFFEE_BEANS.get()))
                .save(recipeOutput);
    }

    // for ores
    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator var10 = pIngredients.iterator();

        while(var10.hasNext()) {
            ItemLike itemlike = (ItemLike)var10.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pRecipeOutput, getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }

}
