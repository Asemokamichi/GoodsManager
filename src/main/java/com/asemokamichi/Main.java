package com.asemokamichi;

import com.asemokamichi.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/warehouse_db"; // URL для подключения к MySQL
    private static final String USER = "root"; // Пользователь базы данных MySQL
    private static final String PASSWORD = "King_help2002@"; // Пароль для пользователя

    public static void main(String[] args) throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet;
            String query = "select * from products";
            List<Product> products = new ArrayList<>();

            resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getLong("price"));
                products.add(product);
            }

            for (Product product : products) System.out.println(product);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
