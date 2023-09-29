package me.dajman.blockportals.utils.dataSaving;

import org.bukkit.Location;

import java.util.UUID;

public class StorageYamlPortals {
    private String name;
    private UUID uuid;
    private Location location_1;
    private Location location_2;
    private String owner;

    public StorageYamlPortals(String name, UUID uuid, String owner, Location location_1, Location location_2) {
        this.name = name;
        this.uuid = uuid;
        this.location_1 = location_1;
        this.location_2 = location_2;
        this.owner = owner;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Location getLocation_1() {
        return this.location_1;
    }

    public void setLocation_1(Location location_1) {
        this.location_1 = location_1;
    }

    public Location getLocation_2() {
        return this.location_2;
    }

    public void setLocation_2(Location location_2) {
        this.location_2 = location_2;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
