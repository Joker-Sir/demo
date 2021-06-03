package com.joker.demo.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RedisUtilsTest {

    @Autowired
    RedisUtils redisUtils;

    @Test
    void setString() {
        redisUtils.setString("hello","world");
    }

    @Test
    void getString() {
        System.out.println("redisUtils.getString(\"hello\") = " + redisUtils.getString("hello"));
    }
}