package com.joker.demo.designModal.singletonpattern;


/***
 * 双重检测锁
 * */
public class DCLSingleton {
    //volatile 防止重排序 可能出现实例未初始化
    private volatile static DCLSingleton instance;

    private DCLSingleton(){};

    public static DCLSingleton getInstance() {
        if (instance == null){
            synchronized (DCLSingleton.class){
                if (instance == null){
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }

}
