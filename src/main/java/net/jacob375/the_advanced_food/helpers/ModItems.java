package net.jacob375.the_advanced_food.helpers;

import java.util.function.Function;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.jacob375.the_advanced_food.TheAdvancedFood;
import net.jacob375.the_advanced_food.config.ModConfigManager;
import net.jacob375.the_advanced_food.custom.items.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

public class ModItems implements ModInitializer {

        public static Item register(String name, Function<Item.Properties, Item> itemFactory,
                        Item.Properties settings) {
                // Create the item key.
                ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM,
                                Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, name));

                // Create the item instance.    
                Item item = itemFactory.apply(settings.setId(itemKey));

                // Register the item.
                Registry.register(BuiltInRegistries.ITEM, itemKey, item);

                return item;
        }

        public static void modifyLootTable(Object lootTableToModify, Item itemToAdd, float chanceToDrop) {
                LootTableEvents.MODIFY.register((ResourceKey<LootTable> id, LootTable.Builder builder,
                                LootTableSource source, HolderLookup.Provider context) -> {
                        if (id.equals(lootTableToModify)) {
                                LootPool.Builder pool = LootPool.lootPool().setRolls(ContextIntProviders.exactly(1))
                                                .add(LootItem.lootTableItem(itemToAdd))
                                                .when(LootItemRandomChanceCondition.randomChance(chanceToDrop));

                                builder.withPool(pool);
                        }
                });
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
        }

        @Override
        public void onInitialize() {
                ModItems.initialize();
        }

        // ITEMS
        public static final Item BACON = ModItems.register("bacon", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(4, 6))
                                                        .saturationModifier(saturationValues(12f, 0.67f))).build()));

        public static final Item BURNT_CORN = ModItems.register("burnt_corn", BURNT_CORN::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(1, 1))
                                                        .saturationModifier(saturationValues(0.15f, 1f))).build()));

        public static final Item CHEESE = ModItems.register("cheese", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(5, 4))
                                                        .saturationModifier(saturationValues(0.75f, 1f))).build()));

        public static final Item CHICKEN_NUGGET = ModItems.register("chicken_nugget", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.EPIC)
                                        .food((new FoodProperties.Builder().nutrition(nutritionValues(14, 9))
                                                        .saturationModifier(saturationValues(13f, 0.75f)))
                                                        .alwaysEdible().build()));

        public static final Item CORN = ModItems.register("corn", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(4, 3))
                                                        .saturationModifier(saturationValues(1f, 0.67f))).build()));

        public static final Item EMPTY_POPCORN_BUCKET = ModItems.register("empty_popcorn_bucket", Item::new,
                        new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));

        public static final Item FRENCH_FRIES = ModItems.register("french_fries", Item::new,
                        new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(4, 5))
                                                        .saturationModifier(saturationValues(1f, 0.67f))).build()));

        public static final Item LETTUCE = ModItems.register("lettuce", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(4, 4))
                                                        .saturationModifier(saturationValues(0.65f, 0.5f))).build()));

        public static final Item PEANUT = ModItems.register("peanut", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(8, 4))
                                                        .saturationModifier(saturationValues(0.5f, 1f))).build()));

        public static final Item PIZZA = ModItems.register("pizza", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.EPIC).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(10, 8))
                                                        .saturationModifier(saturationValues(5f, 0.67f))).build()));

        public static final Item POPPED_CORN = ModItems.register("popped_corn", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(4, 4))
                                                        .saturationModifier(saturationValues(0.3f, 0.3f))).build()));

        public static final Item TACO = ModItems.register("taco", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(6, 5))
                                                        .saturationModifier(saturationValues(1.6f, 0.8f))).build()));

        public static final Item TACO_SHELL = ModItems.register("taco_shell", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(4, 3))
                                                        .saturationModifier(saturationValues(0.3f, 0.67f))).build()));

        public static final Item TOMATO = ModItems.register("tomato", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(4, 4))
                                                        .saturationModifier(saturationValues(1f, 0.5f))).build()));

        public static final Item POPCORN = ModItems.register("popcorn", POPCORN::new,
                        new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(10, 6))
                                                        .saturationModifier(saturationValues(5f, 1f))).build()));

        public static final Item CREAM = ModItems.register("cream", CREAM::new,
                        new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(3, 3))
                                                        .saturationModifier(saturationValues(0.5f, 1f))).build()));

        public static final Item COOKING_OIL = ModItems.register("cooking_oil", COOKING_OIL::new,
                        new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(2, 1))
                                                        .saturationModifier(saturationValues(0.3f, 1f))).build()));

        public static final Item HAMMER = ModItems.register("hammer", HAMMER::new,
                        new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).durability(10));

        public static final Item DONUT = ModItems.register("donut", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.RARE).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(12, 7))
                                                        .saturationModifier(saturationValues(10f, 0.75f))).build()));

        public static final Item CIDER = ModItems.register("cider", CIDER::new,
                        new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)
                                        .food((new FoodProperties.Builder().nutrition(nutritionValues(5, 3))
                                                        .saturationModifier(saturationValues(1.3f, 0.8f)))
                                                        .alwaysEdible().build()));

        public static final Item ALCOHOL = ModItems.register("alcohol", ALCOHOL::new,
                        new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)
                                        .food((new FoodProperties.Builder().nutrition(nutritionValues(1, 1))
                                                        .saturationModifier(saturationValues(0.5f, 1f)))
                                                        .alwaysEdible().build()));

        public static final Item GOLDEN_POTATO = ModItems.register("golden_potato", GOLDEN_POTATO::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.EPIC)
                                        .food((new FoodProperties.Builder().nutrition(nutritionValues(8, 8))
                                                        .saturationModifier(saturationValues(6f, 1f)))
                                                        .alwaysEdible().build()));

        public static final Item CORN_SEEDS = ModItems.register("corn_seeds",
                        settings -> new BlockItem(ModBlocks.CORN_CROP, settings), new Item.Properties());

        public static final Item FLOUR = ModItems.register("flour", FLOUR::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(1, 2))
                                                        .saturationModifier(saturationValues(0.1f, 1f))).build()));

        public static final Item PANCAKE = ModItems.register("pancake", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.RARE).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(7, 6))
                                                        .saturationModifier(saturationValues(3f, 0.75f))).build()));

        public static final Item ORANGE = ModItems.register("orange", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(4, 4))
                                                        .saturationModifier(saturationValues(1f, 0.8f))).build()));

        public static final Item SUSHI = ModItems.register("sushi", Item::new,
                        new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON).food(
                                        (new FoodProperties.Builder().nutrition(nutritionValues(5, 5))
                                                        .saturationModifier(saturationValues(1.3f, 0.85f))).build()));

        // CREATIVE MODE TAB
        public ModItems() {
                final Item[] items = { BACON, BURNT_CORN, CHEESE, CHICKEN_NUGGET, CORN, EMPTY_POPCORN_BUCKET,
                                FRENCH_FRIES, LETTUCE, PEANUT, PIZZA, POPPED_CORN, TACO, TACO_SHELL, TOMATO, POPCORN,
                                CREAM, COOKING_OIL, HAMMER, DONUT, CIDER, ALCOHOL, GOLDEN_POTATO, CORN_SEEDS, FLOUR,
                                PANCAKE, ORANGE, SUSHI };

                CreativeModeTabEvents.modifyOutputEvent(TheAdvancedFood.CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
                        for (var item : items) {
                                itemGroup.accept(item);
                        }
                });

                // MODIFY MINECRAFT LOOT TABLES
                modifyLootTable(Blocks.TALL_GRASS.getLootTable().get(), TOMATO, 0.0625f);
                modifyLootTable(Blocks.SHORT_GRASS.getLootTable().get(), CORN_SEEDS, 0.125f);
        }
}
