package net.jacob375.the_advanced_food;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jacob375.the_advanced_food.config.ModConfigManager;
import net.jacob375.the_advanced_food.helpers.ModItemsCommon;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.Row;
import net.minecraft.world.item.ItemStack;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as NeoForge events
// however it will be compatible with all supported mod loaders.
public class TheAdvancedFoodCommon {
    public static final String MOD_ID = "the_advanced_food";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Build Creative Mode Tab Key & Instance (Platform agnostic)
    public static final ResourceKey<CreativeModeTab> CUSTOM_ITEM_GROUP_KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MOD_ID, "the_advanced_food_tab"));

    public static final CreativeModeTab CUSTOM_ITEM_GROUP = CreativeModeTab.builder(Row.TOP, 0)
            .icon(() -> new ItemStack(ModItemsCommon.BACON))
            .title(Component.translatable("The Advanced Food Tab"))
            .build();

    public static void commonInit() {
        LOGGER.info("The Advanced Food Common Initialized!");
        // Load Config
        ModConfigManager.load();
    }
}