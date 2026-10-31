package net.jacob375.the_advanced_food;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.jacob375.the_advanced_food.config.ModConfigManager;
import net.jacob375.the_advanced_food.helpers.ModBlocks;
import net.jacob375.the_advanced_food.helpers.ModItems;
import net.jacob375.the_advanced_food.helpers.dataGen.ModDataGenerators;
import net.jacob375.the_advanced_food.helpers.extra.ModCreativeTabs;
import net.jacob375.the_advanced_food.helpers.extra.ModLootModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(TheAdvancedFood.MOD_ID)
public class TheAdvancedFood {
        public static final String MOD_ID = "the_advanced_food";
        public static final Logger LOGGER = LogUtils.getLogger();

        public TheAdvancedFood(IEventBus modEventBus, ModContainer modContainer) {
                LOGGER.info("Foods Loaded!");

                ModBlocks.register(modEventBus);
                ModItems.register(modEventBus);
                ModCreativeTabs.register(modEventBus);
                ModLootModifiers.register(modEventBus);

                modEventBus.addListener(ModDataGenerators::gatherClient);
                modEventBus.addListener(ModDataGenerators::gatherRegistryEntries);

                ModConfigManager.load();
        }
}
