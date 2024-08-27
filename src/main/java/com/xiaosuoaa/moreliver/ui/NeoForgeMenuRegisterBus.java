package com.xiaosuoaa.moreliver.ui;

import com.xiaosuoaa.moreliver.MoreLiver;
import com.xiaosuoaa.moreliver.ui.menu.StructuralCompressorMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.core.registries.BuiltInRegistries.REGISTRY;

public class NeoForgeMenuRegisterBus {
	public static final DeferredRegister<MenuType<?>> MENU_TYPE = DeferredRegister.create(Registries.MENU, MoreLiver.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<StructuralCompressorMenu>> STRUCTURAL_COMPRESSOR_GUI = MENU_TYPE.register("structural_compressor_gui", () -> IMenuTypeExtension.create(StructuralCompressorMenu::new));
	public static void register(IEventBus eventBus){
		MENU_TYPE.register(eventBus);
	}
}
