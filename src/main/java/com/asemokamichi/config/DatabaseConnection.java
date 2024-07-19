package com.asemokamichi.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static final String PROPERTIES_FILE = "/config.properties";
    private String url;
    private String user;
    private String password;

    public DatabaseConnection() {
        loadProperties();
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new IllegalArgumentException("Couldn't find the " + PROPERTIES_FILE + " file");
            }
            properties.load(input);
            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error loading the property", ex);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
