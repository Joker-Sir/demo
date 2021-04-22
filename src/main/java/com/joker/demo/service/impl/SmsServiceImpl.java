package com.joker.demo.service.impl;

import com.joker.demo.eventlistener.simple.event.SmsEvent;
import com.joker.demo.service.SmsService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService, ApplicationEventPublisherAware {

    ApplicationEventPublisher publisher;

    @Override
    public void sendSms(String telephone) {
        publisher.publishEvent(new SmsEvent(this, telephone, "sos"));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
