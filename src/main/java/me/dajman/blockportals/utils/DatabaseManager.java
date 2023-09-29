package me.dajman.blockportals.utils;

import me.dajman.blockportals.utils.configFiles.StorageConfig;
import me.dajman.blockportals.utils.dataSaving.Mysql;
import me.dajman.blockportals.utils.dataSaving.SQLite;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseManager {

    private final String databaseType;
    private final String path;
    private Mysql mysql;
    private SQLite sqlite;
    private StorageConfig storageConfig;

    public DatabaseManager(String databaseType) throws SQLException, IOException {
        path = Bukkit.getServer().getPluginManager().getPlugin("BlockPortals").getDataFolder().getAbsolutePath();

        this.databaseType = databaseType;
        switch (this.databaseType) {
            case "mysql" -> {

            }
            case "sqlite" -> sqlite = new SQLite(path);
            case "yaml" -> {
                YamlManager.loadStorage();
            }
            default -> {
            }
        }
    }

    public void savePortal(Location location, String owner) throws SQLException, IOException {
        switch (this.databaseType) {
            case "mysql" -> {

            }
            case "sqlite" -> {

            }
            case "yaml" -> {
                YamlManager.saveStorage();
            }
            default -> {
            }
        }
    }

    public String getDatabaseType() {
        return this.databaseType;
    }


}
