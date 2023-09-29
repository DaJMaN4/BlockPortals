package me.dajman.blockportals.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import me.dajman.blockportals.utils.configFiles.LangConfig;
import me.dajman.blockportals.utils.configFiles.MainConfig;
import me.dajman.blockportals.utils.configFiles.StorageConfig;
import me.dajman.blockportals.utils.dataSaving.ListYamlPortals;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;

public class YamlManager {
    private static StorageConfig storageConfig;
    private static MainConfig mainConfig;
    private static LangConfig langConfig;
    private static ListYamlPortals listYamlPortals;
    private final String PluginPath;


    public YamlManager() throws IOException {
        loadConfig();
        this.PluginPath = Bukkit.getPluginsFolder().getAbsolutePath() + File.separator + "BlockPortals";
    }

    public static void loadConfig() throws IOException {
        loadStorageConfig();
        loadMainConfig();
        loadLangConfig();
    }

    public static void saveConfig() throws IOException {
        saveStorageConfig();
        saveMainConfig();
        saveLangConfig();
    }

    public static void loadStorage() throws IOException {
        loadStoragePortals();
    }

    public static void saveStorage() throws IOException {
        saveStoragePortals();
    }

    private static void loadStorageConfig() throws IOException {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("BlockPortals").getDataFolder(), "storageConfig.yml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        storageConfig = objectMapper.readValue(file, StorageConfig.class);
    }

    private static void saveStorageConfig() throws IOException {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("BlockPortals").getDataFolder(), "storageConfig.yml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue(file, storageConfig);
    }

    public static StorageConfig getStorageConfig() {
        return storageConfig;
    }


    private static void loadMainConfig() throws IOException {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("BlockPortals").getDataFolder(), "config.yml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        mainConfig = objectMapper.readValue(file, MainConfig.class);
    }

    private static void saveMainConfig() throws IOException {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("BlockPortals").getDataFolder(), "config.yml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue(file, mainConfig);
    }

    public static MainConfig getMainConfig() {
        return mainConfig;
    }


    private static void loadLangConfig() throws IOException {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("BlockPortals").getDataFolder(), "lang.yml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        langConfig = objectMapper.readValue(file, LangConfig.class);
    }

    private static void saveLangConfig() throws IOException {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("BlockPortals").getDataFolder(), "lang.yml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue(file, langConfig);
    }

    public static LangConfig getLangConfig() {
        return langConfig;
    }


    private static void loadStoragePortals() throws IOException {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("BlockPortals").getDataFolder(), "portals.yml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        listYamlPortals = objectMapper.readValue(file, ListYamlPortals.class);
    }

    private static void saveStoragePortals() throws IOException {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("BlockPortals").getDataFolder(), "portals.yml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue(file, listYamlPortals);
    }

    public static ListYamlPortals getStoragePortals() {
        return listYamlPortals;
    }

}
