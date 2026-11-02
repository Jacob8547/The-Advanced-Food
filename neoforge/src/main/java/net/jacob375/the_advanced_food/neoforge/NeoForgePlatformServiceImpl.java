package net.jacob375.the_advanced_food.neoforge;

import net.neoforged.fml.loading.FMLPaths;
import net.jacob375.the_advanced_food.util.PlatformService;
import java.nio.file.Path;

public class NeoForgePlatformServiceImpl implements PlatformService {
    @Override
    public Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}