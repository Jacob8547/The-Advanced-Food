package net.jacob375.the_advanced_food.helpers;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.jacob375.the_advanced_food.TheAdvancedFoodCommon;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ModBlocks {
    public static final void init() {
        Registry.register(BuiltInRegistries.BLOCK, ModBlocksCommon.keyOfBlock("peanut_block"), ModBlocksCommon.PEANUT_BLOCK);
        Registry.register(BuiltInRegistries.ITEM, ModBlocksCommon.keyOfItem("peanut_block"),
                new BlockItem(ModBlocksCommon.PEANUT_BLOCK,
                        new Item.Properties().setId(ModBlocksCommon.keyOfItem("peanut_block")).useBlockDescriptionPrefix()));

        // Creative tab addition using Fabric API:
        CreativeModeTabEvents.modifyOutputEvent(TheAdvancedFoodCommon.CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.accept(ModBlocksCommon.PEANUT_BLOCK);
            itemGroup.accept(ModBlocksCommon.ORANGE_LEAVES);
        });
    }
}
