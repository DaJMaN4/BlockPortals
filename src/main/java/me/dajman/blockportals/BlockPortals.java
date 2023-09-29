package me.dajman.blockportals;

import me.dajman.blockportals.listeners.EventOnPlayerInteract;
import me.dajman.blockportals.portals.PortalsManager;
import me.dajman.blockportals.utils.DatabaseManager;
import me.dajman.blockportals.utils.YamlManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.sql.SQLException;


// Portal block will have a metadata tag that shows that it is

public final class BlockPortals extends JavaPlugin {

    private static YamlManager yamlManager;
    private static DatabaseManager databaseManager;
    private PortalsManager portalManager = new PortalsManager();

    public static BlockPortals getInstance() {
        return getPlugin(BlockPortals.class);
    }

    public static YamlManager getYamlManager() {
        return yamlManager;
    }

    @Override
    public void onEnable() {
        try {
            yamlManager = new YamlManager();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        portalManager.loadPortals();

        try {
            databaseManager = new DatabaseManager(YamlManager.getStorageConfig().getDatabaseType());
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        Bukkit.getPluginManager().registerEvents(new EventOnPlayerInteract(portalManager), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        portalManager.savePortals();
        try {
            YamlManager.saveConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PortalsManager getPortalManager() {
        return portalManager;
    }

}
