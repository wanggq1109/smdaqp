package com.powerlong.common;

import org.apache.log4j.Logger;
import com.powerlong.common.DateUtility;
import com.powerlong.common.Validation;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Angus on 2015/5/30.
 */
public class Enterprise<A , B> extends LinkedHashMap implements Serializable {
    private static final Logger logger = Logger.getLogger(Enterprise.class);
    private static final StringBuffer _toString = new StringBuffer("\n\t----------------[ Enterprise Result ]----------------\n\t\t    KEY\t\t|\t VALUE\n\t-----------------------------------------------------");
    protected String enterprisename;

    public Enterprise() {
    }

    public Enterprise(String name) {
        this.enterprisename = name;
    }

    public Enterprise(Map entity) {
        super(entity);
    }

    public Enterprise(Enterprise entity) {
        super(entity);
    }

    public Enterprise(String enterprisename, Enterprise entity) {
        this.enterprisename = enterprisename;
        super.putAll(entity);
    }


    public Enterprise getEnterprise(String key) {
        return (Enterprise)this.get(key);
    }

    public Enterprise setMessage(String message) {
        this.set("message", message);
        return this;
    }

    public String getMessage() {
        return this.getString("message");
    }

    public Boolean getSuccess() {
        return Boolean.valueOf(this.getBoolean("success"));
    }

    public void setSuccess(Boolean success) {
        this.set("success", success);
    }

    public String getEnterpriseName() {
        return this.enterprisename;
    }

    public Enterprise setEnterpriseName(String name) {
        this.enterprisename = name;
        return this;
    }

    public Enterprise set(Object key, Object value) {
        super.put(key, value);
        return this;
    }

    public Long getLongId() {
        return this.getLong("id");
    }

    public Integer getIntId() {
        return this.getInt("id");
    }

    public Integer getInteger(Object key) {
        return this.getInt(key);
    }

    public Integer getInteger(Object key, Integer defaultInt) {
        try {
            return Integer.valueOf(this.get(key) + "");
        } catch (NumberFormatException var4) {
            return defaultInt;
        }
    }

    public Integer getGreaterid() {
        return this.getInt("greaterid");
    }

    public void setGreaterid(Integer greaterid) {
        this.set("greaterid", greaterid);
    }

    public Long getLessid() {
        return this.getLong("lessid");
    }

    public void setLessid(Long lessid) {
        this.set("lessid", lessid);
    }

    public Integer getInt(Object key) {
        Object value = this.get(key);
        if(value != null && !Validation.isEmpty(value.toString()).booleanValue() && !value.toString().equals("null")) {
            Class classType = value.getClass();
            if(classType == Integer.class) {
                return Integer.valueOf(((Integer)value).intValue());
            } else {
                if(classType == String.class) {
                    try {
                        String ex = value.toString().trim();
                        return Integer.valueOf(ex.equalsIgnoreCase("")?0:Integer.parseInt(ex));
                    } catch (Exception var5) {
                        logger.error(key + ":" + value + "，在转换为int型时异常", var5);
                    }
                } else {
                    if(classType == Short.class) {
                        return new Integer(((Short)value).shortValue());
                    }

                    if(classType == Long.class) {
                        return Integer.valueOf(((Long)value).intValue());
                    }

                    if(classType == BigDecimal.class) {
                        return Integer.valueOf(((BigDecimal)value).intValue());
                    }
                }

                return Integer.valueOf(0);
            }
        } else {
            return Integer.valueOf(0);
        }
    }

    public double getDouble(Object key, Double defaultDouble) {
        try {
            return Double.valueOf(this.get(key) + "").doubleValue();
        } catch (NumberFormatException var4) {
            return defaultDouble.doubleValue();
        }
    }

    public double getDouble(Object key) {
        Object value = this.get(key);
        if(value == null) {
            return 0.0D;
        } else {
            Class classType = value.getClass();
            if(classType == Double.class) {
                return ((Double)value).doubleValue();
            } else if(classType == Float.class) {
                try {
                    return (double)((Float)value).floatValue();
                } catch (Exception var5) {
                    return 0.0D;
                }
            } else if(classType != String.class && classType != BigDecimal.class) {
                return 0.0D;
            } else {
                try {
                    return Double.parseDouble(value.toString());
                } catch (Exception var6) {
                    return 0.0D;
                }
            }
        }
    }

    public float getFloat(Object key) {
        Object value = this.get(key);
        if(value == null) {
            return 0.0F;
        } else {
            Class classType = value.getClass();
            if(classType == Float.class) {
                return ((Float)value).floatValue();
            } else if(classType != String.class && classType != BigDecimal.class) {
                return 0.0F;
            } else {
                try {
                    return Float.parseFloat(value.toString());
                } catch (Exception var5) {
                    return 0.0F;
                }
            }
        }
    }

    public Long getLong(Object key) {
        Object value = this.get(key);
        if(value == null) {
            return Long.valueOf(0L);
        } else {
            Class classType = value.getClass();
            if(classType == Long.class) {
                return Long.valueOf(((Long)value).longValue());
            } else {
                if(classType == String.class) {
                    try {
                        String ex = value.toString().trim();
                        return Long.valueOf(ex.equalsIgnoreCase("")?0L:Long.parseLong(ex));
                    } catch (Exception var5) {
                        logger.error(key + ":" + value + "，在转换为Long型时异常", var5);
                    }
                } else {
                    if(classType == Integer.class) {
                        return Long.valueOf((long)((Integer)value).intValue());
                    }

                    if(classType == Short.class) {
                        return Long.valueOf((long)((Short)value).shortValue());
                    }

                    if(classType == BigDecimal.class) {
                        return Long.valueOf(((BigDecimal)value).longValue());
                    }
                }

                return Long.valueOf(0L);
            }
        }
    }

    public short getShort(Object key) {
        Object value = this.get(key);
        if(value == null) {
            return (short)0;
        } else {
            Class classType = value.getClass();
            if(classType == Short.class) {
                return ((Short)value).shortValue();
            } else if(classType == String.class) {
                try {
                    return Short.parseShort(value.toString());
                } catch (Exception var5) {
                    return (short)0;
                }
            } else {
                return (short)0;
            }
        }
    }

    public boolean getBoolean(Object key) {
        Object value = this.get(key);
        if(value == null) {
            return false;
        } else if(value.getClass().isInstance(new Boolean(true))) {
            return ((Boolean)value).booleanValue();
        } else if(!value.getClass().isInstance(new String())) {
            return false;
        } else {
            try {
                return value.toString().equalsIgnoreCase("true") || value.toString().equalsIgnoreCase("1");
            } catch (Exception var4) {
                return false;
            }
        }
    }

    public String getString(Object key) {
        Object value = this.get(key);

        try {
            return value == null?null:value.toString();
        } catch (RuntimeException var4) {
            var4.printStackTrace();
            return "EException:" + var4.getMessage();
        } catch (Exception var5) {
            var5.printStackTrace();
            return "EException:" + var5.getMessage();
        }
    }

    public String getString(Object key, String defaultValue) {
        String value = this.getString(key);
        return Validation.isNotEmpty(value).booleanValue()?value:defaultValue;
    }

    public String getStringByTrim(String key) {
        String value = this.getString(key);
        return value == null?"":value.trim();
    }

    public BigDecimal getBigDecimal(Object key) {
        Object value = this.get(key);
        if(value == null) {
            return new BigDecimal(0.0D);
        } else if(value instanceof BigDecimal) {
            return (BigDecimal)value;
        } else {
            try {
                return new BigDecimal(value.toString());
            } catch (Exception var4) {
                return BigDecimal.ZERO;
            }
        }
    }

    public Date getDate(String key) {
        Object value = this.get(key);

        try {
            if(value instanceof Date) {
                return (Date)value;
            } else if(value instanceof String) {
                String ex = ((String)value).trim();
                return !ex.equalsIgnoreCase("") && !ex.equals("null")?DateUtility.parse((String)value):null;
            } else {
                return null;
            }
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public Set getSet(Object key) {
        Object value = this.get(key);

        try {
            return value != null && value instanceof Set?(Set)value:null;
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }


    public Enterprise getEntity(String key) {
        Object value = this.get(key);
        return value instanceof List ?(Enterprise)((List)value).get(0):(Enterprise)value;
    }

    public List getList(String key) {
        Object value = this.get(key);
        if(null == value) {
            return null;
        } else if(value instanceof List) {
            return (List)value;
        } else {
            ArrayList values = new ArrayList();
            values.add(value);
            return values;
        }
    }

    public Date getStartDate() {
        Date startDate = DateUtility.parse(DateUtility.FORMAT_SIMPLE, this.getString("startDate"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime();
    }

    public Date getEndDate() {
        Date endDate = DateUtility.parse(DateUtility.FORMAT_SIMPLE, this.getString("endDate"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.set(10, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        return calendar.getTime();
    }

    public List<String> getIds() {
        return this.get("id") instanceof List?this.getList("id"):Arrays.asList(new Object[]{this.get("id")});
    }

    public String getStringByUtf8(String key) {
        try {
            return this.isEmpty(key)?this.getString(key):new String(this.getString(key).getBytes("ISO-8859-1"), "utf-8");
        } catch (Exception var3) {
            var3.printStackTrace();
            return this.getString(key);
        }
    }

    public String getStringByGbk(String key) {
        try {
            return this.isEmpty(key)?this.getString(key):new String(this.getString(key).getBytes("ISO-8859-1"), "gbk");
        } catch (Exception var3) {
            var3.printStackTrace();
            return this.getString(key);
        }
    }

    public Object getDefaultValue(String field, Object value) {
        return this.isEmpty(field)?value:this.get(field);
    }

    public String getStringByDefaultValue(String field, String value) {
        return this.isEmpty(field)?value:this.getString(field);
    }

    public boolean isEmpty(String field) {
        return Validation.isEmpty(this.get(field), new String[0]).booleanValue();
    }

    public boolean isNotEmpty(String field) {
        return !this.isEmpty(field);
    }

    public boolean isEmpty(String field, String eq) {
        return Validation.isEmpty(this.get(field), new String[]{eq}).booleanValue();
    }

    public boolean isNumber(String field) {
        return this.matches(field, "^[0-9\\.]*$");
    }

    public boolean isList(String field) {
        return this.get(field) instanceof List;
    }

    public boolean isMap(String field) {
        return this.get(field) instanceof Map;
    }

    public boolean isMobile(String field) {
        return Validation.isMobile(this.getString(field));
    }

    public boolean isGreaterThanZero(String field) {
        return this.getLong(field).longValue() > 0L;
    }

    public boolean equals(String key, Object value) {
        return null == this.get(key)?false:this.get(key).toString().equalsIgnoreCase(value == null?"":value.toString());
    }

    public boolean matches(String key, String regex) {
        return Validation.matches(this.get(key), regex);
    }

    public boolean isEmail(String key) {
        return Validation.isEmail(this.getString(key));
    }

    public boolean isUrl(String key) {
        return Validation.isUrl(this.getString(key));
    }

    public boolean isDate(String key) {
        return Validation.isDate(this.get(key));
    }


    public boolean equals(Object target) {
        if(this == target) {
            return true;
        } else {
            String targetClass = target.getClass().getName();
            String selfClass = this.getClass().getName();
            return target != null && target instanceof Enterprise?(targetClass.indexOf(selfClass) == -1 && this.getClass() != target.getClass()?false:this.getLong("id").equals(((Enterprise)target).getLong("id"))):false;
        }
    }

    public int hashCode() {
        int result = this.getInt("id").intValue();
        Iterator i$ = this.entrySet().iterator();

        while(i$.hasNext()) {
            Map.Entry entry = (Map.Entry)i$.next();
            if(null != entry.getKey() && null != entry.getValue() && !(entry.getValue() instanceof Enterprise) && !(entry.getValue() instanceof Collection)) {
                result = 31 * result + entry.getValue().hashCode();
            }
        }

        return result;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer(_toString);
        Iterator i$ = this.entrySet().iterator();

        while(true) {
            Map.Entry entry;
            do {
                if(!i$.hasNext()) {
                    return buf.append("\n\t-----------------------------------------------------").toString();
                }

                entry = (Map.Entry)i$.next();
            } while(null == entry.getKey());

            int fieldLength = ((String)entry.getKey()).toString().length();
            buf.append("\n\t" + (String)entry.getKey());

            for(int t = 0; t < 4 - Math.max(1, fieldLength / 4 + (fieldLength % 4 > 2?1:0)); ++t) {
                buf.append("\t");
            }

            if(entry.getValue() instanceof Enterprise) {
                buf.append("|        Enterprise -> " + entry.getClass());
            } else if(entry.getValue() instanceof Collection) {
                buf.append("|        Collection\t-> Collection");
            } else if(entry.getValue() instanceof Set) {
                buf.append("|        Set        -> Set");
            } else {
                buf.append("|        " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
    }
}
