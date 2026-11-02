package net.jacob375.the_advanced_food;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class TheAdvancedFood implements ModInitializer {

    @Override
    public void onInitialize() {
        // Run common setup (like config loading)
        TheAdvancedFoodCommon.commonInit();

        // Register Creative Mode Tab on Fabric
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                TheAdvancedFoodCommon.CUSTOM_ITEM_GROUP_KEY,
                TheAdvancedFoodCommon.CUSTOM_ITEM_GROUP);
    }
}
