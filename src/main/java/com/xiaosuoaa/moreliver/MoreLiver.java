package com.xiaosuoaa.moreliver;

import com.mojang.logging.LogUtils;
import com.xiaosuoaa.moreliver.blocks.NeoForgeBlockRegisterBus;
import com.xiaosuoaa.moreliver.creativetabs.ModCreativeTabs;
import com.xiaosuoaa.moreliver.datagen.recipes.RecipeSerializerRegisterBus;
import com.xiaosuoaa.moreliver.datagen.recipes.RecipeTypeRegisterBus;
import com.xiaosuoaa.moreliver.events.OnGatherDataEvent;
import com.xiaosuoaa.moreliver.events.OnPlayerTickEvent;
import com.xiaosuoaa.moreliver.items.NeoForgeItemRegisterBus;
import com.xiaosuoaa.moreliver.ui.NeoForgeMenuRegisterBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.slf4j.Logger;

@Mod(MoreLiver.MODID)
public class MoreLiver
{
	public static final String MODID = "moreliver";
	private static final Logger LOGGER = LogUtils.getLogger();

	public MoreLiver(IEventBus modEventBus)
	{
		LOGGER.info("——————————————————————");
		LOGGER.info(" 更多肝度 | More Liver");
		LOGGER.info("——————————————————————");
		LOGGER.warn("您正在使用内部测试版本，可能会出现重大错误！在游玩中发生问题请积极反馈作者。");
		LOGGER.warn("You're using an internal beta version and there may be major bugs! If there is a problem during the game, please give positive feedback to the author.");

		LOGGER.info("正在加载自定义物品……");
		NeoForgeItemRegisterBus.register(modEventBus);
		LOGGER.info("正在加载自定义创造选项卡……");
		ModCreativeTabs.register(modEventBus);
		LOGGER.info("正在加载自定义方块……");
		NeoForgeBlockRegisterBus.register(modEventBus);
		modEventBus.register(this);
		modEventBus.addListener(this::gatherData);
		LOGGER.info("正在加载自定义UI……");
		NeoForgeMenuRegisterBus.register(modEventBus);
		LOGGER.info("正在加载自定义配方与合成机制……");
		RecipeTypeRegisterBus.register(modEventBus);
		RecipeSerializerRegisterBus.register(modEventBus);

		NeoForge.EVENT_BUS.addListener(this::onPlayerTick);
	}

	public static void info(String text) {
		LOGGER.info(text);
	}

	@SubscribeEvent
	private void fmlCommonSetup(FMLCommonSetupEvent event) {}

	private void onPlayerTick(PlayerTickEvent.Post event) {
		OnPlayerTickEvent.hook(event);
	}
	private void gatherData(GatherDataEvent event){
		OnGatherDataEvent.hook(event);
    }
}

