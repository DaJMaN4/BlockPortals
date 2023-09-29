package me.dajman.blockportals.portals;

import me.dajman.blockportals.utils.YamlManager;
import me.dajman.blockportals.utils.dataSaving.StorageYamlPortals;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PortalsManager {

    private List<Portal> portals;
    private HashMap<String, Portal> playersCreatingPortals;

    public PortalsManager() {

    }

    public void loadPortals() {
        for (StorageYamlPortals storageYamlPortals : YamlManager.getStoragePortals().getPortals()) {
            Portal portal = new Portal(storageYamlPortals.getName(), storageYamlPortals.getUuid(), storageYamlPortals.getOwner(),
                    storageYamlPortals.getLocation_1(), storageYamlPortals.getLocation_2());
            this.portals.add(portal);
        }
    }


    public void savePortals() {
        for (Portal portal : this.portals) {
            YamlManager.getStoragePortals().getPortals().add(new StorageYamlPortals(portal.getName(), portal.getUuid(),
                    portal.getOwner(), portal.getLocation_1(), portal.getLocation_2()));
        }
    }


    public List<Portal> getPortals() {
        return this.portals;
    }

    public Portal getPortal(String name) {
        for (Portal portal : this.portals) {
            if (portal.getName().equals(name)) {
                return portal;
            }
        }
        return null;
    }

    public Boolean deletePortal(String name) {
        for (Portal portal : this.portals) {
            if (portal.getName().equals(name)) {
                this.portals.remove(portal);
                return true;
            }
        }
        return false;
    }

    public List<Portal> getPlayersPortals(String PlayerName) {
        List<Portal> playersPortals = new ArrayList<>();
        for (Portal portal : this.portals) {
            if (portal.isOwner(PlayerName)) {
                playersPortals.add(portal);
            }
        }
        return playersPortals;
    }

    public Boolean isPortal(String name) {
        for (Portal portal : this.portals) {
            if (portal.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Boolean isPortal(Location location) {
        for (Portal portal : this.portals) {
            if (portal.getLocation_1().equals(location) || portal.getLocation_2().equals(location)) {
                return true;
            }
        }
        return false;
    }

    public void createPortal(String playerName, String name) {
        Portal portal = new Portal(name, playerName);
        this.playersCreatingPortals.put(playerName, portal);
    }

    public void setLocationPortal(Location location, String playerName) {
        if (playersCreatingPortals.containsKey(playerName)) {
            if (isPortal(location)) {
                Bukkit.getPlayer(playerName).sendMessage("Portal already exists here");
                return;
            }
            if (playersCreatingPortals.get(playerName).getLocation_1() == null) {
                playersCreatingPortals.get(playerName).setLocation_1(location);
                return;
            }
            playersCreatingPortals.get(playerName).setLocation_2(location);
            portals.add(playersCreatingPortals.get(playerName));
            playersCreatingPortals.remove(playerName);
        }
    }

    public HashMap<String, Portal> getPlayersCreatingPortals() {
        return playersCreatingPortals;
    }

}
