package com.joker.demo.designModal.facotry.simpleFactory;


/**
 * 抽象出产品
 * 通过传入不同的类型 利用工厂生产不同的产品
 * 简单直接
 * 不易扩展
 * https://www.runoob.com/design-pattern/factory-pattern.html
 * */
public class Test {

    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        factory.produce("huawei");
    }

}
