package com.powerlong.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

/**
 * Created by Angus on 2015/5/30.
 */

public class DateUtility {
    public static final SimpleDateFormat FORMAT_SIMPLE = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat FORMAT_SIMPLE_CN = new SimpleDateFormat("yyyy年MM月dd日");
    public static final SimpleDateFormat FORMAT_FULL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat FORMAT_FULL_CN = new SimpleDateFormat("yyyy年MM月dd hh小时mm分钟ss秒");
    public static final SimpleDateFormat FORMAT_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat FORMAT_HH_MM_SS = new SimpleDateFormat("hh:mm:ss");
    public static final SimpleDateFormat FORMAT_HH_MM = new SimpleDateFormat("HH:mm");

    public DateUtility() {
    }

    public static String getGMTString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        dateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return FORMAT_FULL.format(date);
    }

    public static String format(SimpleDateFormat format, Date date) {
        try {
            return format.format(date);
        } catch (Exception var3) {
            throw new BaseRuntimeException("日期到字符的转换错误:" + format + ":" + date, var3.getMessage());
        }
    }

    public static String format(String format, Date date) {
        return format(new SimpleDateFormat(format), date);
    }

    public static Date add(Date date, int field, int value) {
        Calendar calendar = Calendar.getInstance();
        if(null != date) {
            calendar.setTime(date);
        }

        calendar.add(field, value);
        return calendar.getTime();
    }

    public static Date add(int field, int value) {
        return add((Date)null, field, value);
    }

    public static Date set(Date date, int field, int value) {
        Calendar calendar = Calendar.getInstance();
        if(null != date) {
            calendar.setTime(date);
        }

        calendar.set(field, value);
        return date;
    }

    public static Date set(int field, int value) {
        return add((Date)null, field, value);
    }

    public static Date parse(SimpleDateFormat format, String date) {
        try {
            return format.parse(date);
        } catch (Exception var3) {
            throw new BaseRuntimeException("字符到日期的转换错误:" + format + ":" + date, var3.getMessage());
        }
    }

    public static Date parse(String format, String date) {
        return parse(new SimpleDateFormat(format), date);
    }

    public static Date clearTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(14, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(11, 0);
        return calendar.getTime();
    }

    public static Date parse(String date) {
        return Validation.dateRegexSimple.matcher(date).find()?(date.contains("年")?parse(FORMAT_SIMPLE_CN, date):parse(FORMAT_SIMPLE, date)):(date.contains("年")?parse(FORMAT_FULL_CN, date):parse(FORMAT_FULL, date));
    }

    public static Long getByteSize(String size) {
        String nuit = size.substring(size.length() - 1, size.length()).toUpperCase();
        String num;
        if(nuit.equalsIgnoreCase("K")) {
            num = size.substring(0, size.length() - 1);
            return Long.valueOf(Long.parseLong(num) * 1024L);
        } else if(nuit.equalsIgnoreCase("M")) {
            num = size.substring(0, size.length() - 1);
            return Long.valueOf(Long.parseLong(num) * 1024L * 1024L);
        } else {
            return Long.valueOf(Long.parseLong(size));
        }
    }

    public static String getByteCNM(Long size) {
        return size.longValue() != 0L && size.longValue() >= 1024L?(size.longValue() / 1024L < 1024L?size.longValue() / 1024L + "K":(size.longValue() / 1048576L < 1024L?size.longValue() / 1048576L + "M":size.longValue() / 1073741824L + "G")):"1K";
    }

    public static Date getDay(Integer dayNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, dayNumber.intValue());
        calendar.set(10, 12);
        calendar.set(12, 59);
        calendar.set(13, 59);
        return calendar.getTime();
    }

    public static String getTimeDifference(String date) {
        try {
            return getTimeDifference((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(date));
        } catch (ParseException var2) {
            var2.printStackTrace();
            return "日期错误";
        }
    }

    public static String getTimeDifference(Date date) {
        long timer = (new Date()).getTime() - date.getTime();
        return timer / 365L / 24L / 60L / 60L / 1000L > 0L?timer / 365L / 24L / 60L / 60L / 1000L + "年":(timer / 30L / 24L / 60L / 60L / 1000L > 0L?timer / 30L / 24L / 60L / 60L / 1000L + "个月":(timer / 24L / 60L / 60L / 1000L == 1L?"昨天":(timer / 24L / 60L / 60L / 1000L == 2L?"前天":(timer / 24L / 60L / 60L / 1000L > 2L?timer / 24L / 60L / 60L / 1000L + "天":(timer / 60L / 60L / 1000L > 0L?timer / 60L / 60L / 1000L + "小时":(timer / 60L / 1000L > 0L?timer / 60L / 1000L + "分钟":"1分钟"))))));
    }
    
    public static Date getDateByTimeMillis(long timeMillis) {
    	Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timeMillis);
		return calendar.getTime();
    }

    public static void main(String[] args) {
        Date t1 = parse("1987-04-22");
        Date t2 = parse(format(FORMAT_SIMPLE, new Date()));
        System.out.println(t1.getTime() > t2.getTime());
        System.out.println(clearTime(new Date()));
    }
}
