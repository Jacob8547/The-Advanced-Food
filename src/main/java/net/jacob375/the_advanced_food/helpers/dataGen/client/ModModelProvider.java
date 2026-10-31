package net.jacob375.the_advanced_food.helpers.dataGen.client;

import net.jacob375.the_advanced_food.TheAdvancedFood;
import net.jacob375.the_advanced_food.custom.blocks.CORN_CROP;
import net.jacob375.the_advanced_food.helpers.ModBlocks;
import net.jacob375.the_advanced_food.helpers.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, TheAdvancedFood.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blocks, ItemModelGenerators items) {
        blocks.createTrivialCube(ModBlocks.PEANUT_BLOCK.get());
        blocks.createTrivialBlock(ModBlocks.ORANGE_LEAVES.get(), TexturedModel.LEAVES);
        blocks.createCropBlock(ModBlocks.CORN_CROP.get(), CORN_CROP.AGE, 0, 1, 2, 3, 4, 5, 6, 6);

        items.generateFlatItem(ModItems.ALCOHOL.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.BACON.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.BURNT_CORN.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.CHEESE.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.CHICKEN_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.CIDER.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.COOKING_OIL.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.CORN.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.CREAM.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.DONUT.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.EMPTY_POPCORN_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.FLOUR.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.FRENCH_FRIES.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.GOLDEN_POTATO.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        items.generateFlatItem(ModItems.LETTUCE.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.ORANGE.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.PANCAKE.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.PEANUT.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.PIZZA.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.POPCORN.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.POPPED_CORN.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.SUSHI.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.TACO_SHELL.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.TACO.get(), ModelTemplates.FLAT_ITEM);
        items.generateFlatItem(ModItems.TOMATO.get(), ModelTemplates.FLAT_ITEM);
    }
}