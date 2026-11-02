package net.jacob375.the_advanced_food.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.jacob375.the_advanced_food.util.PlatformService;
import java.nio.file.Path;

public class FabricPlatformServiceImpl implements PlatformService {
    @Override
    public Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}