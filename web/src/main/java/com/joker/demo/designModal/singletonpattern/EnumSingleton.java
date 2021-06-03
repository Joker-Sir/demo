package com.joker.demo.designModal.singletonpattern;

/**
 * 枚举类
 * */
public enum EnumSingleton {

    INSTANCE;

    public String method() {
        return "单例方法";
    }

}
