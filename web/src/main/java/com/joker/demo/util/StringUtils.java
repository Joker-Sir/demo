package com.joker.demo.util;

import java.util.Optional;

public class StringUtils {

    /**
     * check if exists an empty string.
     * @return true if All elements are not empty, else is false.
     *
     * */
    public static boolean isAllNotEmpty(String... str){
        if (null == str)
            return false;
        for (int i = 0; i < str.length; i++) {
            if (org.springframework.util.StringUtils.isEmpty(str[i])){
                return false;
            }
        }
        return true;
    }


}
