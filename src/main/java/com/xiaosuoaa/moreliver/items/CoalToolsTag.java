package com.xiaosuoaa.moreliver.items;

import com.xiaosuoaa.moreliver.MoreLiver;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CoalToolsTag {
	public static final TagKey<Block> NEED_COAL_TOOL = TagKey.create(
			BuiltInRegistries.BLOCK.key(),
			ResourceLocation.fromNamespaceAndPath(
					MoreLiver.MODID,
					"need_coal_tool"
			)
	);
	public static final TagKey<Block> INCORRECT_COAL_TOOL = TagKey.create(
			BuiltInRegistries.BLOCK.key(),
			ResourceLocation.fromNamespaceAndPath(
					MoreLiver.MODID,
					"incorrect_coal_tool"
			)
	);
}
