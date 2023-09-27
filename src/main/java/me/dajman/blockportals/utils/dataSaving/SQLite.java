package me.dajman.blockportals.utils.dataSaving;

import org.bukkit.entity.Player;

import java.sql.*;

public class SQLite {

    private final Connection connection;

    public SQLite(String path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path);
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS players (" +
                    "uuid TEXT PRIMARY KEY, " +
                    "username TEXT NOT NULL, " +
                    "points INTEGER NOT NULL DEFAULT 0)");
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public void addPlayer(Player player) throws SQLException {
        //this should error if the player already exists
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO players (uuid, username) VALUES (?, ?)")) {
            preparedStatement.setString(1, player.getUniqueId().toString());
            preparedStatement.setString(2, player.getName());
            preparedStatement.executeUpdate();
        }
    }

    public boolean playerExists(Player player) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM players WHERE uuid = ?")) {
            preparedStatement.setString(1, player.getUniqueId().toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }

    public void updatePlayerPoints(Player player, int x, int y, int z) throws SQLException{

        //if the player doesn't exist, add them
        if (!playerExists(player)){
            addPlayer(player);
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET x = ? WHERE uuid = ?")) {
            preparedStatement.setInt(1, x);
            preparedStatement.setString(2, player.getUniqueId().toString());
            preparedStatement.executeUpdate();
        }
    }

    public int getPlayerPoints(Player player) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT points FROM players WHERE uuid = ?")) {
            preparedStatement.setString(1, player.getUniqueId().toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("points");
            } else {
                return 0; // Return 0 if the player has no points
            }
        }
    }

}