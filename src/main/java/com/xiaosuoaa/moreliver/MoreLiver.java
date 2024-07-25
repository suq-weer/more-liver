package com.xiaosuoaa.moreliver;

import com.xiaosuoaa.moreliver.creativetabs.ModCreativeTabs;
import com.xiaosuoaa.moreliver.items.CoalItems;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MoreLiver.MODID)
public class MoreLiver
{
	// Define mod id in a common place for everything to reference
	public static final String MODID = "moreliver";
	// Directly reference a slf4j logger
	private static final Logger LOGGER = LogUtils.getLogger();

	public MoreLiver(IEventBus modEventBus)
	{
		modEventBus.addListener(this::commonSetup);
		CoalItems.register(modEventBus);
		ModCreativeTabs.register(modEventBus);
		modEventBus.register(this);
	}

	@SubscribeEvent
	private void commonSetup(FMLCommonSetupEvent event) {}
}

