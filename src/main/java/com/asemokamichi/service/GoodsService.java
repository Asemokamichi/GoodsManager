package com.asemokamichi.service;

import com.asemokamichi.entity.Product;

import java.util.List;

public interface GoodsService {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
}
