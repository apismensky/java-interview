package com.octanner;

public class ReverseString {
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i=0; i<chars.length;i++) {
            reversed[chars.length - i -1] = chars[i];
        }
        return new String(reversed);
    }
}
