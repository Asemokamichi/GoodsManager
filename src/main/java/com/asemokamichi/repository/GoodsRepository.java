package com.asemokamichi.repository;

import com.asemokamichi.entity.Product;

import java.util.List;

public interface GoodsRepository {

    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);
}
