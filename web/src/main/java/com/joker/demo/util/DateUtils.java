package com.joker.demo.util;

import org.aspectj.util.LangUtil;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;


public class DateUtils {

    final static DateTimeFormatter YYYYMMDDHHMMSS = DateTimeFormatter.ofPattern("YYYYMMddHHmmss");


    /**
     * 从日期中获取年月日时分秒的字符表示(24小时制)
     * @return String yyyymmddhhmmss形式
     * */
    public static String date2StringYYYYMMDDHHMMSS(Date date){
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        return YYYYMMDDHHMMSS.format(zonedDateTime);
    }

    /**
     * 两个日期之前的相差的天数 不考虑计算时分秒
     * 例如  2008-01-02 23:00:00 ~ 2008-01-03 01:00:00 相差一天
     * @return int
     * */
    public static int countDays(Date before, Date after){
        LangUtil.throwIaxIfNull(before,"before");
        LangUtil.throwIaxIfNull(after,"after");
        if (before.after(after)){
            Date temp = before;
            before = after;
            after = temp;
        }
        Instant beforeInstant = before.toInstant();
        Instant afterInstant = after.toInstant();
        LocalDate beforeZonedDate = beforeInstant.atZone(ZoneId.systemDefault()).toLocalDate();
        ZonedDateTime afterZonedDate = afterInstant.atZone(ZoneId.systemDefault());
        long b_days = beforeZonedDate.getLong(ChronoField.EPOCH_DAY);
        long a_days = afterZonedDate.getLong(ChronoField.EPOCH_DAY);
        return (int)(a_days - b_days);
    }



}
