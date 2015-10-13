package com.powerlong.common;

/**
 * Created by Angus on 2015/5/30.
 */

public class XssHtmlUtility {
    public XssHtmlUtility() {
    }

    public static String encode(String value) {
        if(null != value) {
            char[] content = new char[value.length()];
            value.getChars(0, value.length(), content, 0);
            StringBuilder result = new StringBuilder(content.length + 50);

            for(int i = 0; i < content.length; ++i) {
                switch(content[i]) {
                    case '\"':
                        result.append("&quot;");
                        break;
                    case '&':
                        result.append("&amp;");
                        break;
                    case '<':
                        result.append("&lt;");
                        break;
                    case '>':
                        result.append("&gt;");
                        break;
                    default:
                        result.append(content[i]);
                }
            }

            return result.toString();
        } else {
            return null;
        }
    }

    public static String decode(String value) {
        return null != value?value.replace("&lt;", "<").replace("&gt;", ">").replace("&;", "&amp;").replace("&quot;", "\"").replace("&amp;", "&"):value;
    }

    public static String filter(String value) {
        return encode(value);
    }
}
