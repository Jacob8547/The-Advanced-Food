package net.jacob375.the_advanced_food.util;

import java.nio.file.Path;
import java.util.ServiceLoader;

public interface PlatformService {
    Path getConfigDirectory();

    // Helper to load the correct platform implementation at runtime
    PlatformService INSTANCE = ServiceLoader.load(PlatformService.class)
            .findFirst()
            .orElseThrow(() -> new NullPointerException("Failed to load PlatformService for common code!"));
}