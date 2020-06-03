package com.joker.demo.designModal.singletonPattern;

/**
 * 枚举类
 * */
public enum EnumSingleton {

    INSTANCE;

    public String method() {
        return "单例方法";
    }

}
