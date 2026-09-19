package net.jacob375.the_advanced_food.config;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.fabricmc.loader.api.FabricLoader;

public class ModConfigManager {
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("the-advanced-food.json");
    public static ModConfigValues CONFIG = new ModConfigValues();

    public static void load() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        if (Files.exists(CONFIG_PATH)) {
            try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
                CONFIG = gson.fromJson(reader, ModConfigValues.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            save();
        }
    }

    public static void save() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
            gson.toJson(CONFIG, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
