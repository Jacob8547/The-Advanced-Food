package net.jacob375.the_advanced_food.helpers.dataGen;

import java.util.List;
import java.util.Set;

import net.jacob375.the_advanced_food.helpers.dataGen.client.ModEnglishLangProvider;
import net.jacob375.the_advanced_food.helpers.dataGen.client.ModModelProvider;
import net.jacob375.the_advanced_food.helpers.dataGen.server.*;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;

public class ModDataGenerators {
    public static void gatherClient(GatherDataEvent.Client event) {
        event.createProvider(ModEnglishLangProvider::new);
        event.createProvider(ModModelProvider::new);
    }

    public static void gatherRegistryEntries(GatherDataRegistryEntriesEvent event) {
        // Worldgen (replaces createDatapackRegistryObjects)
        event.add(Registries.FEATURE, ModWorldFeatures::configure);
        event.add(Registries.PLACED_FEATURE, ModWorldPlacedFeatures::configure);

        event.add(ModRecipeProvider.create());

        event.lootTable(new LootTableProvider.SubProviderEntry(
                context -> new ModBlockLootTables(context), LootContextParamSets.BLOCK));

        event.advancement(ModAdvancementGenerator::new);
    }
}