package com.xiaosuoaa.moreliver;

import com.xiaosuoaa.moreliver.blocks.NeoForgeBlockRegisterBus;
import com.xiaosuoaa.moreliver.items.NeoForgeItemRegisterBus;
import com.xiaosuoaa.moreliver.ui.NeoForgeScreenRegisterBus;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(value = MoreLiver.MODID, dist = Dist.CLIENT)
public class MoreLiverClient {
	public MoreLiverClient(IEventBus modEventBus) {
		modEventBus.addListener(this::buildContents);
		modEventBus.addListener(NeoForgeScreenRegisterBus::register);
	}

	@SubscribeEvent
	private void buildContents(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			NeoForgeItemRegisterBus.registerCoalsToIGIngredient(event);
		} else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			NeoForgeItemRegisterBus.registerCoalToolsToIGToolsAndUtilities(event);
		} else if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			NeoForgeBlockRegisterBus.registerBlocksToIGNature(event);
		} else if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			NeoForgeBlockRegisterBus.registerBlocksToIGFunctionalBlocks(event);
		}
	}
}
