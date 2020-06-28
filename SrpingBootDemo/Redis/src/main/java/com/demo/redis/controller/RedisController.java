package com.demo.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis集成测试
 *
 * @author LiaNg
 * @date 2020/6/22 11:49
 */
@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/getKey")
    public String getKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @GetMapping("/putKey")
    public String putKey(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return "success";
    }
}
