package com.joker.demo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @Autowired
    HelloController helloController;

    @Test
    public void sayHello(){
        String joker = helloController.sayHello("joker");
        Assertions.assertNotNull(joker);
        System.out.println("joker = " + joker);
    }


    @Test
    void sendSms() {
        String sms = helloController.sendSms("110");
        String none = helloController.sendSms("119");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("发送成功", sms);
    }

    @Test
    void testNotify() {
        String notify = helloController.notify("warning");
        Assertions.assertEquals("发送成功", notify);
    }
}