package com.xiaosuoaa.moreliver.items.material.coals;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CoalEX7 extends Item {
	public CoalEX7() {
		super(new Properties()
				.stacksTo(64)
				.rarity(Rarity.EPIC)
		);
	}

	@Override
	public void appendHoverText(@NotNull ItemStack pStack, @NotNull TooltipContext pContext, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pTooltipFlag) {
		super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
		pTooltipComponents.add(Component.translatable("item.moreliver.coal_ex7.tooltip"));
	}
}
