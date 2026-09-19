package net.jacob375.the_advanced_food;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModFeatures {
    ResourceKey<PlacedFeature> PEANUT_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE,
            Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, "peanut_block"));

    ResourceKey<PlacedFeature> ORANGE_TREE = ResourceKey.create(Registries.PLACED_FEATURE,
            Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, "orange_tree"));

    public ModFeatures() {
        // ADD FEATURES TO WORLD
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES,
                PEANUT_BLOCK);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.PLAINS),
                GenerationStep.Decoration.VEGETAL_DECORATION, ORANGE_TREE);
    }
}
