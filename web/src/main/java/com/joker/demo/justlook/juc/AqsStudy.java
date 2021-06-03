package com.joker.demo.justlook.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 队列同步器 AbstractQueuedSynchronizer
 *
 * */
public class AqsStudy {

    Lock lock = new ReentrantLock();

    /**
     * 范式用法
     * */
    public void method(){
        lock.tryLock();
        try {
        //....
        }finally {
            lock.unlock();
        }
    }


}
