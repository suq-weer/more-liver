package com.xiaosuoaa.moreliver.blocks;

import com.xiaosuoaa.moreliver.MoreLiver;
import com.xiaosuoaa.moreliver.blocks.crafting.StructuralCompressor;
import com.xiaosuoaa.moreliver.blocks.ingotblock.IronCoalBlock;
import com.xiaosuoaa.moreliver.blocks.ingotblock.IronCoalBlockAnode;
import com.xiaosuoaa.moreliver.blocks.ingotblock.IronCoalBlockCathode;
import com.xiaosuoaa.moreliver.blocks.ores.IlmeniteBlock;
import com.xiaosuoaa.moreliver.blocks.ores.WaterOre;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NeoForgeBlockRegisterBus {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.Blocks.createBlocks(MoreLiver.MODID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreLiver.MODID);
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MoreLiver.MODID);

	public static final Supplier<Block> ILMENITE = BLOCKS.register("ilmenite", IlmeniteBlock::new);
	public static final Supplier<Item> ILMENITE_ITEM = ITEMS.register("ilmenite",()->new BlockItem(ILMENITE.get(), new Item.Properties()));
	public static final Supplier<Block> DEEPSLATE_ILMENITE = BLOCKS.register("deepslate_ilmenite", IlmeniteBlock::new);
	public static final Supplier<Item> DEEPSLATE_ILMENITE_ITEM = ITEMS.register("deepslate_ilmenite",()->new BlockItem(DEEPSLATE_ILMENITE.get(), new Item.Properties()));

	public static final Supplier<Block> WATER_ORE = BLOCKS.register("water_ore", WaterOre::new);
	public static final Supplier<Item> WATER_ORE_ITEM = ITEMS.register("water_ore",()->new BlockItem(WATER_ORE.get(), new Item.Properties()));
	public static final Supplier<Block> DEEPSLATE_WATER_ORE = BLOCKS.register("deepslate_water_ore", WaterOre::new);
	public static final Supplier<Item> DEEPSLATE_WATER_ORE_ITEM = ITEMS.register("deepslate_water_ore",()->new BlockItem(DEEPSLATE_WATER_ORE.get(), new Item.Properties()));

	public static final Supplier<Block> IRON_COAL_BLOCK = BLOCKS.register("iron_coal_block", IronCoalBlock::new);
	public static final Supplier<Item> IRON_COAL_BLOCK_ITEM = ITEMS.register("iron_coal_block",()->new BlockItem(IRON_COAL_BLOCK.get(), new Item.Properties()));
	public static final Supplier<Block> IRON_COAL_BLOCK_ANODE = BLOCKS.register("iron_coal_block_anode", IronCoalBlockAnode::new);
	public static final Supplier<Item> IRON_COAL_BLOCK_ANODE_ITEM = ITEMS.register("iron_coal_block_anode",()->new BlockItem(IRON_COAL_BLOCK_ANODE.get(), new Item.Properties()));
	public static final Supplier<Block> IRON_COAL_BLOCK_CATHODE = BLOCKS.register("iron_coal_block_cathode", IronCoalBlockCathode::new);
	public static final Supplier<Item> IRON_COAL_BLOCK_CATHODE_ITEM = ITEMS.register("iron_coal_block_cathode",()->new BlockItem(IRON_COAL_BLOCK_CATHODE.get(), new Item.Properties()));

	public static final Supplier<StructuralCompressor> STRUCTURAL_COMPRESSOR = BLOCKS.register(
			"structural_compressor",
			()->new StructuralCompressor(
					BlockBehaviour.Properties.of()
							.mapColor(MapColor.WOOD)
							.instrument(NoteBlockInstrument.BASS)
							.strength(3F)
							.sound(SoundType.STONE)
							.ignitedByLava()
			)
	);
	public static final Supplier<Item> STRUCTURAL_COMPRESSOR_ITEM = ITEMS.register("structural_compressor", ()->new BlockItem(STRUCTURAL_COMPRESSOR.get(), new Item.Properties()));

	public static void register(IEventBus eventBus){
		BLOCKS.register(eventBus);
		ITEMS.register(eventBus);
		TILES.register(eventBus);
	}

	//注册到原版创造物品栏
	public static void registerBlocksToIGNature(BuildCreativeModeTabContentsEvent event) {
		event.accept(ILMENITE_ITEM.get());
		event.accept(DEEPSLATE_ILMENITE_ITEM.get());
		event.accept(WATER_ORE_ITEM.get());
		event.accept(DEEPSLATE_WATER_ORE_ITEM.get());
		MoreLiver.info("方块已添加到原版自然方块选项卡");
	}
	public static void registerBlocksToIGFunctionalBlocks(BuildCreativeModeTabContentsEvent event) {
		event.accept(STRUCTURAL_COMPRESSOR_ITEM.get());
		MoreLiver.info("方块已添加到原版功能方块选项卡");
	}
}
