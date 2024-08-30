package com.xiaosuoaa.moreliver.datagen;

import com.xiaosuoaa.moreliver.datagen.recipes.compressor.StructuralCompressorRecipeBuilder;
import com.xiaosuoaa.moreliver.items.NeoForgeItemRegisterBus;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
	public static RecipeOutput recipeOutput;

	public ModRecipeProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(pPackOutput, lookupProvider);
	}

	@Override
	protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
		buildCoalsRecipes(pRecipeOutput);
		recipeOutput = pRecipeOutput;
	}

	private void buildCoalsRecipes(RecipeOutput recipeOutput) {
		var stick = Items.STICK;

		//coal
		var unCoal = "has_coal";
		var coal = Items.COAL;
		shapedAxeRecipe(recipeOutput, NeoForgeItemRegisterBus.COAL_AXE.get(), coal, stick, unCoal);
		shapedPickaxeRecipe(recipeOutput, NeoForgeItemRegisterBus.COAL_PICKAXE.get(), coal, stick, unCoal);
		shapedSwordRecipe(recipeOutput, NeoForgeItemRegisterBus.COAL_SWORD.get(), coal, stick, unCoal);

		//coal_ex1
		var unEx1 = "has_coal_ex1";
		var ex1 = NeoForgeItemRegisterBus.COAL_EX1.get();
		shapedZipRecipe(recipeOutput, ex1, coal, Items.COBBLESTONE, unCoal);
		shapedAxeRecipe(recipeOutput, NeoForgeItemRegisterBus.COAL_AXE_EX1.get(), ex1, stick, unEx1);
		shapedPickaxeRecipe(recipeOutput, NeoForgeItemRegisterBus.COAL_PICKAXE_EX1.get(), ex1, stick, unEx1);
		shapedSwordRecipe(recipeOutput, NeoForgeItemRegisterBus.COAL_SWORD_EX1.get(), ex1, stick, unEx1);

		//coal_ex2
		var unEx2 = "has_coal_ex2";
		var ex2 = NeoForgeItemRegisterBus.COAL_EX2.get();
		structuralCompressorRecipeSingleItem(recipeOutput, ex1, ex2, unEx2);
	}

	private static void structuralCompressorRecipeSingleItem(@NotNull RecipeOutput pRecipeOutput, Item input, Item output, String unlockedName) {
		new StructuralCompressorRecipeBuilder(output, 1)
				.pattern("aa")
				.pattern("aa")
				.define('a', input)
				.unlockedBy(unlockedName, has(MinMaxBounds.Ints.exactly(4), output))
				.save(pRecipeOutput);
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
