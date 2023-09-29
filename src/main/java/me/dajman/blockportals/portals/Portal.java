package me.dajman.blockportals.portals;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Portal {
    private String name;
    private UUID uuid;
    private Location location_1 = null;
    private Location location_2 = null;
    private String owner;

    public Portal(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public Portal(String name, UUID uuid, String owner, Location location_1, Location location_2) {
        this.name = name;
        this.uuid = uuid;
        this.owner = owner;
        this.location_1 = location_1;
        this.location_2 = location_2;
    }

    public void teleportPlayer(Player player, Location location) {
        if (!isPortalDone()) {
            player.sendMessage("Portal is not done");
        }

        if (location.equals(location_1)) {
            if (isLocationSave(location_1)) {
                player.teleport(location_1);
            } else {
                player.sendMessage("Portal is not safe");
            }
            return;
        }

        if (location.equals(location_2)) {
            if (isLocationSave(location_2)) {

                player.teleport(location_2);
            } else {
                player.sendMessage("Portal is not safe");
            }
            return;
        }
        player.sendMessage("something went wrong");
    }

    public void adminTeleport() {

    }

    public Boolean isPortalInLocation(Location location) {
        if (location.getWorld().getName().equals(location_1.getWorld().getName()) ||
                location.getWorld().getName().equals(location_2.getWorld().getName())) {
            if (location.getX() == location_1.getX() || location.getX() == location_2.getX()) {
                if (location.getY() >= location_1.getY() && location.getY() <= location_2.getY()) {
                    if (location.getZ() >= location_1.getZ() && location.getZ() <= location_2.getZ()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Boolean isLocationSave(Location location) {
        if (!Bukkit.getWorld(location.getWorld().getName()).getBlockAt(location.getBlockX(),
                location.getBlockY() + 2, location.getBlockZ()).isSolid())
            return false;
        if (!Bukkit.getWorld(location.getWorld().getName()).getBlockAt(location.getBlockX(),
                location.getBlockY() + 1, location.getBlockZ()).isSolid())
            return false;
        return !Bukkit.getWorld(location.getWorld().getName()).getBlockAt(location.getBlockX(),
                location.getBlockY(), location.getBlockZ()).isSolid();
    }

    public Boolean isPortalDone() {
        return location_1 != null && location_2 != null;
    }

    public Boolean isOwner(Player player) {
        return player.getUniqueId().equals(uuid);
    }

    public String getOwner() {
        return owner;
    }

    public Boolean isOwner(String playerName) {
        return playerName.equals(owner);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void transferOwner(String playerName) {
        this.owner = playerName;
    }

    public Location getLocation_1() {
        return location_1;
    }

    public void setLocation_1(Location location) {
        this.location_1 = location;
    }

    public Location getLocation_2() {
        return location_2;
    }

    public void setLocation_2(Location location) {
        this.location_2 = location;
    }

    public UUID getUuid() {
        return uuid;
    }

}
