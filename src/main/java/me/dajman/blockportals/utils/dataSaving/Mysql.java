package me.dajman.blockportals.utils.dataSaving;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysql {
    private final String host;
    private final String database;
    private final String username;
    private final String password;
    private final int port;

    public Mysql(final String host, final String database, final String username, final String password, final int port) {
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public String getHost() {
        return this.host;
    }

    public String getDatabase() {
        return this.database;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getPort() {
        return this.port;
    }
    // connect to database
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?autoReconnect=true&useSSL=false", this.username, this.password);
    }
    // create table with UUID, four integers, and a string
    public void createTable() throws SQLException{
        try (final Connection connection = this.getConnection()) {
            connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS teleports " +
                    "(uuid VARCHAR(36) PRIMARY KEY, x INT, y INT, z INT, world VARCHAR(36), " +
                    "name VARCHAR(16))");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // save a player's location to the database
    public void saveLocation(final String uuid, final int x, final int y, final int z, final String world, final String name) throws SQLException {
        try (final Connection connection = this.getConnection()) {
            connection.createStatement().executeUpdate("INSERT INTO teleports (uuid, x, y, z, world, name) VALUES ('" + uuid + "', '" + x + "', '" + y + "', '" + z + "', '" + world + "', '" + name + "')");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // get coordinates from the database
    public int[] getCoords(final String uuid) throws SQLException {
        try (final Connection connection = this.getConnection()) {
            final int[] coords = new int[3];
            final ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM teleports WHERE uuid='" + uuid + "'");
            if (resultSet.next()) {
                coords[0] = resultSet.getInt("x");
                coords[1] = resultSet.getInt("y");
                coords[2] = resultSet.getInt("z");
            }
            return coords;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    // get world from the database
    public String getWorld(final String uuid) throws SQLException {
        try (final Connection connection = this.getConnection()) {
            final ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM teleports WHERE uuid='" + uuid + "'");
            if (resultSet.next()) {
                return resultSet.getString("world");
            }
            return null;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    // delete a player's location from the database
    public void deleteLocation(final String uuid) throws SQLException {
        try (final Connection connection = this.getConnection()) {
            connection.createStatement().executeUpdate("DELETE FROM teleports WHERE uuid='" + uuid + "'");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // create table with UUID and a integer for the player's points
    public void createTeleportsTable() throws SQLException{
        try (final Connection connection = this.getConnection()) {
            connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS points " +
                    "(uuid VARCHAR(36) PRIMARY KEY, points INT)");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
