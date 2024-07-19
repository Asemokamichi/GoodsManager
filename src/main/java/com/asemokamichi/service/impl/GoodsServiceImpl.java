package com.asemokamichi.service.impl;

import com.asemokamichi.entity.Product;
import com.asemokamichi.repository.GoodsRepository;
import com.asemokamichi.repository.impl.GoodsRepositoryImpl;
import com.asemokamichi.service.GoodsService;

import javax.transaction.Transactional;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private final GoodsRepository goodsRepository = new GoodsRepositoryImpl();

    @Transactional
    public List<Product> findAll() {
        return goodsRepository.findAll();
    }

    @Transactional
    public Product findById(Long id) {
        return goodsRepository.findById(id);
    }
    @Transactional
    public void save(Product product) {
        if (product.getName().isEmpty() || product.getPrice()==0)
            throw new RuntimeException("The request text is incorrect. Please provide a valid product name or price.");

        goodsRepository.save(product);
    }
}
