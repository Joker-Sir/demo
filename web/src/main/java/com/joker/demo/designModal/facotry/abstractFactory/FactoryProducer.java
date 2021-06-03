package com.joker.demo.designModal.facotry.abstractFactory;

import com.alibaba.druid.util.StringUtils;

public class FactoryProducer {

    public static AbstractFactory getFactory(String type){
        if (StringUtils.equals("phone",type)){
            return new PhoneFactory();
        }else if (StringUtils.equals("pad",type)){
            return new PadFactory();
        }
        return null;
    }
}
