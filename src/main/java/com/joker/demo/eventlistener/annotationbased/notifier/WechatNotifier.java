package com.joker.demo.eventlistener.annotationbased.notifier;


import com.joker.demo.eventlistener.annotationbased.event.WechatEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class WechatNotifier {

    @EventListener
    public void notifier(WechatEvent wechatEvent){
        System.out.println("监听到微信提醒");
        System.out.println("wechatEvent = " + wechatEvent);
    }

}
