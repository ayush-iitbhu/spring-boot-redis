package com.springBoot.redis.controller;

import com.springBoot.redis.dao.Product;
import com.springBoot.redis.output.BasicOutput;
import com.springBoot.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class RedisController {

    @Autowired
    private RedisService redisService;


    @PostMapping(value = "/uploadData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BasicOutput uploadProduct(@RequestBody Product product) {
        return redisService.upload(product);
    }


    @GetMapping(value = "/findAllProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> findAllProduct() {
        return redisService.findAll();
    }

}
