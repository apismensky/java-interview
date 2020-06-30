package com.apismensky;

import java.util.HashMap;
import java.util.Map;

/**
 * Complexity: Easy
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * I = 1
 * V = 5
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000
 */
public class RomanToInteger {

    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input: " + s);
        }

        Map<Character, Integer> romanLiterals = new HashMap<>();
        romanLiterals.put('I', 1);
        romanLiterals.put('V', 5);
        romanLiterals.put('X', 10);
        romanLiterals.put('L', 50);
        romanLiterals.put('C', 100);
        romanLiterals.put('D', 500);
        romanLiterals.put('M', 1000);

        int result = 0;
        int i = 0;
        while (i < s.length()) {
            int value = romanLiterals.get(s.charAt(i));
            if (i < s.length() - 1) {
                int nextValue = romanLiterals.get(s.charAt(i + 1));
                if (nextValue > value) {
                    value = nextValue - value;
                    i++;
                }
            }
            result += value;
            i++;
        }
        return result;
    }
}
