package com.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 创 建 者: root
 * 创建时间: 2016-03-29
 */
public class UnicodeUtil {
    public UnicodeUtil() {
        super();
    }

    /**
     * 转化为unicode编码
     */
    public static String toEncoding(String str) {
        char[] bytes = str.toCharArray();
        String unicodeBytes = "";
        for (char aByte : bytes) {
            String hex = Integer.toHexString(aByte);
            if (hex.length() <= 2) {
                hex = "00" + hex;
            }
            unicodeBytes = unicodeBytes + "\\u" + hex;
        }
        return unicodeBytes;
    }

    /**
     * 解码unicode编码
     */
    public static String deEncoding(String str) {
        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder();
        while (start > -1) {
            end = str.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = str.substring(start + 2, str.length());
            } else {
                charStr = str.substring(start + 2, end);
            }
            char letter = (char)Integer.parseInt(charStr,16);
            sb.append(Character.toString((letter)));
            start = end;
        }
        return sb.toString();
    }


    /**
     * 判断字符串是否为中文
     */
    public static boolean isChinese(String str){
        boolean isChinese = false;
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            isChinese = true;
        }
        return isChinese;
    }

    /**
     * 判断是否为大于等于0的数字
     */
    public static boolean isNum(String str){
        Pattern pattern = Pattern.compile("[0-9]+([.][0-9]+)?");
        return pattern.matcher(str).matches();
    }

}
