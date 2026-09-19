package net.jacob375.the_advanced_food.config;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;

@Environment(EnvType.CLIENT)
public class ModConfigScreen {

        public static Screen create(Screen parent) {
                ConfigBuilder builder = ConfigBuilder.create()
                                .setParentScreen(parent)
                                .setTitle(Component.literal("The Advanced Food Settings"))
                                .setSavingRunnable(ModConfigManager::save);

                ConfigCategory general = builder.getOrCreateCategory(
                                Component.literal("General"));

                ConfigEntryBuilder entryBuilder = builder.entryBuilder();

                general.addEntry(
                                entryBuilder.startBooleanToggle(
                                                Component.literal("Use Old Food Values"),
                                                ModConfigManager.CONFIG.useOldFoodValues)
                                                .setDefaultValue(false)
                                                .setSaveConsumer(
                                                                value -> ModConfigManager.CONFIG.useOldFoodValues = value)
                                                .setTooltip(Component.literal(
                                                                "Use legacy nutrition & saturation values.\nYou must restart the game to take effect!"))
                                                .build());

                return builder.build();
        }
}