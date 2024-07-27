package com.xiaosuoaa.moreliver.blocks;

import com.xiaosuoaa.moreliver.MoreLiver;
import com.xiaosuoaa.moreliver.blocks.ores.IlmeniteBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegisterBus {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.Blocks.createBlocks(MoreLiver.MODID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreLiver.MODID);

	public static final Supplier<Block> ILMENITE = BLOCKS.register("ilmenite", IlmeniteBlock::new);
	public static final Supplier<Item> ILMENITE_ITEM = ITEMS.register("ilmenite",()->new BlockItem(ILMENITE.get(), new Item.Properties()));
	public static final Supplier<Block> DEEPSLATE_ILMENITE = BLOCKS.register("deepslate_ilmenite", IlmeniteBlock::new);
	public static final Supplier<Item> DEEPSLATE_ILMENITE_ITEM = ITEMS.register("deepslate_ilmenite",()->new BlockItem(DEEPSLATE_ILMENITE.get(), new Item.Properties()));

	public static void register(IEventBus eventBus){
		BLOCKS.register(eventBus);
		ITEMS.register(eventBus);
	}

	public static void registerBlocksToIG(BuildCreativeModeTabContentsEvent event) {
		event.accept(ILMENITE_ITEM.get());
		event.accept(DEEPSLATE_ILMENITE_ITEM.get());
	}
}
