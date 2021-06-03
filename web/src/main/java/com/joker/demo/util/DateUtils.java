package com.joker.demo.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DateUtils {

    final static DateTimeFormatter YYYYMMDDHHMMSS = DateTimeFormatter.ofPattern("YYYYMMddHHmmss");

    public static String date2StringYYYYMMDDHHMMSS(Date date){
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        return YYYYMMDDHHMMSS.format(zonedDateTime);
    }



}
