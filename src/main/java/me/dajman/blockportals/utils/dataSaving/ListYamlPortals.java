package me.dajman.blockportals.utils.dataSaving;

import java.util.List;

public class ListYamlPortals {
    private List<StorageYamlPortals> portals;

    public ListYamlPortals(List<StorageYamlPortals> portals) {
        this.portals = portals;
    }

    public List<StorageYamlPortals> getPortals() {
        return this.portals;
    }

    public void setPortals(List<StorageYamlPortals> portals) {
        this.portals = portals;
    }
}
