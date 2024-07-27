package com.xiaosuoaa.moreliver.items.coals;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CoalEX4 extends Item {
	public CoalEX4(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
		super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
		pTooltipComponents.add(Component.translatable("item.moreliver.coal_ex4.tooltip"));
	}
}
