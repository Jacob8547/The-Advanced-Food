package net.jacob375.the_advanced_food.helpers.dataGen.client;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup.Provider;

public class ModEnglighLangProvider extends FabricLanguageProvider {

    public ModEnglighLangProvider(FabricPackOutput packOutput, CompletableFuture<Provider> registryLookup) {
        super(packOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.the-advanced-food.bacon", "Bacon");
        translationBuilder.add("item.the-advanced-food.burnt_corn", "Burnt Corn");
        translationBuilder.add("item.the-advanced-food.cheese", "Cheese");
        translationBuilder.add("item.the-advanced-food.chicken_nugget", "Chicken Nugget");
        translationBuilder.add("item.the-advanced-food.corn", "Corn");
        translationBuilder.add("item.the-advanced-food.empty_popcorn_bucket", "Empty Popcorn Bucket");
        translationBuilder.add("item.the-advanced-food.french_fries", "French Fries");
        translationBuilder.add("item.the-advanced-food.lettuce", "Lettuce");
        translationBuilder.add("item.the-advanced-food.pizza", "Pizza");
        translationBuilder.add("item.the-advanced-food.popped_corn", "Popped Corn");
        translationBuilder.add("item.the-advanced-food.taco", "Taco");
        translationBuilder.add("item.the-advanced-food.taco_shell", "Taco Shell");
        translationBuilder.add("item.the-advanced-food.tomato", "Tomato");
        translationBuilder.add("item.the-advanced-food.popcorn", "Popcorn");
        translationBuilder.add("item.the-advanced-food.cream", "Cream");
        translationBuilder.add("item.the-advanced-food.cooking_oil", "Cooking Oil");
        translationBuilder.add("item.the-advanced-food.hammer", "Hammer");
        translationBuilder.add("item.the-advanced-food.donut", "Donut");
        translationBuilder.add("item.the-advanced-food.cider", "Cider");
        translationBuilder.add("item.the-advanced-food.alcohol", "Alcohol");
        translationBuilder.add("item.the-advanced-food.golden_potato", "Golden Potato");
        translationBuilder.add("item.the-advanced-food.corn_seeds", "Corn Seeds");
        translationBuilder.add("item.the-advanced-food.flour", "Flour");
        translationBuilder.add("item.the-advanced-food.pancake", "Pancake");
        translationBuilder.add("item.the-advanced-food.orange", "Orange");
        translationBuilder.add("item.the-advanced-food.sushi", "Sushi");

        translationBuilder.add("block.the-advanced-food.peanut_block", "Peanut Block");
        translationBuilder.add("block.the-advanced-food.corn_crop", "Corn Crop");
        translationBuilder.add("block.the-advanced-food.orange_leaves", "Orange Leaves");

        translationBuilder.add("itemGroup.the-advanced-food.the_advanced_food_tab", "The Advanced Food Tab");
    }

}
