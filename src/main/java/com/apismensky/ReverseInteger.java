package com.apismensky;

/**
 * Complexity: Easy
 * Reverse digits of an integer.
 * <p/>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {
    public static int reverse(int x) {
        long abs = Long.parseLong(new StringBuilder(Long.toString(Math.abs((long) x))).reverse().toString());
        if (abs > Integer.MAX_VALUE) abs = 0;
        return  x < 0 ? -(int)abs : (int)abs;
    }
}
