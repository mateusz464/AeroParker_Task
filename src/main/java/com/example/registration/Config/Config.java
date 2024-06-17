package com.example.registration.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class is used to read the properties from the config.properties file.
 */
public class Config {
    private static final Properties properties = new Properties();

    // Load the properties file
    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (input == null) {
                System.out.println("Unable to find config.properties");
            } else {
                properties.load(input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the property value from the key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
