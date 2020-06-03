package com.joker.demo.designModal.facotry.abstractFactory;

/**
 * 抽象出一个抽象工厂，其定义了产品的生产接口，但不负责具体的产品，将生产任务交给不同的派生类工厂
 * https://www.runoob.com/design-pattern/abstract-factory-pattern.html
 * */
public class Test {

    public static void main(String[] args) {

        AbstractFactory phone = FactoryProducer.getFactory("phone");
        phone.producePhone("huawei");

    }

}
