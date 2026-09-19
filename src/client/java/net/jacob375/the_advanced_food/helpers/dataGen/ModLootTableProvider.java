package net.jacob375.the_advanced_food.helpers.dataGen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.jacob375.the_advanced_food.custom.blocks.CORN_CROP;
import net.jacob375.the_advanced_food.helpers.ModBlocks;
import net.jacob375.the_advanced_food.helpers.ModItems;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchBlock;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

public class ModLootTableProvider extends FabricBlockLootSubProvider {
    private final Holder<Enchantment> fortune;

    protected ModLootTableProvider(FabricPackOutput packOutput, CompletableFuture<Provider> registriesFuture) {
        super(packOutput, registriesFuture);
        fortune = registriesFuture.join().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
    }

    @Override
    public void generate() {
        add(ModBlocks.ORANGE_LEAVES, orangeLeavesDrops());
        add(ModBlocks.PEANUT_BLOCK, peanutDrops());
        add(ModBlocks.CORN_CROP, cornDrops());
    }

    private LootTable.Builder orangeLeavesDrops() {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(ModBlocks.ORANGE_LEAVES).when(hasShearsOrSilkTouch())))

                .withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .when(doesNotHaveShearsOrSilkTouch())
                        .add(applyExplosionDecay(ModBlocks.ORANGE_LEAVES, LootItem.lootTableItem(Items.STICK)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2))))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(fortune,
                                        0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))))

                .withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .when(doesNotHaveShearsOrSilkTouch())
                        .add(applyExplosionCondition(ModBlocks.ORANGE_LEAVES, LootItem.lootTableItem(ModItems.ORANGE))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(fortune, 0.15F, 0.25F))));
    }

    private LootTable.Builder peanutDrops() {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(2))
                        .add(LootItem.lootTableItem(ModItems.PEANUT)
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(fortune, 0.5714286F, 3))));
    }

    private LootTable.Builder cornDrops() {
        LootItemCondition.Builder mature = MatchBlock.blockMatches(
                this.blocks,
                ModBlocks.CORN_CROP,
                StatePropertiesPredicate.Builder.properties().hasProperty(CORN_CROP.AGE, 6));

        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(2))
                        .when(mature)
                        .add(LootItem.lootTableItem(ModItems.CORN)
                                .apply(ApplyBonusCount.addUniformBonusCount(fortune))))

                .withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .when(mature)
                        .when(LootItemRandomChanceCondition.randomChance(0.125F))
                        .add(LootItem.lootTableItem(ModItems.CORN)))

                .withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .when(mature.invert())
                        .add(LootItem.lootTableItem(ModItems.CORN_SEEDS)));
    }
}
