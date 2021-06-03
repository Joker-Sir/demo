package com.joker.demo.eventlistener.annotationbased.event;

import org.springframework.context.ApplicationEvent;

public class AlibabaEvent extends ApplicationEvent {

    String content;

    public AlibabaEvent(Object source,String content) {
        super(source);
        this.content = content;
    }

    @Override
    public String toString() {
        return "AlibabaEvent{" +
                "content='" + content + '\'' +
                ", source=" + source +
                '}';
    }
}
