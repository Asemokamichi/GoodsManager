package com.asemokamichi.repository.impl;

import com.asemokamichi.config.DatabaseConnection;
import com.asemokamichi.entity.Product;
import com.asemokamichi.repository.GoodsRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsRepositoryImpl implements GoodsRepository {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Connection connection = databaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getLong("price"));
                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public void save(Product product) {
        String query = "INSERT INTO products (name, price) VALUES (?, ?)";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}