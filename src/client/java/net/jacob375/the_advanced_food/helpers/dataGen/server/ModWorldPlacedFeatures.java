package net.jacob375.the_advanced_food.helpers.dataGen.server;

import java.util.List;

import net.jacob375.the_advanced_food.TheAdvancedFood;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ModWorldPlacedFeatures {
    public static final ResourceKey<PlacedFeature> PEANUT_BLOCK = ResourceKey.create(
            Registries.PLACED_FEATURE,
            Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, "peanut_block"));

    public static final ResourceKey<PlacedFeature> ORANGE_TREE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, "orange_tree"));

    public static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<Feature> features = context.lookup(Registries.FEATURE);

        context.register(PEANUT_BLOCK, new PlacedFeature(
                features.getOrThrow(ModWorldFeatures.PEANUT_BLOCK),
                List.of(
                        CountPlacement.of(44),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(UniformHeight.of(
                                VerticalAnchor.aboveBottom(-200),
                                VerticalAnchor.aboveBottom(200))),
                        BiomeFilter.biome())));

        context.register(ORANGE_TREE, new PlacedFeature(
                features.getOrThrow(ModWorldFeatures.ORANGE_TREE),
                List.of(
                        CountPlacement.of(1),
                        RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING),
                        BiomeFilter.biome())));
    }
}
