package com.joker.demo.eventlistener.annotationbased.event;

import org.springframework.context.ApplicationEvent;

public class WechatEvent extends ApplicationEvent {

    String content;

    public WechatEvent(Object source, String content) {
        super(source);
        this.content = content;
    }

    @Override
    public String toString() {
        return "WechatEvent{" +
                "content='" + content + '\'' +
                ", source=" + source +
                '}';
    }
}
