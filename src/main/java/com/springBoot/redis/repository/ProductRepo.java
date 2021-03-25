package com.springBoot.redis.repository;

import com.springBoot.redis.dao.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo {

    @Autowired
    private RedisTemplate redisTemplate;

    public void saveProduct(Product product){
        redisTemplate.opsForHash().put("Product", product.getId(), product);
    }

    public List<Product> findAllProduct(){
       return redisTemplate.opsForHash().values("Product");
    }
}
