package com.powerlong.common;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Created by Angus on 2015/5/30.
 */

public class StringUtils extends org.apache.commons.lang3.StringUtils {
    public StringUtils() {
    }

    public static String numberFormat(BigDecimal number) {
        if(number == null) {
            return "0";
        } else {
            NumberFormat nf = NumberFormat.getInstance();
            return nf.format(number);
        }
    }

    public static String numberFormat(Object number) {
        if(number == null) {
            return "0";
        } else {
            NumberFormat nf = NumberFormat.getInstance();
            return nf.format(number);
        }
    }
    
    public static boolean isEmpty (Object input) {
    	 if (input == null || input == "") {
    		 return true;
    	 } else {
    		 return false;
    	 }
    }
}
