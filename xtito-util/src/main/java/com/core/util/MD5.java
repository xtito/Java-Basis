package com.core.util;

import java.security.MessageDigest;

/**
 * MD5方式加密
 * <p/>
 * Title:MD5.java
 * Author:cjf
 * Date:2015/9/16
 */
public final class MD5 {

    private static final char HEXDIGITS[] = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 转换MD5
     *
     * @param string
     * @return
     */
    public static String encrypt(String string) {

        if (StringHelper.isNotNull(string)) {
            try {
                byte[] strTemp = string.getBytes();
                MessageDigest mdTemp = MessageDigest.getInstance("MD5");
                mdTemp.update(strTemp);
                byte[] md = mdTemp.digest();
                int j = md.length;
                char str[] = new char[j * 2];
                int k = 0;
                for (int i = 0; i < j; i++) {
                    byte byte0 = md[i];
                    str[k++] = HEXDIGITS[byte0 >>> 4 & 0xf];
                    str[k++] = HEXDIGITS[byte0 & 0xf];
                }
                return new String(str);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
