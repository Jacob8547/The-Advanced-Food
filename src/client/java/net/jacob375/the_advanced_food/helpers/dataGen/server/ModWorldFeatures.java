package net.jacob375.the_advanced_food.helpers.dataGen.server;

import java.util.List;
import java.util.Optional;

import net.jacob375.the_advanced_food.TheAdvancedFood;
import net.jacob375.the_advanced_food.helpers.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.BlockReplacement;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ModWorldFeatures {
    public static final ResourceKey<Feature> PEANUT_BLOCK = ResourceKey.create(
            Registries.FEATURE,
            Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, "peanut_block"));

    public static final ResourceKey<Feature> ORANGE_TREE = ResourceKey.create(
            Registries.FEATURE,
            Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, "orange_tree"));

    public static void configure(BootstrapContext<Feature> context) {
        context.register(PEANUT_BLOCK, new OreFeature(
                List.of(BlockReplacement.replace(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                        ModBlocks.PEANUT_BLOCK.defaultBlockState())),
                6));

        context.register(ORANGE_TREE, new TreeFeature(
                Holder.direct(BlockStateProvider.of(Blocks.OAK_LOG)),
                new StraightTrunkPlacer(4, 2, 0),
                Holder.direct(BlockStateProvider.of(ModBlocks.ORANGE_LEAVES)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                Optional.empty(),
                new TwoLayersFeatureSize(1, 0, 1),
                List.of(),
                true,
                Holder.direct(BlockStateProvider.of(Blocks.DIRT))));
    }
}
