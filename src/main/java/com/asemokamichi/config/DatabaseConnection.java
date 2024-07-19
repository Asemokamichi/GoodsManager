package com.asemokamichi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/warehouse_db"; // URL для подключения к MySQL
    private static final String USER = "root"; // Пользователь базы данных MySQL
    private static final String PASSWORD = "King_help2002@"; // Пароль для пользователя

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
