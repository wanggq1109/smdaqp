package com.powerlong.common;

import com.powerlong.model.WifiMaxGust;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2015/5/6.
 */
public class Util {

    /**
     * 获取JSON VIEW
     * @param data
     * @return
     */
    public static View getJsonView(Map<String, ?> data){
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        view.setAttributesMap(data);
        return view;
    }

    /**
     * 计算总时长
     * @param wifiMaxGusts
     * @return
     */
    public static long getCountTime(List<WifiMaxGust> wifiMaxGusts){
        long count =1;
        if(wifiMaxGusts!=null&&wifiMaxGusts.size()>0){
            for(int i=0;i<wifiMaxGusts.size();i++){
                count += wifiMaxGusts.get(i).getResidenceTime();
            }
        }
        return count;
    }

    /**
     * 获取年龄
     * @param birthday
     * @return
     * @throws Exception
     */
    public static String getAge(String birthday) throws Exception{
        String year = null;
        if(StringUtils.isNotBlank(birthday)) {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Date mydate = myFormatter.parse(birthday);
            long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000) + 1;
            year = new java.text.DecimalFormat("#00").format(day / 365f);
        }
        return year;
    }

    /**
     * 获取上一个月
     * @param date
     * @return
     * @throws Exception
     */
    public static String getMonth(String date,String type) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date d = format.parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        if("1".equals(type)) {//下一个月
            c.add(c.MONTH, 1);
        }else if("-1".equals(type)){//上一个月
            c.add(c.MONTH,-1);
        }
        Date temp_date = c.getTime();
        return date = format.format(temp_date);
    }

}
