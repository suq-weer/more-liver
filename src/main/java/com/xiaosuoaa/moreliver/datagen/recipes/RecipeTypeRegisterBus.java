package com.xiaosuoaa.moreliver.datagen.recipes;

import com.xiaosuoaa.moreliver.MoreLiver;
import com.xiaosuoaa.moreliver.datagen.recipes.compressor.StructuralCompressorRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RecipeTypeRegisterBus {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(Registries.RECIPE_TYPE, MoreLiver.MODID);
	public static void register(IEventBus eventBus) {
		RECIPE_TYPE.register(eventBus);
	}

	public static final Supplier<RecipeType<StructuralCompressorRecipe>> STRUCTURAL_COMPRESSOR = RECIPE_TYPE.register(
			"structural_compressor",
			()->RecipeType.simple(
					ResourceLocation.fromNamespaceAndPath(MoreLiver.MODID, "recipe/structural_compressor")
			)
	);
}
