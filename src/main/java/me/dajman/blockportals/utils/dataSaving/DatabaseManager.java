package me.dajman.blockportals.utils.dataSaving;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class DatabaseManager {

    private final String databaseType;
    private Mysql mysql;
    private SQLite sqlite;

    public DatabaseManager(String databaseType){
        this.databaseType = databaseType;
        switch (this.databaseType){
            case "mysql":
                mysql = new Mysql();
            case "sqlite":
                break;
            case "json":
                break;
            default:
                break;
        }
    }

    public String getDatabaseType(){
        return this.databaseType;
    }

    public void createTable(){
        switch (this.databaseType){
            case "mysql":
                break;
            case "sqlite":
                break;
            case "json":
                break;
            default:
                break;
        }
    }

    public void saveLocation(Player player, Location location, String name){
        switch (this.databaseType){
            case "mysql":
                break;
            case "sqlite":
                break;
            case "json":
                break;
            default:
                break;
        }
    }


}
