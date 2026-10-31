package net.jacob375.the_advanced_food.helpers.dataGen.client;

import net.jacob375.the_advanced_food.TheAdvancedFood;
import net.jacob375.the_advanced_food.helpers.ModBlocks;
import net.jacob375.the_advanced_food.helpers.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnglishLangProvider extends LanguageProvider {

    public ModEnglishLangProvider(PackOutput output) {
        super(output, TheAdvancedFood.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(ModItems.BACON, "Bacon");
        addItem(ModItems.BURNT_CORN, "Burnt Corn");
        addItem(ModItems.CHEESE, "Cheese");
        addItem(ModItems.CHICKEN_NUGGET, "Chicken Nugget");
        addItem(ModItems.CORN, "Corn");
        addItem(ModItems.EMPTY_POPCORN_BUCKET, "Empty Popcorn Bucket");
        addItem(ModItems.FRENCH_FRIES, "French Fries");
        addItem(ModItems.LETTUCE, "Lettuce");
        addItem(ModItems.PEANUT, "Peanut");
        addItem(ModItems.PIZZA, "Pizza");
        addItem(ModItems.POPPED_CORN, "Popped Corn");
        addItem(ModItems.TACO, "Taco");
        addItem(ModItems.TACO_SHELL, "Taco Shell");
        addItem(ModItems.TOMATO, "Tomato");
        addItem(ModItems.POPCORN, "Popcorn");
        addItem(ModItems.CREAM, "Cream");
        addItem(ModItems.COOKING_OIL, "Cooking Oil");
        addItem(ModItems.HAMMER, "Hammer");
        addItem(ModItems.DONUT, "Donut");
        addItem(ModItems.CIDER, "Cider");
        addItem(ModItems.ALCOHOL, "Alcohol");
        addItem(ModItems.GOLDEN_POTATO, "Golden Potato");
        addItem(ModItems.CORN_SEEDS, "Corn Seeds");
        addItem(ModItems.FLOUR, "Flour");
        addItem(ModItems.PANCAKE, "Pancake");
        addItem(ModItems.ORANGE, "Orange");
        addItem(ModItems.SUSHI, "Sushi");

        addBlock(ModBlocks.PEANUT_BLOCK, "Peanut Block");
        addBlock(ModBlocks.CORN_CROP, "Corn Crop");
        addBlock(ModBlocks.ORANGE_LEAVES, "Orange Leaves");
    }
}