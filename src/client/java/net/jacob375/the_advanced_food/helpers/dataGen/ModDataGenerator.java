package net.jacob375.the_advanced_food.helpers.dataGen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.jacob375.the_advanced_food.helpers.dataGen.client.ModEnglighLangProvider;
import net.jacob375.the_advanced_food.helpers.dataGen.client.ModModelProvider;
import net.jacob375.the_advanced_food.helpers.dataGen.server.ModAdvancementProvider;
import net.jacob375.the_advanced_food.helpers.dataGen.server.ModLootTableProvider;
import net.jacob375.the_advanced_food.helpers.dataGen.server.ModRecipeProvider;
import net.jacob375.the_advanced_food.helpers.dataGen.server.ModWorldFeatures;
import net.jacob375.the_advanced_food.helpers.dataGen.server.ModWorldPlacedFeatures;
import net.jacob375.the_advanced_food.helpers.dataGen.server.ModWorldgenProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class ModDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // Server
        pack.addProvider(ModAdvancementProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModWorldgenProvider::new);

        // Client
        pack.addProvider(ModEnglighLangProvider::new);
        pack.addProvider(ModModelProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.FEATURE, ModWorldFeatures::configure);
        registryBuilder.add(Registries.PLACED_FEATURE, ModWorldPlacedFeatures::configure);
    }
}
