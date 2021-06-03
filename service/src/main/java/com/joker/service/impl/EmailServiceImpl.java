package com.joker.service.impl;

import com.joker.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public String send(String address, String content) {
        return "send " + content + " to " + address;
    }
}
