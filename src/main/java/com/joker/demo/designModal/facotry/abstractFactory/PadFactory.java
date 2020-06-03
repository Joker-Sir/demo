package com.joker.demo.designModal.facotry.abstractFactory;

import com.alibaba.druid.util.StringUtils;
import com.joker.demo.designModal.facotry.simpleFactory.Phone;

public class PadFactory extends AbstractFactory {

    @Override
    public Phone producePhone(String type) {
        return null;
    }

    @Override
    public Pad producePad(String type) {
        if (StringUtils.equals("huawei",type)){
            return new HuaweiPad();
        }else if (StringUtils.equals("apple",type)){
            return new Ipad();
        }
        return null;
    }
}
