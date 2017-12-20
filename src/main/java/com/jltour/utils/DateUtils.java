package com.jltour.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    public static final String ORDER = "yyyyMMddHHmmss";
    public static final String ymd = "yyyy-wMM-dd";

    public static Date thirtyMinutesFromNow() {
        return howMinutesFromDate(30, new Date());
    }

    //用于
    public static Date oneMinutesFromNow() {
        return howMinutesFromDate(1, new Date());
    }

    public static Date fifteenMinutes() {
        return howMinutesFromDate(15, new Date());
    }

    public static Date sixtyMinutesFromNow() {
        return howMinutesFromDate(60, new Date());
    }

    public static Date howMinutesFromDate(Integer minutes, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }


    public static String parseDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date=null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getToday(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,0);
        return cal.getTime();
    }

    public static Date getTodayStartTime(){
        Date date=getToday();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        //	calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getTodayEndTime(){
        Date date=getToday();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        //	calendar.set(Calendar.MILLISECOND,999);
        return calendar.getTime();
    }

}
