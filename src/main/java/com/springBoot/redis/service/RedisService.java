package com.springBoot.redis.service;

import com.springBoot.redis.dao.Product;
import com.springBoot.redis.output.BasicOutput;
import com.springBoot.redis.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {

    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private ProductRepo productRepo;

    public BasicOutput upload(Product product) {

        BasicOutput basicOutput = new BasicOutput();

        try {
            productRepo.saveProduct(product);
        }catch (Exception ex){
            logger.error("Exception during upload in Redis " + ex);
            basicOutput.setMessage("FAILURE");
            return basicOutput;
        }
        basicOutput.setMessage("SUCCESS");
        return basicOutput;
    }

    public List<Product> findAll() {
        try {
           return productRepo.findAllProduct();
        }catch (Exception ex){
            logger.error("Exception during fetch data from Redis " + ex);
        }
        return null;
    }
}
