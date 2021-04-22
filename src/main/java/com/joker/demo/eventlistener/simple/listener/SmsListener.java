package com.joker.demo.eventlistener.simple.listener;

import com.joker.demo.eventlistener.simple.event.SmsEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SmsListener implements ApplicationListener<SmsEvent> {


    @Override
    public void onApplicationEvent(SmsEvent smsEvent) {
        System.out.println("监听到发送短信事件");
        //这里睡眠会阻塞其他的请求，监听默认是同步的。
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("smsEvent = " + smsEvent);
    }
}
