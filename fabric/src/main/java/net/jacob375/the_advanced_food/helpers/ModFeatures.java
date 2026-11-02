package net.jacob375.the_advanced_food.helpers;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModFeatures {
    public static final void init() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                ModFeaturesCommon.PEANUT_BLOCK);

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(Biomes.PLAINS),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ModFeaturesCommon.ORANGE_TREE);
    }
}
