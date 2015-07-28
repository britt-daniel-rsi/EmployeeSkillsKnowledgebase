package com.rsi.esk.util;

public class NumberUtils {
    public static Boolean hasLong(Long value) {
        if (value == null) {
            return false;
        }

        return value > 0;
    }
}
