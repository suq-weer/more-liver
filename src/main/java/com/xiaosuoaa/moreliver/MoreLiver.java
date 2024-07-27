package com.xiaosuoaa.moreliver;

import com.mojang.logging.LogUtils;
import com.xiaosuoaa.moreliver.blocks.BlockRegisterBus;
import com.xiaosuoaa.moreliver.creativetabs.ModCreativeTabs;
import com.xiaosuoaa.moreliver.items.ItemRegisterBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(MoreLiver.MODID)
public class MoreLiver
{
	public static final String MODID = "moreliver";
	private static final Logger LOGGER = LogUtils.getLogger();

	public MoreLiver(IEventBus modEventBus)
	{
		modEventBus.addListener(this::commonSetup);
		ItemRegisterBus.register(modEventBus);
		ModCreativeTabs.register(modEventBus);
		BlockRegisterBus.register(modEventBus);
		modEventBus.register(this);
	}

	@SubscribeEvent
	private void commonSetup(FMLCommonSetupEvent event) {}
}

