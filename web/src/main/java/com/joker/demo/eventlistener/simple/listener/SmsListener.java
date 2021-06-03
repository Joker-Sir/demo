package com.joker.demo.eventlistener.simple.listener;

import com.joker.demo.eventlistener.simple.event.SmsEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class SmsListener implements ApplicationListener<SmsEvent> {


    /**
     * @Async 异步处理 1.出现异常不能传播给调用者 2.不能发布子event
     * */
    @Override
    @Async
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
