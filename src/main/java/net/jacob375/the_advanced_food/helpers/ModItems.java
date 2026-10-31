package net.jacob375.the_advanced_food.helpers;

import net.jacob375.the_advanced_food.TheAdvancedFood;
import net.jacob375.the_advanced_food.config.ModConfigManager;
import net.jacob375.the_advanced_food.custom.items.*;
import net.jacob375.the_advanced_food.helpers.extra.ModCreativeTabs;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheAdvancedFood.MOD_ID);

    public static int nutritionValues(int oldValue, int newValue) {
        return ModConfigManager.CONFIG.useOldFoodValues ? oldValue : newValue;
    }

    public static float saturationValues(float oldSaturation, float newSaturation) {
        return ModConfigManager.CONFIG.useOldFoodValues ? oldSaturation : newSaturation / 2;
    }

    // ITEMS
    public static final DeferredItem<Item> BACON = ITEMS.registerItem("bacon", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(4, 6))
                            .saturationModifier(saturationValues(12f, 0.67f)).build()));

    public static final DeferredItem<Item> BURNT_CORN = ITEMS.registerItem("burnt_corn", BURNT_CORN::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(1, 1))
                            .saturationModifier(saturationValues(0.15f, 1f)).build()));

    public static final DeferredItem<Item> CHEESE = ITEMS.registerItem("cheese", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(5, 4))
                            .saturationModifier(saturationValues(0.75f, 1f)).build()));

    public static final DeferredItem<Item> CHICKEN_NUGGET = ITEMS.registerItem("chicken_nugget", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.EPIC).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(14, 9))
                            .saturationModifier(saturationValues(13f, 0.75f)).alwaysEdible().build()));

    public static final DeferredItem<Item> CORN = ITEMS.registerItem("corn", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(4, 3))
                            .saturationModifier(saturationValues(1f, 0.67f)).build()));

    public static final DeferredItem<Item> EMPTY_POPCORN_BUCKET = ITEMS.registerItem("empty_popcorn_bucket", Item::new,
            () -> new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));

    public static final DeferredItem<Item> FRENCH_FRIES = ITEMS.registerItem("french_fries", Item::new,
            () -> new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(4, 5))
                            .saturationModifier(saturationValues(1f, 0.67f)).build()));

    public static final DeferredItem<Item> LETTUCE = ITEMS.registerItem("lettuce", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(4, 4))
                            .saturationModifier(saturationValues(0.65f, 0.5f)).build()));

    public static final DeferredItem<Item> PEANUT = ITEMS.registerItem("peanut", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(8, 4))
                            .saturationModifier(saturationValues(0.5f, 1f)).build()));

    public static final DeferredItem<Item> PIZZA = ITEMS.registerItem("pizza", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.EPIC).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(10, 8))
                            .saturationModifier(saturationValues(5f, 0.67f)).build()));

    public static final DeferredItem<Item> POPPED_CORN = ITEMS.registerItem("popped_corn", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(4, 4))
                            .saturationModifier(saturationValues(0.3f, 0.3f)).build()));

    public static final DeferredItem<Item> TACO = ITEMS.registerItem("taco", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(6, 5))
                            .saturationModifier(saturationValues(1.6f, 0.8f)).build()));

    public static final DeferredItem<Item> TACO_SHELL = ITEMS.registerItem("taco_shell", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(4, 3))
                            .saturationModifier(saturationValues(0.3f, 0.67f)).build()));

    public static final DeferredItem<Item> TOMATO = ITEMS.registerItem("tomato", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(4, 4))
                            .saturationModifier(saturationValues(1f, 0.5f)).build()));

    public static final DeferredItem<Item> POPCORN = ITEMS.registerItem("popcorn", POPCORN::new,
            () -> new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(10, 6))
                            .saturationModifier(saturationValues(5f, 1f)).build()));

    public static final DeferredItem<Item> CREAM = ITEMS.registerItem("cream", CREAM::new,
            () -> new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(3, 3))
                            .saturationModifier(saturationValues(0.5f, 1f)).build()));

    public static final DeferredItem<Item> COOKING_OIL = ITEMS.registerItem("cooking_oil", COOKING_OIL::new,
            () -> new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(2, 1))
                            .saturationModifier(saturationValues(0.3f, 1f)).build()));

    public static final DeferredItem<Item> HAMMER = ITEMS.registerItem("hammer", HAMMER::new,
            () -> new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).durability(10));

    public static final DeferredItem<Item> DONUT = ITEMS.registerItem("donut", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.RARE).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(12, 7))
                            .saturationModifier(saturationValues(10f, 0.75f)).build()));

    public static final DeferredItem<Item> CIDER = ITEMS.registerItem("cider", CIDER::new,
            () -> new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(5, 3))
                            .saturationModifier(saturationValues(1.3f, 0.8f)).alwaysEdible().build()));

    public static final DeferredItem<Item> ALCOHOL = ITEMS.registerItem("alcohol", ALCOHOL::new,
            () -> new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(1, 1))
                            .saturationModifier(saturationValues(0.5f, 1f)).alwaysEdible().build()));

    public static final DeferredItem<Item> GOLDEN_POTATO = ITEMS.registerItem("golden_potato", GOLDEN_POTATO::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.EPIC).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(8, 8))
                            .saturationModifier(saturationValues(6f, 1f)).alwaysEdible().build()));

    // ModBlocks.CORN_CROP must be a DeferredBlock now, so .get() is called lazily
    // inside the factory
    public static final DeferredItem<Item> CORN_SEEDS = ITEMS.registerItem("corn_seeds",
            props -> new BlockItem(ModBlocks.CORN_CROP.get(), props), () -> new Item.Properties());

    public static final DeferredItem<Item> FLOUR = ITEMS.registerItem("flour", FLOUR::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(1, 2))
                            .saturationModifier(saturationValues(0.1f, 1f)).build()));

    public static final DeferredItem<Item> PANCAKE = ITEMS.registerItem("pancake", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.RARE).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(7, 6))
                            .saturationModifier(saturationValues(3f, 0.75f)).build()));

    public static final DeferredItem<Item> ORANGE = ITEMS.registerItem("orange", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(4, 4))
                            .saturationModifier(saturationValues(1f, 0.8f)).build()));

    public static final DeferredItem<Item> SUSHI = ITEMS.registerItem("sushi", Item::new,
            () -> new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON).food(
                    new FoodProperties.Builder().nutrition(nutritionValues(5, 5))
                            .saturationModifier(saturationValues(1.3f, 0.85f)).build()));

    // REGISTRATION
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        modEventBus.addListener(ModItems::addToCreativeTab);
    }

    // CREATIVE MODE TAB
    private static void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(ModCreativeTabs.CUSTOM_ITEM_GROUP_KEY)) {
            ITEMS.getEntries().forEach(entry -> event.accept(entry.get()));
        }
    }
}