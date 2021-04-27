package com.hans.common;

/**
 * @author hanxin
 * @description 常用工具类
 * @date 2019/3/12
 */
public class Utils {

    public static class Str {
        public static boolean isempty(String str) {
            return str == null || str.trim().equals("") || str.trim().equalsIgnoreCase("null");
        }
    }
}
