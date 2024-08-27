package com.xiaosuoaa.moreliver.creativetabs;

import com.xiaosuoaa.moreliver.MoreLiver;
import com.xiaosuoaa.moreliver.blocks.NeoForgeBlockRegisterBus;
import com.xiaosuoaa.moreliver.items.NeoForgeItemRegisterBus;
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
	public static final Supplier<CreativeModeTab> MORELIVER;

	static {
		MORELIVER = CREATIVE_MODE_TABS.register(MoreLiver.MODID, () -> CreativeModeTab.builder()
				.withTabsBefore(CreativeModeTabs.COMBAT)
				.title(Component.translatable("itemGroup." + MoreLiver.MODID + ".moreliver"))
				.icon(() -> NeoForgeItemRegisterBus.COAL_EX1.get().getDefaultInstance())
				.displayItems((params, output) -> {
					//压缩煤炭1到9级
					output.accept(NeoForgeItemRegisterBus.COAL_EX1.get());
					output.accept(NeoForgeItemRegisterBus.COAL_EX2.get());
					output.accept(NeoForgeItemRegisterBus.COAL_EX3.get());
					output.accept(NeoForgeItemRegisterBus.COAL_EX4.get());
					output.accept(NeoForgeItemRegisterBus.COAL_EX5.get());
					output.accept(NeoForgeItemRegisterBus.COAL_EX6.get());
					output.accept(NeoForgeItemRegisterBus.COAL_EX7.get());
					output.accept(NeoForgeItemRegisterBus.COAL_EX8.get());
					output.accept(NeoForgeItemRegisterBus.COAL_EX9.get());
					//煤炭工具1到5级
					output.accept(NeoForgeItemRegisterBus.COAL_PICKAXE.get());
					output.accept(NeoForgeItemRegisterBus.COAL_AXE.get());
					output.accept(NeoForgeItemRegisterBus.COAL_SWORD.get());
					output.accept(NeoForgeItemRegisterBus.COAL_PICKAXE_EX1.get());
					output.accept(NeoForgeItemRegisterBus.COAL_AXE_EX1.get());
					output.accept(NeoForgeItemRegisterBus.COAL_SWORD_EX1.get());
					output.accept(NeoForgeItemRegisterBus.COAL_PICKAXE_EX2.get());
					output.accept(NeoForgeItemRegisterBus.COAL_AXE_EX2.get());
					output.accept(NeoForgeItemRegisterBus.COAL_SWORD_EX2.get());
					output.accept(NeoForgeItemRegisterBus.COAL_PICKAXE_EX3.get());
					output.accept(NeoForgeItemRegisterBus.COAL_AXE_EX3.get());
					output.accept(NeoForgeItemRegisterBus.COAL_SWORD_EX3.get());
					output.accept(NeoForgeItemRegisterBus.COAL_PICKAXE_EX4.get());
					output.accept(NeoForgeItemRegisterBus.COAL_AXE_EX4.get());
					output.accept(NeoForgeItemRegisterBus.COAL_SWORD_EX4.get());
					output.accept(NeoForgeItemRegisterBus.COAL_PICKAXE_EX5.get());
					output.accept(NeoForgeItemRegisterBus.COAL_AXE_EX5.get());
					output.accept(NeoForgeItemRegisterBus.COAL_SWORD_EX5.get());
					//钛
					output.accept(NeoForgeItemRegisterBus.TITANIUM.get());
					output.accept(NeoForgeBlockRegisterBus.ILMENITE_ITEM.get());
					output.accept(NeoForgeBlockRegisterBus.DEEPSLATE_ILMENITE_ITEM.get());
					//水加工物
					output.accept(NeoForgeItemRegisterBus.RAW_WATER.get());
					output.accept(NeoForgeItemRegisterBus.WATER_INGOT.get());
				})
				.build()
		);
	}

	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
}
