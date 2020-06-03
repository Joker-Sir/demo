package com.joker.demo.designModal.facotry.abstractFactory;


import com.alibaba.druid.util.StringUtils;
import com.joker.demo.designModal.facotry.simpleFactory.HuaweiPhone;
import com.joker.demo.designModal.facotry.simpleFactory.Iphone;
import com.joker.demo.designModal.facotry.simpleFactory.Phone;

public class PhoneFactory extends AbstractFactory{

    @Override
    public Phone producePhone(String type) {
        if (StringUtils.equals("huawei",type)){
            return new HuaweiPhone();
        }else if (StringUtils.equals("apple",type)){
            return new Iphone();
        }
        return null;
    }

    @Override
    public Pad producePad(String type) {
        return null;
    }
}
