package net.jacob375.the_advanced_food.platform;

import net.jacob375.the_advanced_food.platform.services.IPlatformHelper;

import java.nio.file.Path;

import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    public static Path getConfigDirectory() {
        return net.fabricmc.loader.api.FabricLoader.getInstance().getConfigDir();
    }
}
