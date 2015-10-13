package com.powerlong.common;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Angus on 2015/5/30.
 */

public class Validation implements Serializable {
    public static final Pattern numberRegex = Pattern.compile("^[0-9]+$");
    public static final Pattern numberRegexAll = Pattern.compile("^[-\\+]?[\\d]*$");
    public static final Pattern onlyCharAndNumberRegex = Pattern.compile("^[a-zA-Z0-9]+([-_][a-zA-Z0-9]+)*$");
    public static final Pattern onlyCharAndNumberAndChRegex = Pattern.compile("^[a-zA-Z0-9一-龥\\s]+([-_][a-zA-Z0-9一-龥\\s]+)*$");
    public static final Pattern emailRegex = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.[a-z]+([-.][a-z]+)*$");
    public static final Pattern mobileRegex = Pattern.compile("^1\\d{10}$", 2);
    public static final Pattern imagePostfixRegex = Pattern.compile("\\.(?:GIF|JPG|JPEG|BMP|PNG)$", 2);
    public static final Pattern dateRegex = Pattern.compile("^\\d{4}(\\/|\\-|年)\\d{1,2}(\\/|\\-|月)\\d{1,2}.?(\\s\\d{1,2}.\\d{1,2}(.\\d{1,2})?)?$");
    public static final Pattern dateRegexSimple = Pattern.compile("^\\d{4}.\\d{1,2}.\\d{1,2}.?$");
    public static final Pattern urlRegex = Pattern.compile("^http:\\/\\/([\\w-]+(\\.[\\w-]+)+)+$");
    public static final Pattern tagRegex = Pattern.compile("^\\s*(([a-z0-9A-Z\\u4e00-\\u9fa5]{2,8})\\s+){0,2}([a-z0-9A-Z\\u4e00-\\u9fa5]{2,8}\\s*)?$");

    public Validation() {
    }

    public static Boolean isNull(Object object) {
        return Boolean.valueOf(object == null);
    }

    public static Boolean isEmpty(Integer number) {
        return Boolean.valueOf(isNull(number).booleanValue() || number.intValue() == 0 || number.intValue() < 1);
    }

    public static Boolean isEmpty(Long number) {
        return Boolean.valueOf(isNull(number).booleanValue() || number.longValue() == 0L || number.longValue() < 1L);
    }

    public static Boolean isEmpty(String string) {
        return Boolean.valueOf(isNull(string).booleanValue() || string.trim().equalsIgnoreCase(""));
    }

    public static Boolean isEmpty(List list) {
        return Boolean.valueOf(isNull(list).booleanValue() || list.size() < 1);
    }

    public static Boolean isEmpty(Object[] objects) {
        return Boolean.valueOf(isNull(objects).booleanValue() || objects.length < 1);
    }

    public static Boolean isEmpty(Collection objects) {
        return Boolean.valueOf(isNull(objects).booleanValue() || objects.isEmpty() || objects.size() == 1 && objects.iterator().next() == null);
    }

    public static Boolean isEmpty(Object object, String... equals) {
        return isNull(object).booleanValue()?Boolean.valueOf(true):(object instanceof String?Boolean.valueOf(isEmpty((String)object).booleanValue()?true:(equals.length == 0?false:((String)object).equalsIgnoreCase(equals[0]))):(object instanceof Long?isEmpty((Long)object):(object instanceof Collection?isEmpty((Collection)object):(object instanceof Integer?isEmpty((Integer)object):(object instanceof Object[]?isEmpty((Object[])((Object[])object)):(object instanceof Map ?Boolean.valueOf(((Map)object).isEmpty()):Boolean.valueOf(equals.length == 0?false:object.toString().equalsIgnoreCase(equals[0]))))))));
    }

    public static Boolean isNotEmpty(Object object) {
        return Boolean.valueOf(!isEmpty(object, new String[0]).booleanValue());
    }

    public static boolean onlyCharAndNumber(String str) {
        return onlyCharAndNumberRegex.matcher(str).find();
    }

    public static boolean onlyCharAndNumberAndCh(String str) {
        return onlyCharAndNumberAndChRegex.matcher(str).find();
    }

    public static boolean isEmail(String email) {
        return isEmpty(email).booleanValue()?false:emailRegex.matcher(email).find();
    }

    public static boolean isUrl(String url) {
        return isEmpty(url).booleanValue()?false:urlRegex.matcher(url).find();
    }

    public static boolean isMobile(String mobile) {
        return isEmpty(mobile).booleanValue()?false:mobileRegex.matcher(mobile).find();
    }

    public static boolean isImagefile(String filepath) {
        return isEmpty(filepath).booleanValue()?false:imagePostfixRegex.matcher(filepath).find();
    }

    public static boolean isDate(Object date) {
        return date instanceof Date ?true:(isEmpty(date, new String[0]).booleanValue()?false:dateRegex.matcher(date.toString()).find());
    }

    public static boolean isNumber(String number) {
        return isEmpty(number).booleanValue()?false:numberRegex.matcher(number).find();
    }

    public static boolean isNumberAll(String number) {
        return isEmpty(number).booleanValue()?false:numberRegexAll.matcher(number).find();
    }

    public static boolean tags(String tags) {
        return isEmpty(tags).booleanValue()?false:tagRegex.matcher(tags).find();
    }

    public static String findEmailName(String email) {
        return !isEmpty(email).booleanValue() && email.indexOf("@") != -1?email.substring(0, email.indexOf("@")):"";
    }

    public static boolean isLength(String str, int min, int max) {
        if(str == null) {
            return false;
        } else {
            int length = str.length();
            return length < min?false:length <= max;
        }
    }

    public static boolean isLength(String str, int length) {
        return str == null?false:str.length() == length;
    }

    public static boolean isGtLength(String str, int length) {
        return str == null?false:str.length() > length;
    }

    public static boolean isGtEqualLength(String str, int length) {
        return str == null?false:str.length() >= length;
    }

    public static boolean isLtEqualLength(String str, int length) {
        return str == null?false:str.length() <= length;
    }

    public static boolean isLtLength(String str, int length) {
        return str == null?false:str.length() < length;
    }

    public static boolean matches(Object value, String regex) {
        return !isEmpty(value, new String[0]).booleanValue() && !isEmpty(regex).booleanValue()?String.valueOf(value).trim().matches(regex):false;
    }

    public static void main(String[] args) {
        System.out.println(isNumberAll("-1.9"));
    }

    public static class Entity {
        private Map ignoreValidFields = new HashMap();
        private Map validFields = new HashMap();

        public Entity() {
        }

        public Validation.Entity addIgnoreValidFields(String... fields) {
            if(!this.validFields.isEmpty()) {
                throw new RuntimeException("不能既添加忽略字段又添加有效字段！");
            } else {
                String[] arr$ = fields;
                int len$ = fields.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    String field = arr$[i$];
                    this.ignoreValidFields.put(field, Boolean.valueOf(true));
                }

                return this;
            }
        }

        public Validation.Entity addValidFields(String... fields) {
            if(!this.ignoreValidFields.isEmpty()) {
                throw new RuntimeException("不能既添加忽略字段又添加有效字段！");
            } else {
                String[] arr$ = fields;
                int len$ = fields.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    String field = arr$[i$];
                    this.validFields.put(field, Boolean.valueOf(true));
                }

                return this;
            }
        }

        protected boolean isNeedValidField(String field) {
            return !this.validFields.isEmpty()?this.validFields.containsKey(field):!this.ignoreValidFields.containsKey(field);
        }

        public Enterprise validation() {
            Enterprise errors = new Enterprise();
            return errors;
        }
    }
}
