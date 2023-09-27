package me.dajman.blockportals.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import me.dajman.blockportals.utils.configFiles.DatabaseConfig;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;

public class YmlFileManager {

    public static void load() throws IOException {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("BlockPortals").getDataFolder(), "storage.yml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        DatabaseConfig config = objectMapper.readValue(file, DatabaseConfig.class);
        System.out.println("Application config info " + config.getPassword());
    }

    public static void save() throws IOException {
        DatabaseConfig dbconfig = new DatabaseConfig();
        dbconfig.setDbname("newdb");
        dbconfig.setPort(6601);
        dbconfig.setUsername("appuser");
        dbconfig.setPassword("apppassword");
        DatabaseConfig config = new DatabaseConfig();
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue(new File(Bukkit.getServer().getPluginManager().getPlugin("BlockPortals").getDataFolder(), "storage.yml"), config);
    }

}
