package com.xiaosuoaa.moreliver.datagen.recipes.compressor;

import com.xiaosuoaa.moreliver.MoreLiver;
import com.xiaosuoaa.moreliver.datagen.recipes.RecipeSerializerRegisterBus;
import com.xiaosuoaa.moreliver.datagen.recipes.RecipeTypeRegisterBus;
import com.xiaosuoaa.moreliver.items.NeoForgeItemRegisterBus;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class StructuralCompressorRecipe implements Recipe<CraftingInput> {
	public final ShapedRecipePattern pattern;
    private final ItemStack result;

	public StructuralCompressorRecipe(ShapedRecipePattern shapedrecipepattern, ItemStack result) {
		this.pattern = shapedrecipepattern;
		this.result = result;
	}

    public @NotNull NonNullList<Ingredient> getIngredients() {
        return this.pattern.ingredients();
    }

	@Override
	public boolean matches(@NotNull CraftingInput pInput, @NotNull Level pLevel) {
		return this.pattern.matches(pInput);
	}

	@Override
	public @NotNull ItemStack assemble(@NotNull CraftingInput pInput, HolderLookup.@NotNull Provider pRegistries) {
		return this.result.copy();
	}

	//检测配方格子长宽
	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return pWidth == 2 && pHeight == 2;
	}

	@Override
	public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider pRegistries) {
		return this.result;
	}

	@Override
	public @NotNull RecipeSerializer<?> getSerializer() {
		return RecipeSerializerRegisterBus.STRUCTURAL_COMPRESSOR.get();
	}

	@Override
	public @NotNull RecipeType<?> getType() {
		return RecipeTypeRegisterBus.STRUCTURAL_COMPRESSOR.get();
	}

	public ItemStack getResult() {
		return result;
	}

	public ShapedRecipePattern getPattern() {
		return pattern;
	}

	public static List<ItemStack> getFuel() {
		List<ItemStack> re = new ArrayList<>();
		re.add(NeoForgeItemRegisterBus.WATER_INGOT.get().getDefaultInstance());
		return re;
	}

	public ResourceLocation getId() {
		return ResourceLocation.fromNamespaceAndPath(MoreLiver.MODID, "structural_compressor");
	}
}
