package com.joker.demo.eventlistener.annotationbased.notifier;


import com.joker.demo.eventlistener.annotationbased.event.AlibabaEvent;
import com.joker.demo.eventlistener.annotationbased.event.WechatEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class WechatNotifier {

    /**
     * 发布一个事件作为另一个监听器的返回结果 调用链同样是同步阻塞的
     * */
    @EventListener
    public AlibabaEvent notifier(WechatEvent wechatEvent){
        System.out.println("监听到微信提醒");
        System.out.println("wechatEvent = " + wechatEvent);
        return new AlibabaEvent(this, wechatEvent.getContent());
    }

}
