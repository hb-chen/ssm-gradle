package com.hobo.common.utils;

/**
 * Created by Steven on 2017/3/7.
 */
public class Exceptions {
    public static RuntimeException unchecked(Throwable ex) {
        if (ex instanceof RuntimeException) {
            return (RuntimeException) ex;
        } else {
            return new RuntimeException(ex);
        }
    }
}
