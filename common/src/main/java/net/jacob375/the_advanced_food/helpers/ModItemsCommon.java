package net.jacob375.the_advanced_food.helpers;

import net.jacob375.the_advanced_food.TheAdvancedFoodCommon;
import net.jacob375.the_advanced_food.config.ModConfigManager;
import net.jacob375.the_advanced_food.custom.items.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ModItemsCommon {

        // Helper to generate ResourceKeys safely across loaders
        public static ResourceKey<Item> keyOfItem(String name) {
                return ResourceKey.create(Registries.ITEM,
                                Identifier.fromNamespaceAndPath(TheAdvancedFoodCommon.MOD_ID, name));
        }

        public static int nutritionValues(int oldValue, int newValue) {
                if (ModConfigManager.CONFIG.useOldFoodValues) {
                        return oldValue;
                } else {
                        return newValue;
                }
        }

        public static float saturationValues(float oldSaturation, float newSaturation) {
                if (ModConfigManager.CONFIG.useOldFoodValues) {
                        return oldSaturation;
                } else {
                        return newSaturation / 2;
                }
        }

        public static void initialize() {
                // Triggers class loading to register constants
        }

        // ITEMS DEFINITIONS
        public static final Item BACON = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(4, 6))
                                                        .saturationModifier(saturationValues(12f, 0.67f)).build())
                                        .setId(keyOfItem("bacon")));

        public static final Item BURNT_CORN = new BURNT_CORN(
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(1, 1))
                                                        .saturationModifier(saturationValues(0.15f, 1f)).build())
                                        .setId(keyOfItem("burnt_corn")));

        public static final Item CHEESE = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(5, 4))
                                                        .saturationModifier(saturationValues(0.75f, 1f)).build())
                                        .setId(keyOfItem("cheese")));

        public static final Item CHICKEN_NUGGET = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.EPIC).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(14, 9))
                                                        .saturationModifier(saturationValues(13f, 0.75f)).alwaysEdible()
                                                        .build())
                                        .setId(keyOfItem("chicken_nugget")));

        public static final Item CORN = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(4, 3))
                                                        .saturationModifier(saturationValues(1f, 0.67f)).build())
                                        .setId(keyOfItem("corn")));

        public static final Item EMPTY_POPCORN_BUCKET = new Item(
                        new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)
                                        .setId(keyOfItem("empty_popcorn_bucket")));

        public static final Item FRENCH_FRIES = new Item(
                        new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(4, 5))
                                                        .saturationModifier(saturationValues(1f, 0.67f)).build())
                                        .setId(keyOfItem("french_fries")));

        public static final Item LETTUCE = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(4, 4))
                                                        .saturationModifier(saturationValues(0.65f, 0.5f)).build())
                                        .setId(keyOfItem("lettuce")));

        public static final Item PEANUT = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(8, 4))
                                                        .saturationModifier(saturationValues(0.5f, 1f)).build())
                                        .setId(keyOfItem("peanut")));

        public static final Item PIZZA = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.EPIC).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(10, 8))
                                                        .saturationModifier(saturationValues(5f, 0.67f)).build())
                                        .setId(keyOfItem("pizza")));

        public static final Item POPPED_CORN = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(4, 4))
                                                        .saturationModifier(saturationValues(0.3f, 0.3f)).build())
                                        .setId(keyOfItem("popped_corn")));

        public static final Item TACO = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(6, 5))
                                                        .saturationModifier(saturationValues(1.6f, 0.8f)).build())
                                        .setId(keyOfItem("taco")));

        public static final Item TACO_SHELL = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(4, 3))
                                                        .saturationModifier(saturationValues(0.3f, 0.67f)).build())
                                        .setId(keyOfItem("taco_shell")));

        public static final Item TOMATO = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(4, 4))
                                                        .saturationModifier(saturationValues(1f, 0.5f)).build())
                                        .setId(keyOfItem("tomato")));

        public static final Item POPCORN = new POPCORN(
                        new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(10, 6))
                                                        .saturationModifier(saturationValues(5f, 1f)).build())
                                        .setId(keyOfItem("popcorn")));

        public static final Item CREAM = new CREAM(
                        new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(3, 3))
                                                        .saturationModifier(saturationValues(0.5f, 1f)).build())
                                        .setId(keyOfItem("cream")));

        public static final Item COOKING_OIL = new COOKING_OIL(
                        new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(2, 1))
                                                        .saturationModifier(saturationValues(0.3f, 1f)).build())
                                        .setId(keyOfItem("cooking_oil")));

        public static final Item HAMMER = new HAMMER_BASE(
                        new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).durability(10)
                                        .setId(keyOfItem("hammer")));

        public static final Item DONUT = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.RARE).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(12, 7))
                                                        .saturationModifier(saturationValues(10f, 0.75f)).build())
                                        .setId(keyOfItem("donut")));

        public static final Item CIDER = new CIDER(
                        new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(5, 3))
                                                        .saturationModifier(saturationValues(1.3f, 0.8f)).alwaysEdible()
                                                        .build())
                                        .setId(keyOfItem("cider")));

        public static final Item ALCOHOL = new ALCOHOL(
                        new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(1, 1))
                                                        .saturationModifier(saturationValues(0.5f, 1f)).alwaysEdible()
                                                        .build())
                                        .setId(keyOfItem("alcohol")));

        public static final Item GOLDEN_POTATO = new GOLDEN_POTATO(
                        new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(8, 8))
                                                        .saturationModifier(saturationValues(6f, 1f)).alwaysEdible()
                                                        .build())
                                        .setId(keyOfItem("golden_potato")));

        public static final Item CORN_SEEDS = new BlockItem(
                        ModBlocksCommon.CORN_CROP,
                        new Item.Properties().setId(keyOfItem("corn_seeds")));

        public static final Item FLOUR = new FLOUR(
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(1, 2))
                                                        .saturationModifier(saturationValues(0.1f, 1f)).build())
                                        .setId(keyOfItem("flour")));

        public static final Item PANCAKE = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.RARE).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(7, 6))
                                                        .saturationModifier(saturationValues(3f, 0.75f)).build())
                                        .setId(keyOfItem("pancake")));

        public static final Item ORANGE = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(4, 4))
                                                        .saturationModifier(saturationValues(1f, 0.8f)).build())
                                        .setId(keyOfItem("orange")));

        public static final Item SUSHI = new Item(
                        new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON).food(
                                        new FoodProperties.Builder().nutrition(nutritionValues(5, 5))
                                                        .saturationModifier(saturationValues(1.3f, 0.85f)).build())
                                        .setId(keyOfItem("sushi")));

        // Array for quick iterations (creative tabs, loops)
        public static final Item[] ALL_ITEMS = {
                        BACON, BURNT_CORN, CHEESE, CHICKEN_NUGGET, CORN, EMPTY_POPCORN_BUCKET,
                        FRENCH_FRIES, LETTUCE, PEANUT, PIZZA, POPPED_CORN, TACO, TACO_SHELL, TOMATO, POPCORN,
                        CREAM, COOKING_OIL, HAMMER, DONUT, CIDER, ALCOHOL, GOLDEN_POTATO, CORN_SEEDS, FLOUR,
                        PANCAKE, ORANGE, SUSHI
        };
}