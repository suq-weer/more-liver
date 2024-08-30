package com.xiaosuoaa.moreliver.datagen.recipes;

import com.xiaosuoaa.moreliver.MoreLiver;
import com.xiaosuoaa.moreliver.datagen.recipes.compressor.StructuralCompressorRecipe;
import com.xiaosuoaa.moreliver.datagen.recipes.compressor.StructuralCompressorRecipeSerializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RecipeSerializerRegisterBus {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
        DeferredRegister.create(Registries.RECIPE_SERIALIZER, MoreLiver.MODID);
	public static void register(IEventBus eventBus) {
		RECIPE_SERIALIZERS.register(eventBus);
	}

	public static final Supplier<RecipeSerializer<StructuralCompressorRecipe>> STRUCTURAL_COMPRESSOR =
        RECIPE_SERIALIZERS.register("structural_compressor", StructuralCompressorRecipeSerializer::new);
}
