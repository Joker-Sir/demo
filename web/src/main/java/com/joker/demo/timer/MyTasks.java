package com.joker.demo.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyTasks {

    // @Scheduled(fixedDelay = 5000)
    // public void done(){
    //     try {
    //         Thread.sleep(1000);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    //     System.out.println(LocalDateTime.now() + " depend on completion time (run per 5 secs .In fact it's not the regular time)");
    // }

    // @Scheduled(fixedRate = 5000)
    public void done(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " depend on successive start time (run per 5 secs .Its time has the rhythm)");
    }





}
