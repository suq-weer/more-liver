package com.xiaosuoaa.moreliver.datagen;

import com.xiaosuoaa.moreliver.MoreLiver;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;
import java.util.Objects;

public class ModOrePlacements {
    public static final ResourceKey<PlacedFeature> ORE_ILMENITE = createKey("ore_ilmenite");
    public static final ResourceKey<PlacedFeature> ORE_WATER_ORE = createKey("ore_water_ore");

    public static void bootstrap(BootstrapContext<PlacedFeature> pContext) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = pContext.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> oreIlmeniteHolder = holdergetter.getOrThrow(ModOreFeatures.ORE_ILMENITE);
        Holder<ConfiguredFeature<?, ?>> oreWaterOreHolder = holdergetter.getOrThrow(ModOreFeatures.ORE_WATER);

        PlacementUtils.register(
                pContext, ORE_ILMENITE, oreIlmeniteHolder, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(45)))
        );
        PlacementUtils.register(
                pContext, ORE_WATER_ORE, oreWaterOreHolder, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(45)))
        );
    }



    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }

    public static ResourceKey<PlacedFeature> createKey(String pKey) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Objects.requireNonNull(ResourceLocation.tryBuild(MoreLiver.MODID, pKey)));
    }
}
