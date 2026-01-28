package com.knownniu.epay.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class php_md5 {
    public static String md5(String input) {
        try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(input.getBytes(StandardCharsets.UTF_8));

        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            String s = Integer.toHexString(b & 0xff);
            if (s.length() == 1) {
                hex.append('0');
            }
            hex.append(s);
        }
        return hex.toString(); // 小写
        } catch (Exception e) {
            throw new RuntimeException("MD5 sign error", e);
        }
    }
}