package net.jacob375.the_advanced_food.custom.blocks;

import net.jacob375.the_advanced_food.helpers.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CORN_CROP extends CropBlock {
    public CORN_CROP(BlockBehaviour.Properties properties) {
            super(properties);
        }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CORN_SEEDS;
    }

    @Override
    public int getMaxAge() {
        return 6;
    }
}
