package com.joker.demo.designModal.facotry.simpleFactory;


import com.alibaba.druid.util.StringUtils;


public class PhoneFactory {

    public static Phone produce(String type){
        if (StringUtils.equals("huawei",type)){
            return new HuaweiPhone();
        }else if (StringUtils.equals("iphone",type)){
            return new Iphone();
        }
        return null;
    }


}
