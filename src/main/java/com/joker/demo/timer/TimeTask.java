package com.joker.demo.timer;


import com.joker.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class TimeTask {

    @Autowired
    UserService service;


    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());


    @Scheduled(cron = "0/30 * * * * ?")
    public void timer(){
        for (int i = 0; i < 50; i++) {

            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    service.findAllUsers();
                    try {

                        Thread.sleep(5000L);
                    }catch (Exception e){}
                    System.out.println(new Date());
                }
            });
        }
    }


    static Integer[] array = {3,1,5,7,2,8,4,9};

    static void sort(){
        int temp, minIndex;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1 ; j < array.length; j++) {
                if (array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

    }

}
