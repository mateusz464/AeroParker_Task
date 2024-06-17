package com.example.registration.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class to establish a connection to the database
 */
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
        // Load the database properties from the configuration file
        String url = Config.getProperty("db.url");
        String user = Config.getProperty("db.user");
        String password = Config.getProperty("db.password");

        // Establish the connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }

    // Static method to get the instance of the class
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Getter method to return the connection
    public Connection getConnection() {
        return connection;
    }
}
