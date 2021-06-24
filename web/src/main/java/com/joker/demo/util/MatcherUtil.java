package com.joker.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="http://tool.chinaz.com/regex/">站长工具</a>
 * */
public class MatcherUtil {

    final static String REGEXP_EMAIL = "^\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}$";
    final static String REGEXP_TELEPHONE = "^1[3-9]{10}$";

    final static Pattern PATTERN_EMAIL = Pattern.compile(REGEXP_EMAIL);
    final static Pattern PATTERN_TELEPHONE = Pattern.compile(REGEXP_TELEPHONE);

    /**
     * 匹配Email
     * */
    public static boolean matchEmail(String str){
        Matcher matcher = PATTERN_EMAIL.matcher(str);
        boolean find = matcher.find();
        return find;
    }


    /**
     * 匹配手机号
     * */
    public static boolean matchTelephone(String str){
        Matcher matcher = PATTERN_TELEPHONE.matcher(str);
        boolean find = matcher.find();
        return find;
    }




}
