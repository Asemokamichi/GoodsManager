package com.asemokamichi.repository;

import com.asemokamichi.entity.Product;

import java.util.List;

public interface GoodsRepository {

    List<Product> findAll();

    void save(Product product);
}
