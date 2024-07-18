package com.asemokamichi.service;

import com.asemokamichi.entity.Product;
import com.asemokamichi.repository.GoodsRepository;

import javax.inject.Inject;
import java.util.List;

public class GoodsService {
    @Inject
    private GoodsRepository goodsRepository;

    public List<Product> findAll(){
        return goodsRepository.findAll();
    }


    public void save(Product product){
        goodsRepository.save(product);
    }
}
