package net.jacob375.the_advanced_food;

import net.fabricmc.api.ModInitializer;
import net.jacob375.the_advanced_food.config.ModConfigManager;
import net.jacob375.the_advanced_food.helpers.ModBlocks;
import net.jacob375.the_advanced_food.helpers.ModFeatures;
import net.jacob375.the_advanced_food.helpers.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab.Row;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheAdvancedFood implements ModInitializer {
	public static final String MOD_ID = "the-advanced-food";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Foods Loaded!");

		// Create Creative Mode Tab
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TheAdvancedFood.CUSTOM_ITEM_GROUP_KEY,
				TheAdvancedFood.CUSTOM_ITEM_GROUP);

		// Load Config
		ModConfigManager.load();
	}

	// CLASSES
	public ModItems modItems = new ModItems();
	public ModBlocks modBlocks = new ModBlocks();
	public ModFeatures modFeatures = new ModFeatures();

	// Build Creative Mode Tab
	public static final ResourceKey<CreativeModeTab> CUSTOM_ITEM_GROUP_KEY = ResourceKey.create(
			BuiltInRegistries.CREATIVE_MODE_TAB.key(),
			Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, "the_advanced_food_tab"));
	public static final CreativeModeTab CUSTOM_ITEM_GROUP = CreativeModeTab.builder(Row.TOP, 0)
			.icon(() -> new ItemStack(ModItems.BACON)).title(Component.translatable("The Advanced Food Tab")).build();
}