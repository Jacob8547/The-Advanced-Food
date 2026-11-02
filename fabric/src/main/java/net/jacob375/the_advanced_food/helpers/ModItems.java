package net.jacob375.the_advanced_food.helpers;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.jacob375.the_advanced_food.TheAdvancedFoodCommon;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

public class ModItems {
    public static final void init() {
        for (Item item : ModItemsCommon.ALL_ITEMS) {
            ResourceKey<Item> key = ModItemsCommon.keyOfItem(BuiltInRegistries.ITEM.getKey(item).getPath());
        }

        // Creative tab insertion
        CreativeModeTabEvents.modifyOutputEvent(TheAdvancedFoodCommon.CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            for (var item : ModItemsCommon.ALL_ITEMS) {
                itemGroup.accept(item);
            }
        });

        // Loot table modifications using Fabric API v3
        LootTableEvents.MODIFY.register((id, builder, source, context) -> {
            if (id.equals(Blocks.TALL_GRASS.getLootTable().get())) {
                LootPool.Builder pool = LootPool.lootPool().setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItemsCommon.TOMATO))
                        .when(LootItemRandomChanceCondition.randomChance(0.0625f));
                builder.withPool(pool);
            }
            if (id.equals(Blocks.SHORT_GRASS.getLootTable().get())) {
                LootPool.Builder pool = LootPool.lootPool().setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModItemsCommon.CORN_SEEDS))
                        .when(LootItemRandomChanceCondition.randomChance(0.125f));
                builder.withPool(pool);
            }
        });
    }
}
