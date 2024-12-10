package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    private static String JDBC_URL; // No longer final, we'll set it at runtime.

    static {
        try {
            // Load the SQLite driver
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Called at startup (from a listener or servlet) to set the absolute DB URL
    public static void setDbUrl(String url) {
        JDBC_URL = url;
    }

    public static Connection getConnection() throws SQLException {
        if (JDBC_URL == null) {
            throw new SQLException("Database URL is not set. Make sure setDbUrl() is called before accessing the database.");
        }
        return DriverManager.getConnection(JDBC_URL);
    }
}
