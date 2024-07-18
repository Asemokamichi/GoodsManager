package com.asemokamichi.repository;

import com.asemokamichi.config.DatabaseConfig;
import com.asemokamichi.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsRepository {
    private DatabaseConfig databaseConfig;

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        String query = "select * from products";

        try (Connection connection = databaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("product_name"));
                product.setPrice(resultSet.getLong("price"));
                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public void save(Product product) {
        String query = "insert into products (name, price) values (?, ?)";

        try (Connection connection = databaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}