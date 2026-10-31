package net.jacob375.the_advanced_food.helpers.dataGen.server;

import net.jacob375.the_advanced_food.custom.blocks.CORN_CROP;
import net.jacob375.the_advanced_food.helpers.ModBlocks;
import net.jacob375.the_advanced_food.helpers.ModItems;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootSubProvider {
    private final Holder<Enchantment> fortune;
    private final Holder<LootItemCondition> silkTouch;
    private final Holder<LootItemCondition> shears;

    public ModBlockLootTables(LootTableSubProvider.Context output) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), output);
        this.fortune = output.lookup(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
        // Check LootPredicates for the exact constant names (see notes below)
        this.silkTouch = output.lookup(Registries.PREDICATE).getOrThrow(LootPredicates.TOOL_CAN_SILK_TOUCH);
        this.shears = output.lookup(Registries.PREDICATE).getOrThrow(LootPredicates.TOOL_CAN_SHEAR);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value).collect(Collectors.toList());
    }

    @Override
    public void generate() {
        add(ModBlocks.ORANGE_LEAVES.get(), orangeLeavesDrops());
        add(ModBlocks.PEANUT_BLOCK.get(), peanutDrops());
        add(ModBlocks.CORN_CROP.get(), cornDrops());
    }

    private LootTable.Builder orangeLeavesDrops() {
        Block leaves = ModBlocks.ORANGE_LEAVES.get();
        return LootTable.lootTable()
                // Silk touch or shears: the leaf block itself
                .withPool(LootPool.lootPool().setRolls(ContextIntProviders.exactly(1))
                        .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(leaves).when(silkTouch),
                                LootItem.lootTableItem(leaves).when(shears))))
                // Otherwise: sticks (first two alternatives swallow the roll when the tool matches)
                .withPool(LootPool.lootPool().setRolls(ContextIntProviders.exactly(1))
                        .add(AlternativesEntry.alternatives(
                                EmptyLootItem.emptyItem().when(silkTouch),
                                EmptyLootItem.emptyItem().when(shears),
                                applyExplosionDecay(leaves, LootItem.lootTableItem(Items.STICK)
                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2))))
                                        .when(BonusLevelTableCondition.bonusLevelFlatChance(fortune,
                                                0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F)))))
                // Otherwise: oranges
                .withPool(LootPool.lootPool().setRolls(ContextIntProviders.exactly(1))
                        .add(AlternativesEntry.alternatives(
                                EmptyLootItem.emptyItem().when(silkTouch),
                                EmptyLootItem.emptyItem().when(shears),
                                applyExplosionCondition(leaves, LootItem.lootTableItem(ModItems.ORANGE.get()))
                                        .when(BonusLevelTableCondition.bonusLevelFlatChance(fortune, 0.15F, 0.25F)))));
    }

    private LootTable.Builder peanutDrops() {
        return LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ContextIntProviders.exactly(2))
                .add(LootItem.lootTableItem(ModItems.PEANUT.get())
                        .apply(ApplyBonusCount.addUniformBonusCount(fortune))));
    }

    private LootTable.Builder cornDrops() {
        LootItemCondition.Builder mature = MatchBlock.blockMatches(
                this.blocks, ModBlocks.CORN_CROP.get(),
                StatePropertiesPredicate.Builder.properties().hasProperty(CORN_CROP.AGE, 6));

        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ContextIntProviders.exactly(2)).when(mature)
                        .add(LootItem.lootTableItem(ModItems.CORN.get())
                                .apply(ApplyBonusCount.addUniformBonusCount(fortune))))
                .withPool(LootPool.lootPool().setRolls(ContextIntProviders.exactly(1)).when(mature)
                        .when(LootItemRandomChanceCondition.randomChance(0.125F))
                        .add(LootItem.lootTableItem(ModItems.CORN.get())))
                .withPool(LootPool.lootPool().setRolls(ContextIntProviders.exactly(1)).when(mature.invert())
                        .add(LootItem.lootTableItem(ModItems.CORN_SEEDS.get())));
    }
}