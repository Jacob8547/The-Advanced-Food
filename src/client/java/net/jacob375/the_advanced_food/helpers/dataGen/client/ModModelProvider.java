package net.jacob375.the_advanced_food.helpers.dataGen.client;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.jacob375.the_advanced_food.custom.blocks.CORN_CROP;
import net.jacob375.the_advanced_food.helpers.ModBlocks;
import net.jacob375.the_advanced_food.helpers.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.PEANUT_BLOCK);
        blockModelGenerators.createTrivialBlock(ModBlocks.ORANGE_LEAVES, TexturedModel.LEAVES);
        blockModelGenerators.createCropBlock(ModBlocks.CORN_CROP, CORN_CROP.AGE, 0, 1, 2, 3, 4, 5, 6, 6);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.ALCOHOL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BACON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BURNT_CORN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHEESE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHICKEN_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CIDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COOKING_OIL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CORN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CREAM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DONUT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.EMPTY_POPCORN_BUCKET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FLOUR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FRENCH_FRIES, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GOLDEN_POTATO, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LETTUCE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ORANGE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PANCAKE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PEANUT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PIZZA, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.POPCORN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.POPPED_CORN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SUSHI, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TACO_SHELL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TACO, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TOMATO, ModelTemplates.FLAT_ITEM);
    }

}
