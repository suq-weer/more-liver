package com.xiaosuoaa.moreliver.datagen;

import com.xiaosuoaa.moreliver.blocks.NeoForgeBlockRegisterBus;
import com.xiaosuoaa.moreliver.items.NeoForgeItemRegisterBus;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootSubProvider extends BlockLootSubProvider {
    public ModBlockLootSubProvider(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return NeoForgeBlockRegisterBus.BLOCKS.getEntries()
                .stream()
                .map(e -> (Block) e.value())
                .toList();
    }

    @Override
    protected void generate() {
        add(NeoForgeBlockRegisterBus.DEEPSLATE_ILMENITE.get(), createDoubleItemTable(Items.RAW_IRON, NeoForgeItemRegisterBus.TITANIUM.get()));
		add(NeoForgeBlockRegisterBus.ILMENITE.get(), createDoubleItemTable(Items.RAW_IRON, NeoForgeItemRegisterBus.TITANIUM.get()));
		add(NeoForgeBlockRegisterBus.WATER_ORE.get(), createSingleItemTable(NeoForgeItemRegisterBus.RAW_WATER.get()));
		add(NeoForgeBlockRegisterBus.DEEPSLATE_WATER_ORE.get(), createSingleItemTable(NeoForgeItemRegisterBus.RAW_WATER.get()));

		dropSelf(NeoForgeBlockRegisterBus.STRUCTURAL_COMPRESSOR.get());
    }

	//同时掉两种，分为寻常和不寻常
	public LootTable.Builder createDoubleItemTable(ItemLike commonItem, ItemLike specialItem) {
        return LootTable.lootTable()
            	.withPool(
						this.applyExplosionCondition(
								commonItem,
								LootPool.lootPool()
										.setRolls(UniformGenerator.between(1, 2))
										.setBonusRolls(ConstantValue.exactly(1))
										.add(LootItem.lootTableItem(commonItem))
						)
				)
				.withPool(
						this.applyExplosionCondition(
								specialItem,
								LootPool.lootPool()
										.setRolls(UniformGenerator.between(0, 1))
										.setBonusRolls(ConstantValue.exactly(1))
										.add(LootItem.lootTableItem(specialItem))
						)
				);
    }
}