package org.example.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlite:movies.db");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);

        dataSource = new HikariDataSource(config);
    }

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public static void closeConnection() {
        if (dataSource != null) {
            dataSource.close();
            System.out.println("connection pool closed.");
        }
    }
}