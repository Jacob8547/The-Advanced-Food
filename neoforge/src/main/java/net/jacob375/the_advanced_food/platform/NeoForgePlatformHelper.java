package net.jacob375.the_advanced_food.platform;

import java.nio.file.Path;

import net.jacob375.the_advanced_food.platform.services.IPlatformHelper;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.getCurrent().isProduction();
    }

    public static Path getConfigDirectory() {
        return net.neoforged.fml.loading.FMLPaths.CONFIGDIR.get();
    }
}