package com.xiaosuoaa.moreliver.datagen.recipes.compressor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StructuralCompressorRecipeBuilder implements RecipeBuilder {
	private final ItemStack result;
	private final List<String> rows = Lists.newArrayList();
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
	private final Map<Character, Ingredient> key = Maps.newLinkedHashMap();

	public StructuralCompressorRecipeBuilder(ItemStack result) {
		this.result = result;
    }

	public StructuralCompressorRecipeBuilder(ItemLike pResult, int pCount) {
        this(new ItemStack(pResult, pCount));
    }

	public StructuralCompressorRecipeBuilder pattern(String pPattern) {
        if (!this.rows.isEmpty() && pPattern.length() != this.rows.getFirst().length()) {
            throw new IllegalArgumentException("Pattern must be the same width on every line!");
        } else {
            this.rows.add(pPattern);
            return this;
        }
    }

	@Override
	public @NotNull RecipeBuilder unlockedBy(@NotNull String pName, @NotNull Criterion<?> pCriterion) {
		this.criteria.put(pName, pCriterion);
        return this;
	}

	@Override
	public @NotNull RecipeBuilder group(@Nullable String pGroupName) {
		return this;
	}

	public StructuralCompressorRecipeBuilder define(Character pSymbol, ItemLike pItem) {
        return this.define(pSymbol, Ingredient.of(pItem));
    }

    public StructuralCompressorRecipeBuilder define(Character pSymbol, Ingredient pIngredient) {
        if (this.key.containsKey(pSymbol)) {
            throw new IllegalArgumentException("Symbol '" + pSymbol + "' is already defined!");
        } else if (pSymbol == ' ') {
            throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
        } else {
            this.key.put(pSymbol, pIngredient);
            return this;
        }
    }

	@Override
	public @NotNull Item getResult() {
		return this.result.getItem();
	}

	@Override
	public void save(RecipeOutput pRecipeOutput, @NotNull ResourceLocation pId) {
		ShapedRecipePattern shapedrecipepattern = this.ensureValid(pId);
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
            .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
            .rewards(AdvancementRewards.Builder.recipe(pId))
            .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        StructuralCompressorRecipe structuralCompressorRecipe = new StructuralCompressorRecipe(
            shapedrecipepattern,
            this.result
		);
        pRecipeOutput.accept(pId, structuralCompressorRecipe, advancement$builder.build(pId.withPrefix("recipes/structural_compressor/")));
	}

	private ShapedRecipePattern ensureValid(ResourceLocation pLocation) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pLocation);
        } else {
            return ShapedRecipePattern.of(this.key, this.rows);
        }
    }
}