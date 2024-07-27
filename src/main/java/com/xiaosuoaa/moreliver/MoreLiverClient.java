package com.xiaosuoaa.moreliver;

import com.xiaosuoaa.moreliver.blocks.BlockRegisterBus;
import com.xiaosuoaa.moreliver.items.ItemRegisterBus;
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
	}

	@SubscribeEvent
	private void buildContents(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			ItemRegisterBus.registerCoalsToIG(event);
		} else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			ItemRegisterBus.registerCoalToolsToIG(event);
		} else if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			BlockRegisterBus.registerBlocksToIG(event);
		}
	}
}
