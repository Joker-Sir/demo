package com.joker.demo.designModal.singletonPattern;

/**
 * 懒汉式单例模式 lazy loading
 * */
public class LHanSingleton {

    private static LHanSingleton instance;

    private LHanSingleton(){

    }

    // public static LHanSingleton getInstance() {
    public static synchronized LHanSingleton getInstance() {
        if (instance == null){
            instance = new LHanSingleton();
        }
        return instance;
    }
}
