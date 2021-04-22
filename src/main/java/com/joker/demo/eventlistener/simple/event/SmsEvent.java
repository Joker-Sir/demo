package com.joker.demo.eventlistener.simple.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class SmsEvent extends ApplicationEvent {

    String telephne;
    String content;

    public SmsEvent(Object source, String telephne, String content) {
        super(source);
        this.telephne = telephne;
        this.content = content;
    }

    @Override
    public String toString() {
        return "SmsEvent{" +
                "telephne='" + telephne + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
