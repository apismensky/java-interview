package com.apismensky;

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

    private enum RomanLiteral {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);
        private int v;
        private RomanLiteral(int v) {
            this.v = v;
        }

        static int getValue(char rl) {
            for (RomanLiteral each: RomanLiteral.values()) {
                if (each.name().equals("" + rl)) {
                    return each.v;
                }
            }
            throw new IllegalArgumentException("Illegal char " + rl);
        }
    }

    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input: " + s);
        }
        int result = 0;
        int i = 0;
        while (i<s.length()) {
            int value = RomanLiteral.getValue(s.charAt(i));
            if (i<s.length()-1) {
                int nextValue = RomanLiteral.getValue(s.charAt(i + 1));
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
