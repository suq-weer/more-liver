package com.xiaosuoaa.moreliver.datagen;

import com.xiaosuoaa.moreliver.items.CoalItems;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pPackOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        buildCoalsRecipes(pRecipeOutput);
    }

    private void buildCoalsRecipes(RecipeOutput recipeOutput) {
        var stick = Items.STICK;

        //coal
        var unCoal = "has_coal";
        var coal = Items.COAL;
        shapedAxeRecipe(recipeOutput, CoalItems.COAL_AXE.get(), coal, stick, unCoal);
        shapedPickaxeRecipe(recipeOutput, CoalItems.COAL_PICKAXE.get(), coal, stick, unCoal);
        shapedSwordRecipe(recipeOutput, CoalItems.COAL_SWORD.get(), coal, stick, unCoal);

        //coal_ex1
        var unEx1 = "has_coal_ex1";
        var ex1 = CoalItems.COAL_EX1.get();
        shapedZipRecipe(recipeOutput, ex1, coal, Items.COBBLESTONE, unCoal);
        shapedAxeRecipe(recipeOutput, CoalItems.COAL_AXE_EX1.get(), ex1, stick, unEx1);
        shapedPickaxeRecipe(recipeOutput, CoalItems.COAL_PICKAXE_EX1.get(), ex1, stick, unEx1);
        shapedSwordRecipe(recipeOutput, CoalItems.COAL_SWORD_EX1.get(), ex1, stick, unEx1);
    }

    public static void shapedZipRecipe(RecipeOutput pRecipeOutput, Item out, Item a, Item b, String unlockedName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, out)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', a)
                .define('b', b)
                .unlockedBy(unlockedName, has(MinMaxBounds.Ints.exactly(4), b))
                .save(pRecipeOutput);
    }
    public static void shapedAxeRecipe(RecipeOutput pRecipeOutput, Item out, Item a, Item b, String unlockedName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, out)
                .pattern("aa ")
                .pattern("ab ")
                .pattern(" b ")
                .define('a', a)
                .define('b', b)
                .unlockedBy(unlockedName, has(a))
                .save(pRecipeOutput);
    }
    public static void shapedPickaxeRecipe(RecipeOutput pRecipeOutput, Item out, Item a, Item b, String unlockedName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, out)
                .pattern("aaa")
                .pattern(" b ")
                .pattern(" b ")
                .define('a', a)
                .define('b', b)
                .unlockedBy(unlockedName, has(a))
                .save(pRecipeOutput);
    }
    public static void shapedSwordRecipe(RecipeOutput pRecipeOutput, Item out, Item a, Item b, String unlockedName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, out)
                .pattern(" a ")
                .pattern(" a ")
                .pattern(" b ")
                .define('a', a)
                .define('b', b)
                .unlockedBy(unlockedName, has(a))
                .save(pRecipeOutput);
    }
    public static void shapedHoeRecipe(RecipeOutput pRecipeOutput, Item out, Item a, Item b, String unlockedName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, out)
                .pattern("aa ")
                .pattern(" b ")
                .pattern(" b ")
                .define('a', a)
                .define('b', b)
                .unlockedBy(unlockedName, has(a))
                .save(pRecipeOutput);
    }
    public static void shapedShovelRecipe(RecipeOutput pRecipeOutput, Item out, Item a, Item b, String unlockedName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, out)
                .pattern(" a ")
                .pattern(" b ")
                .pattern(" b ")
                .define('a', a)
                .define('b', b)
                .unlockedBy(unlockedName, has(a))
                .save(pRecipeOutput);
    }
}
