package com.xiaosuoaa.moreliver.items.material.coals;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;

public class CoalToolsTier {
	public static final Tier COAL_TIER = new SimpleTier(
			CoalToolsTag.INCORRECT_COAL_TOOL,
			150,
			4.5f,
			2f,
			25,
			() -> Ingredient.of(Tags.Items.ORES_COAL)
	);
	public static final Tier COAL_TIER_EX1 = new SimpleTier(
			CoalToolsTag.INCORRECT_COAL_TOOL,
			250,
			6f,
			3f,
			20,
			() -> Ingredient.of(Tags.Items.ORES_COAL)
	);
	public static final Tier COAL_TIER_EX2 = new SimpleTier(
			CoalToolsTag.INCORRECT_COAL_TOOL,
			400,
			8f,
			4f,
			30,
			() -> Ingredient.of(Tags.Items.ORES_COAL)
	);
	public static final Tier COAL_TIER_EX3 = new SimpleTier(
			CoalToolsTag.INCORRECT_COAL_TOOL,
			512,
			10f,
			5f,
			64,
			() -> Ingredient.of(Tags.Items.ORES_COAL)
	);
	public static final Tier COAL_TIER_EX4 = new SimpleTier(
			CoalToolsTag.INCORRECT_COAL_TOOL,
			1024,
			6f,
			6f,
			80,
			() -> Ingredient.of(Tags.Items.ORES_COAL)
	);
	public static final Tier COAL_TIER_EX5 = new SimpleTier(
			CoalToolsTag.INCORRECT_COAL_TOOL,
			2048,
			6f,
			8f,
			80,
			() -> Ingredient.of(Tags.Items.ORES_COAL)
	);
}