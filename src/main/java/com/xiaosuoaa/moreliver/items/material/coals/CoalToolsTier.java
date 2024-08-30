package com.xiaosuoaa.moreliver.items.material.coals;

import com.xiaosuoaa.moreliver.items.NeoForgeItemRegisterBus;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;

public class CoalToolsTier {
	public static final Tier COAL_TIER = new SimpleTier(
			BlockTags.INCORRECT_FOR_WOODEN_TOOL,
			150,
			4.5f,
			2f,
			25,
			() -> Ingredient.of(Tags.Items.ORES_COAL)
	);
	public static final Tier COAL_TIER_EX1 = new SimpleTier(
			BlockTags.INCORRECT_FOR_STONE_TOOL,
			250,
			6f,
			3f,
			20,
			() -> Ingredient.of(NeoForgeItemRegisterBus.COAL_EX1.get())
	);
	public static final Tier COAL_TIER_EX2 = new SimpleTier(
			BlockTags.INCORRECT_FOR_IRON_TOOL,
			400,
			8f,
			4f,
			30,
			() -> Ingredient.of(NeoForgeItemRegisterBus.COAL_EX2.get())
	);
	public static final Tier COAL_TIER_EX3 = new SimpleTier(
			BlockTags.INCORRECT_FOR_IRON_TOOL,
			512,
			10f,
			5f,
			64,
			() -> Ingredient.of(NeoForgeItemRegisterBus.COAL_EX3.get())
	);
	public static final Tier COAL_TIER_EX4 = new SimpleTier(
			BlockTags.INCORRECT_FOR_IRON_TOOL,
			1024,
			6f,
			6f,
			80,
			() -> Ingredient.of(NeoForgeItemRegisterBus.COAL_EX4.get())
	);
	public static final Tier COAL_TIER_EX5 = new SimpleTier(
			BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
			2048,
			6f,
			8f,
			80,
			() -> Ingredient.of(NeoForgeItemRegisterBus.COAL_EX5.get())
	);
}