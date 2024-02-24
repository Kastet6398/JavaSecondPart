package org.example.utils;

import java.sql.*;

public class Dao {
    private Dao() {
        throw new AssertionError("Instantiation of utility class 'Dao'");
    }

    private static Connection connection;

    public static void createTables(Connection connection) throws SQLException {
        connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name TEXT NOT NULL, telegramId BIGINT UNIQUE NOT NULL)");
        connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS operations (id SERIAL PRIMARY KEY, text TEXT NOT NULL, telegramId BIGINT UNIQUE NOT NULL)");
        connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS user_operations (id SERIAL PRIMARY KEY, user_id INTEGER REFERENCES users(id), operation_id INTEGER REFERENCES operations(id))");

    }

    public static void createUser(Connection connection, String name, long telegramId) throws SQLException {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO users(name, telegramId) VALUES (?, ?) ON CONFLICT DO NOTHING");
            statement.setString(1, name);
            statement.setLong(2, telegramId);
            statement.executeUpdate();

    }

    public static void createOperation(Connection connection, String text, long telegramId) throws SQLException {

        PreparedStatement statement2 = connection.prepareStatement("INSERT INTO operations(text, telegramId) VALUES (?, ?) ON CONFLICT DO NOTHING");
        statement2.setString(1, text);
        statement2.setLong(2, telegramId);
        statement2.executeUpdate();

    }

    public static void createUserOperationIntermediate(Connection connection, int userId, int operationId) throws SQLException {

        PreparedStatement statement4 = connection.prepareStatement("INSERT INTO user_operations(user_id, operation_id) VALUES (?, ?) ON CONFLICT DO NOTHING");
        statement4.setInt(1, userId);
        statement4.setInt(2, operationId);
        statement4.executeUpdate();

    }

    public static ResultSet fetchOperationsByUserTelegramId(Connection connection, long userTelegramId) throws SQLException {

            PreparedStatement statement1 = connection.prepareStatement("SELECT operations.* FROM operations " +
                                                                               "INNER JOIN user_operations ON operations.id = user_operations.operation_id " +
                                                                               "INNER JOIN users ON users.id = user_operations.user_id " +
                                                                               "WHERE users.telegramId = ? " +
                                                                               "ORDER BY operations.id DESC;");
            statement1.setLong(1, userTelegramId);
            return statement1.executeQuery();

    }

    public static ResultSet getUserByTelegramId(Connection connection, long userTelegramId) throws SQLException {

        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM users WHERE users.telegramId=?");
        statement1.setLong(1, userTelegramId);
        return statement1.executeQuery();

    }

    public static ResultSet getOperationByTelegramId(Connection connection, long userTelegramId) throws SQLException {

        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM operations WHERE operations.telegramId=?");
        statement1.setLong(1, userTelegramId);
        return statement1.executeQuery();

    }

    public static void createTables() throws SQLException {
        Connection connection = getConnection();
        createTables(connection);
        connection.close();
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USR, Constants.DB_PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
