package com.joker.demo.designModal.singletonpattern;

/**
 * 饿汉式单例模式
 * 初始化就loading 浪费内存
 * */
public class EHanSingleton {

    private static EHanSingleton instance = new EHanSingleton();

    private EHanSingleton(){

    }

    public static EHanSingleton getInstance() {
        return instance;
    }
}
