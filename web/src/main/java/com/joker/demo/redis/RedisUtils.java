package com.joker.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {

    @Autowired
    RedisTemplate redisTemplate;

    public void setString(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    public String getString(String key){
        Object o = redisTemplate.opsForValue().get(key);
        return (String)o;
    }



}
