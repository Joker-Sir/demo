package com.joker.demo.designModal.facotry.abstractFactory;


import com.joker.demo.designModal.facotry.simpleFactory.Phone;

public abstract class AbstractFactory {

    public abstract Phone producePhone(String type);

    public abstract Pad producePad(String type);

}
