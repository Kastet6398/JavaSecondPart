package com.example.demo1.records;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static final String DATABASE_PATH = "jdbc:sqlite:database.db";
    private DatabaseConnection() {
        throw new IllegalStateException("Utility class is not initialized");
    }
    private static Connection conn;
    static {
        try {
            createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(DATABASE_PATH);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static Task getTaskById(int id) throws SQLException {
        try(PreparedStatement stmt = getConn().prepareStatement(
                "SELECT * FROM tasks WHERE id = ?"
        )) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Task(rs.getString("text"), rs.getInt("id"), rs.getTimestamp("timestamp"), rs.getBoolean("is_shown"));
            } else {
                return null;
            }
        }
    }

    public static void createTable() throws SQLException {
        try (Statement stmt = getConn().createStatement()) {
            stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS tasks (
                        id INTEGER PRIMARY KEY,
                        text TEXT NOT NULL,
                        timestamp TIMESTAMP NOT NULL,
                        is_shown BOOLEAN DEFAULT 0
                    )
                    """);
        }
    }


    public static void insertData(String text, Timestamp timestamp) throws SQLException {
        try (PreparedStatement stmt = getConn().prepareStatement(
                "INSERT INTO tasks (text, timestamp) VALUES (?, ?)"
        )) {
            stmt.setString(1, text);
            stmt.setTimestamp(2, timestamp);
            stmt.executeUpdate();
        }
    }
    public static void setShown(int id) throws SQLException {

        try(PreparedStatement stmt = getConn().prepareStatement("""
UPDATE tasks
SET is_shown = 1
WHERE id = ?
""")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public static void updateData(String text, int id, Timestamp timestamp) throws SQLException {

        try(PreparedStatement stmt = getConn().prepareStatement("""
UPDATE tasks
SET text = ?, timestamp = ?
WHERE id = ?
""")) {
            stmt.setString(1, text);
            stmt.setTimestamp(2, timestamp);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            }
    }

    public static List<Task> retrieveData() throws SQLException {
        try (Statement stmt = getConn().createStatement()) {
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM tasks"
            );

            List<Task> tasks = new ArrayList<>();
            while (rs.next()) {
                tasks.add(new Task(rs.getString("text"), rs.getInt("id"), rs.getTimestamp("timestamp"), rs.getBoolean("is_shown")));
            }
            return tasks;
        }
    }

    public static void deleteData(int id) throws SQLException {
        try (PreparedStatement stmt = getConn().prepareStatement(
                "DELETE FROM tasks WHERE id = ?"
        )) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}