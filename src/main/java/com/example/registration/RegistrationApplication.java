package com.example.registration;

import com.example.registration.Config.DatabaseConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class to run the Spring application
 */
@SpringBootApplication
public class RegistrationApplication {
    public static void main(String[] args) {
        // Get the connection instance
        DatabaseConnection connection = DatabaseConnection.getInstance();
        System.out.println(connection.getConnection());

        // Run the Spring application
        SpringApplication.run(RegistrationApplication.class, args);
    }
}
