package com.xiaosuoaa.moreliver.emi;

import com.xiaosuoaa.moreliver.datagen.recipes.compressor.StructuralCompressorRecipe;
import com.xiaosuoaa.moreliver.items.NeoForgeItemRegisterBus;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class StructuralCompressorRecipeEMI implements EmiRecipe {
	private final ResourceLocation id;
	private final List<EmiIngredient> input;
	private final List<EmiStack> output;

	public StructuralCompressorRecipeEMI(StructuralCompressorRecipe recipe) {
		List<EmiIngredient> ingredients = new java.util.ArrayList<>(List.of());
		for (int i = 0; i <= recipe.getIngredients().size()-1; i++) {
			ingredients.add(EmiIngredient.of(recipe.getIngredients().get(i)));
		}
		this.id = recipe.getId();
		this.input = ingredients;
		this.output = List.of(EmiStack.of(recipe.getResult()));
	}

	@Override
	public EmiRecipeCategory getCategory() {
		return ModEMIPlugin.STRUCTURAL_COMPRESSOR_CATEGORY;
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public List<EmiIngredient> getInputs() {
		return input;
	}

	@Override
	public List<EmiStack> getOutputs() {
		return output;
	}

	@Override
	public int getDisplayWidth() {
		return 84;
	}

	@Override
	public int getDisplayHeight() {
		return 48;
	}

	@Override
	public void addWidgets(WidgetHolder widgets) {
		widgets.addTexture(ModEmiTexture.BOTH_ARROW, 34, 2);

		widgets.addSlot(input.getFirst(), 0, 0);
		widgets.addSlot(input.get(1), 16, 0);
		widgets.addSlot(input.get(2), 0, 16);
		widgets.addSlot(input.get(3), 16, 16);
		widgets.addSlot(EmiIngredient.of(Ingredient.of(NeoForgeItemRegisterBus.WATER_INGOT.get())), 40, 28);

		widgets.addSlot(output.getFirst(), 66, 8).recipeContext(this);
	}
}
