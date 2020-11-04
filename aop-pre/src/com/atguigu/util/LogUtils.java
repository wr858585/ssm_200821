package com.atguigu.util;

import java.util.Arrays;

/**
 * @author oono
 * @date 2020 11 03
 */
public class LogUtils {

    public static void logBefore(String method, Object... args){
        System.out.println("method = " + method + ", args = " + Arrays.deepToString(args));
    }

    public static void logAfter(String method, Object... args){
        System.out.println("method = " + method + ", results = " + Arrays.deepToString(args));
    }

    public static void logAfterThrowing(String method, Object... args){
        System.out.println("method = " + method + ", exceptions = " + Arrays.deepToString(args));
    }

}
