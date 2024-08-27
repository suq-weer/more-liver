package com.xiaosuoaa.moreliver.items.material.water;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WaterIngot extends Item {
	public WaterIngot() {
		super(new Properties()
				.stacksTo(64)
				.rarity(Rarity.UNCOMMON)
		);
	}

	@Override
	public void appendHoverText(@NotNull ItemStack pStack, @NotNull TooltipContext pContext, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pTooltipFlag) {
		super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
		pTooltipComponents.add(Component.translatable("item.moreliver.water_ingot.tooltip"));
		pTooltipComponents.add(Component.translatable("item.isStructuralCompressorFuel.level1.tooltip"));
	}
}
