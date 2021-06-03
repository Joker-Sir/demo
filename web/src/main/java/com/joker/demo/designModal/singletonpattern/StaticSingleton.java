package com.joker.demo.designModal.singletonpattern;

/**
 * 静态内部类
 * */
public class StaticSingleton {

    private StaticSingleton(){};

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder{
      private static StaticSingleton instance = new StaticSingleton();

    }


}
