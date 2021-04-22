package com.joker.demo.service.impl;

import com.joker.demo.eventlistener.annotationbased.event.WechatEvent;
import com.joker.demo.service.NotifierService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class NotifierServiceImpl implements NotifierService, ApplicationEventPublisherAware {

    ApplicationEventPublisher publisher;

    @Override
    public void notify(String content) {
        publisher.publishEvent(new WechatEvent(this,content));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
