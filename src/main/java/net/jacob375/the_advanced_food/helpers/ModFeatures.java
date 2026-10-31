package net.jacob375.the_advanced_food.helpers;

import net.jacob375.the_advanced_food.TheAdvancedFood;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModFeatures {
        public static final ResourceKey<PlacedFeature> PEANUT_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE,
                        Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, "peanut_block"));

        public static final ResourceKey<PlacedFeature> ORANGE_TREE = ResourceKey.create(Registries.PLACED_FEATURE,
                        Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, "orange_tree"));
}