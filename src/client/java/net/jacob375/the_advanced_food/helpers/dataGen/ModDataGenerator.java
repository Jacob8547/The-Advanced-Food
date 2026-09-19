package net.jacob375.the_advanced_food.helpers.dataGen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModAdvancementProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModRecipeProvider::new);
    }

}
