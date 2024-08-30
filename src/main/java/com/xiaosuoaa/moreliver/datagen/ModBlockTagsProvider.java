package com.xiaosuoaa.moreliver.datagen;

import com.xiaosuoaa.moreliver.blocks.NeoForgeBlockRegisterBus;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModBlockTagsProvider extends BlockTagsProvider {
	public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, modId, existingFileHelper);
	}

	List<Supplier<? extends Block>> getCanMineableWithPackaxeModBlockList() {
		ArrayList<Supplier<? extends Block>> blockArrayList = new ArrayList<>();
		blockArrayList.add(NeoForgeBlockRegisterBus.ILMENITE);
		blockArrayList.add(NeoForgeBlockRegisterBus.DEEPSLATE_ILMENITE);
		blockArrayList.add(NeoForgeBlockRegisterBus.WATER_ORE);
		blockArrayList.add(NeoForgeBlockRegisterBus.DEEPSLATE_WATER_ORE);

		blockArrayList.add(NeoForgeBlockRegisterBus.IRON_COAL_BLOCK);
		blockArrayList.add(NeoForgeBlockRegisterBus.IRON_COAL_BLOCK_ANODE);
		blockArrayList.add(NeoForgeBlockRegisterBus.IRON_COAL_BLOCK_CATHODE);
		blockArrayList.add(NeoForgeBlockRegisterBus.STRUCTURAL_COMPRESSOR);
		return blockArrayList;
	}

	List<Supplier<? extends Block>> getIncorrectStoneToolModBlockList() {
		ArrayList<Supplier<? extends Block>> blockArrayList = new ArrayList<>();
		blockArrayList.add(NeoForgeBlockRegisterBus.ILMENITE);
		blockArrayList.add(NeoForgeBlockRegisterBus.DEEPSLATE_ILMENITE);
		blockArrayList.add(NeoForgeBlockRegisterBus.WATER_ORE);
		blockArrayList.add(NeoForgeBlockRegisterBus.DEEPSLATE_WATER_ORE);
		return blockArrayList;
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider pProvider) {
		addTagsOf(getCanMineableWithPackaxeModBlockList(), BlockTags.MINEABLE_WITH_PICKAXE);
		addTagsOf(getIncorrectStoneToolModBlockList(), BlockTags.INCORRECT_FOR_STONE_TOOL);
		addTagsOf(getIncorrectStoneToolModBlockList(), BlockTags.INCORRECT_FOR_WOODEN_TOOL);
	}

	private void addTagsOf(List<Supplier<? extends Block>> pBlockList, TagKey<Block> pTag) {
		for (int i = 0; i <= pBlockList.size()-1; i++) {
			this.tag(pTag).add(pBlockList.get(i).get());
		}
	}
}