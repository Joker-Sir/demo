package com.joker.demo.eventlistener.annotationbased.notifier;

import com.joker.demo.eventlistener.annotationbased.event.AlibabaEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AlibabaNotifier {

    @EventListener
    public void notifier(AlibabaEvent alibabaEvent){
        System.out.println("监听到阿里提醒");
        System.out.println("alibabaEvent = " + alibabaEvent);
    }

}
