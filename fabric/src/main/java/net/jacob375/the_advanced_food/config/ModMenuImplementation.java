package net.jacob375.the_advanced_food.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.jacob375.the_advanced_food.fabric.client.config.ModConfigScreen;

@Environment(EnvType.CLIENT)
public class ModMenuImplementation implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if (!FabricLoader.getInstance().isModLoaded("cloth-config")) {
            return null;
        }
        return parent -> ModConfigScreen.create(parent);
    }
}
