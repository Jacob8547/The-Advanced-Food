package net.jacob375.the_advanced_food.helpers.dataGen.client;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.jacob375.the_advanced_food.custom.blocks.CORN_CROP;
import net.jacob375.the_advanced_food.helpers.ModBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
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
    }

}
