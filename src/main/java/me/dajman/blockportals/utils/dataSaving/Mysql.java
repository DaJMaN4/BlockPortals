package me.dajman.blockportals.utils.dataSaving;

import me.dajman.blockportals.utils.configFiles.StorageConfig;

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
    private final String tablePrefix;
    private Boolean enableSLL = false;

    public Mysql(final String host, final String database, final String username, final String password, final int port, final String tablePrefix) {

        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        this.port = port;
        this.tablePrefix = tablePrefix;
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

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database +
                "?autoReconnect=true&useSSL=" + enableSLL, this.username, this.password);
    }

    public void createTable() throws SQLException{
        try (final Connection connection = this.getConnection()) {
            connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS " + this.tablePrefix + "portals " +
                    "(uuid VARCHAR(36) PRIMARY KEY, world1 VARCHAR(36), x1 INT, y1 INT, z1 INT, " +
                    "world2 VARCHAR(36), x2 INT, y2 INT, z2 INT, name VARCHAR(16))");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveLocation(final String uuid, final String world1, final int x1, final int y1, final int z1,
                             final String world2, final int x2, final int y2, final int z2, final String name) throws SQLException {
        try (final Connection connection = this.getConnection()) {
            connection.createStatement().executeUpdate(
                    "INSERT INTO teleports (uuid, world1, x1, y1, z1, world2, x2, y2, z2, name) VALUES " +
                            "('" + uuid + "', '" + world1 + "', '" + x1 + "', '" + y2 + "', '" + z2 + "','" +
                            world2 + "', '" + x2 + "', '" + y2 + "', '" + z2 + "','" + name + "')");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int[] getCoords(final String uuid) throws SQLException {
        try (final Connection connection = this.getConnection()) {
            final int[] coords = new int[3];
            final ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM teleports WHERE uuid='" + uuid + "'");
            if (resultSet.next()) {

                coords[0] = resultSet.getInt("world");
                coords[1] = resultSet.getInt("x1");
                coords[2] = resultSet.getInt("y1");
            }
            return coords;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

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

    public void deleteLocation(final String uuid) throws SQLException {
        try (final Connection connection = this.getConnection()) {
            connection.createStatement().executeUpdate("DELETE FROM teleports WHERE uuid='" + uuid + "'");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
