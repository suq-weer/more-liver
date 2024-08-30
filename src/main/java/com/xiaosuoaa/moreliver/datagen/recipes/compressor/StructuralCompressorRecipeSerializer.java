package com.xiaosuoaa.moreliver.datagen.recipes.compressor;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import org.jetbrains.annotations.NotNull;

public class StructuralCompressorRecipeSerializer implements RecipeSerializer<StructuralCompressorRecipe> {
	public static final MapCodec<StructuralCompressorRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
			ShapedRecipePattern.MAP_CODEC.forGetter(StructuralCompressorRecipe::getPattern),
            ItemStack.CODEC.fieldOf("result").forGetter(StructuralCompressorRecipe::getResult)
    ).apply(inst, StructuralCompressorRecipe::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, StructuralCompressorRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ShapedRecipePattern.STREAM_CODEC, StructuralCompressorRecipe::getPattern,
                    ItemStack.STREAM_CODEC, StructuralCompressorRecipe::getResult,
					StructuralCompressorRecipe::new
            );

	@Override
	public @NotNull MapCodec<StructuralCompressorRecipe> codec() {
		return CODEC;
	}

	@Override
	public @NotNull StreamCodec<RegistryFriendlyByteBuf, StructuralCompressorRecipe> streamCodec() {
		return STREAM_CODEC;
	}
}
