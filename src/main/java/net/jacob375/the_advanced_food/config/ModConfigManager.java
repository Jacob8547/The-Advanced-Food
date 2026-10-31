package net.jacob375.the_advanced_food.config;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.neoforged.fml.loading.FMLPaths;

public class ModConfigManager {
    private static final Path CONFIG_PATH = FMLPaths.CONFIGDIR.get().resolve("the_advanced_food.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static ModConfigValues CONFIG = new ModConfigValues();

    public static void load() {
        if (Files.exists(CONFIG_PATH)) {
            try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
                ModConfigValues loaded = GSON.fromJson(reader, ModConfigValues.class);
                // fromJson returns null for an empty file, so keep the defaults in that case
                if (loaded != null) {
                    CONFIG = loaded;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            save();
        }
    }

    public static void save() {
        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
            GSON.toJson(CONFIG, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}