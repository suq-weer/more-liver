package com.xiaosuoaa.moreliver.jei;

import com.xiaosuoaa.moreliver.MoreLiver;
import com.xiaosuoaa.moreliver.blocks.NeoForgeBlockRegisterBus;
import com.xiaosuoaa.moreliver.datagen.recipes.StructuralCompressorRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StructuralCompressorRecipeCategory implements IRecipeCategory<StructuralCompressorRecipe> {
	public Class<StructuralCompressorRecipe> getRecipeClass() {
		return StructuralCompressorRecipe.class;
	}

	public static ResourceLocation getUid() {
		return ResourceLocation.fromNamespaceAndPath(MoreLiver.MODID, "structural_compressor");
	}

	@Override
	public RecipeType<StructuralCompressorRecipe> getRecipeType() {
		return new RecipeType<>(getUid(), StructuralCompressorRecipe.class);
	}

	@Override
	public @NotNull Component getTitle() {
		return Component.translatable("gui.moreliver.structural_compressor_gui.label_structural_compressor");
	}

	@Override
	public @NotNull IDrawable getBackground() {
		return null;
	}

	@Override
	public @Nullable IDrawable getIcon() {
		IGuiHelper iGuiHelper = MoreLiverJEIPlugin.iJeiHelpers.getGuiHelper();
		return iGuiHelper.createDrawableIngredient(new IIngredientType<ItemStack>() {
			@Override
			public @NotNull Class<? extends ItemStack> getIngredientClass() {
				return ItemStack.class;
			}
		}, new ItemStack(NeoForgeBlockRegisterBus.STRUCTURAL_COMPRESSOR_ITEM.get()));
	}

	@Override
	public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull StructuralCompressorRecipe recipe, @NotNull IFocusGroup focuses) {

	}

	@Override
	public void draw(@NotNull StructuralCompressorRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
	}
}
