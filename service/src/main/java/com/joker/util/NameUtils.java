package com.joker.util;


import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class NameUtils {

    /**
     * 获取32位UUID字符串（不带‘-’）
     * */
    public static String uuid32(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString().replaceAll("-", "");
        return str;
    }

    /**
     * 指定名称后带上时间戳
     * @param name 名称
     * */
    public static String withTimeMillions(String name){
        long timeMillis = System.currentTimeMillis();
        String millionStr = String.valueOf(timeMillis);
        if (StringUtils.isEmpty(name)){
            return millionStr;
        }
        return name.concat(millionStr);
    }

    /**
     * 指定名称后带上年月日
     * @param name 名称
     * */
    public static String withYMd(String name){
        String format = Instant.now().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ISO_LOCAL_DATE);
        String str = format.replaceAll("-", "");
        if (StringUtils.isEmpty(name)){
            return str;
        }
        return name.concat(str);
    }

    /**
     * 指定名称后带上年月日时分秒
     * @param name 名称
     *
     * */
    public static String withYMdHms(String name){
        String format = Instant.now().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        if (StringUtils.isEmpty(name)){
            return format;
        }
        return name.concat(format);
    }





}
