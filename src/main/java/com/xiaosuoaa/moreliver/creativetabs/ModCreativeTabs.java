package com.xiaosuoaa.moreliver.creativetabs;

import com.xiaosuoaa.moreliver.MoreLiver;
import com.xiaosuoaa.moreliver.blocks.BlockRegisterBus;
import com.xiaosuoaa.moreliver.items.ItemRegisterBus;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
	private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
			BuiltInRegistries.CREATIVE_MODE_TAB,
			MoreLiver.MODID
	);
	public static final Supplier<CreativeModeTab> MORELIVER = CREATIVE_MODE_TABS.register(MoreLiver.MODID, () -> CreativeModeTab.builder()
			.withTabsBefore(CreativeModeTabs.COMBAT)
			.title(Component.translatable("itemGroup." + MoreLiver.MODID + ".moreliver"))
			.icon(() -> ItemRegisterBus.COAL_EX1.get().getDefaultInstance())
			.displayItems((params, output) -> {
				//压缩煤炭1到9级
				output.accept(ItemRegisterBus.COAL_EX1.get());
				output.accept(ItemRegisterBus.COAL_EX2.get());
				output.accept(ItemRegisterBus.COAL_EX3.get());
				output.accept(ItemRegisterBus.COAL_EX4.get());
				output.accept(ItemRegisterBus.COAL_EX5.get());
				output.accept(ItemRegisterBus.COAL_EX6.get());
				output.accept(ItemRegisterBus.COAL_EX7.get());
				output.accept(ItemRegisterBus.COAL_EX8.get());
				output.accept(ItemRegisterBus.COAL_EX9.get());
				//煤炭工具1到5级
				output.accept(ItemRegisterBus.COAL_PICKAXE.get());
				output.accept(ItemRegisterBus.COAL_AXE.get());
				output.accept(ItemRegisterBus.COAL_SWORD.get());
				output.accept(ItemRegisterBus.COAL_PICKAXE_EX1.get());
				output.accept(ItemRegisterBus.COAL_AXE_EX1.get());
				output.accept(ItemRegisterBus.COAL_SWORD_EX1.get());
				output.accept(ItemRegisterBus.COAL_PICKAXE_EX2.get());
				output.accept(ItemRegisterBus.COAL_AXE_EX2.get());
				output.accept(ItemRegisterBus.COAL_SWORD_EX2.get());
				output.accept(ItemRegisterBus.COAL_PICKAXE_EX3.get());
				output.accept(ItemRegisterBus.COAL_AXE_EX3.get());
				output.accept(ItemRegisterBus.COAL_SWORD_EX3.get());
				output.accept(ItemRegisterBus.COAL_PICKAXE_EX4.get());
				output.accept(ItemRegisterBus.COAL_AXE_EX4.get());
				output.accept(ItemRegisterBus.COAL_SWORD_EX4.get());
				output.accept(ItemRegisterBus.COAL_PICKAXE_EX5.get());
				output.accept(ItemRegisterBus.COAL_AXE_EX5.get());
				output.accept(ItemRegisterBus.COAL_SWORD_EX5.get());
				output.accept(ItemRegisterBus.TITANIUM.get());
				output.accept(BlockRegisterBus.ILMENITE_ITEM.get());
				output.accept(BlockRegisterBus.DEEPSLATE_ILMENITE_ITEM.get());
			})
			.build()
	);

	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
}
