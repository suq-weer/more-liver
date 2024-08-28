package com.xiaosuoaa.moreliver.datagen;

import com.xiaosuoaa.moreliver.MoreLiver;
import com.xiaosuoaa.moreliver.blocks.NeoForgeBlockRegisterBus;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.Objects;

public class ModOreFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ILMENITE = createKey("ilmenite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_WATER = createKey("water_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pContext) {
        RuleTest stoneOreReplaceRuleTest = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepSlateOreReplaceRuleTest = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


        List<OreConfiguration.TargetBlockState> ilmeniteList = List.of(
                OreConfiguration.target(stoneOreReplaceRuleTest, NeoForgeBlockRegisterBus.ILMENITE.get().defaultBlockState()),
                OreConfiguration.target(deepSlateOreReplaceRuleTest, NeoForgeBlockRegisterBus.DEEPSLATE_ILMENITE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> waterOreList = List.of(
                OreConfiguration.target(stoneOreReplaceRuleTest, NeoForgeBlockRegisterBus.WATER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepSlateOreReplaceRuleTest, NeoForgeBlockRegisterBus.DEEPSLATE_WATER_ORE.get().defaultBlockState())
        );

        FeatureUtils.register(pContext, ORE_ILMENITE, Feature.ORE, new OreConfiguration(ilmeniteList, 5));
        FeatureUtils.register(pContext, ORE_WATER, Feature.ORE, new OreConfiguration(waterOreList, 10));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Objects.requireNonNull(ResourceLocation.tryBuild(MoreLiver.MODID, pName)));
    }
}
