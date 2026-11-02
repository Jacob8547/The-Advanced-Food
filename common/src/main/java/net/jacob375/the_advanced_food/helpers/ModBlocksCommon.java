package net.jacob375.the_advanced_food.helpers;

import java.util.function.Function;

import net.jacob375.the_advanced_food.TheAdvancedFoodCommon;
import net.jacob375.the_advanced_food.custom.blocks.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocksCommon {

        // Helper to generate ResourceKeys safely across loaders
        public static ResourceKey<Block> keyOfBlock(String name) {
                return ResourceKey.create(Registries.BLOCK,
                                Identifier.fromNamespaceAndPath(TheAdvancedFoodCommon.MOD_ID, name));
        }

        public static ResourceKey<Item> keyOfItem(String name) {
                return ResourceKey.create(Registries.ITEM,
                                Identifier.fromNamespaceAndPath(TheAdvancedFoodCommon.MOD_ID, name));
        }

        // BLOCKS DEFINITIONS
        // (Note: If using Architectury API DeferredRegisters, wrap or pass suppliers
        // here)
        public static final Block PEANUT_BLOCK = new Block(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).setId(keyOfBlock("peanut_block")));

        public static final Block CORN_CROP = new CORN_CROP(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollision().randomTicks().instabreak()
                                        .sound(SoundType.CROP).noOcclusion().setId(keyOfBlock("corn_crop")));

        public static final Block ORANGE_LEAVES = new ORANGE_LEAVES(
                        AmbientLeavesBlockSoundPlayer.noAmbientSound(),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noOcclusion()
                                        .setId(keyOfBlock("orange_leaves")));

        public static void initialize() {
                // Triggered by platform initializers to load class constants into memory
        }
}