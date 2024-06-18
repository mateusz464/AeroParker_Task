package com.example.registration.Config;

import java.sql.*;

/**
 * Singleton class to establish a connection to the database
 */
public class DatabaseService {
    private static DatabaseService instance;
    private Connection connection;

    // Private constructor to prevent instantiation
    private DatabaseService() {
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
    public static DatabaseService getInstance() {
        if (instance == null) {
            instance = new DatabaseService();
        }
        return instance;
    }

    // Getter method to return the connection
    public Connection getConnection() {
        return connection;
    }

    // Method to check if an email already exists in the database
    public boolean emailExists(String email) {
        String query = "SELECT email_address FROM customers WHERE email_address = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Query execution failed");
            e.printStackTrace();
        }
        return false;
    }

    // Method to insert a new customer into the database
    public void insertCustomer(String email, String title, String firstName, String lastName, String address1, String address2, String city, String postcode, String phone) {
        String query = "INSERT INTO customers (registered, email_address, title, first_name, last_name, address_line_1, address_line_2, city, postcode, phone_number) VALUES (NOW(), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, address1);
            preparedStatement.setString(6, address2);
            preparedStatement.setString(7, city);
            preparedStatement.setString(8, postcode);
            preparedStatement.setString(9, phone);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Query execution failed");
            e.printStackTrace();
        }
    }
}
