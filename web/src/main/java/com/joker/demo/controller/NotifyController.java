package com.joker.demo.controller;


import com.joker.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotifyController {

    @Autowired
    EmailService emailService ;


    @RequestMapping("/email")
    public String send(@RequestParam("address") String address, @RequestParam("content") String content){
        return emailService.send(address, content);
    }



}
