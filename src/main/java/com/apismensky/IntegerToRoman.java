package com.apismensky;

/**
 * Complexity: Medium
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * I = 1
 * V = 5
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000
 */
public class IntegerToRoman {
    private enum RomanToDec {
        I(0, "V", "X"),
        X(1, "L", "C"),
        C(2, "D", "M"),
        M(3, null, null);

        private String value5; // Value that represents value * 5 for current roman digit, for example I -> V, X -> L
        private String value10; // Value that represents next roman digit, for example I -> X, C -> M

        private int pow10; // Power of 10, for example I is 10 ^ 0, C is 10 ^ 2 et.c.

        private RomanToDec(int pow10, String value5, String value10) {
            this.pow10 = pow10;
            this.value5 = value5;
            this.value10 = value10;
        }

        static RomanToDec getRoman(int pow10) {
            for (RomanToDec each : RomanToDec.values()) {
                if (each.pow10 == pow10) {
                    return each;
                }
            }
            throw new IllegalStateException("Unexpected value: " + pow10);
        }


    }

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("Number outside of the range. Valid range is from 1 to 3999");
        }

        StringBuilder result = new StringBuilder();
        int position = 0; // from right to left
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            RomanToDec rl = RomanToDec.getRoman(position);
            StringBuilder digitRoman = new StringBuilder();
            if (digit > 0 && digit < 4) {
                for (int i = 0; i < digit; i++) {
                    digitRoman.append(rl);
                }
            } else if (digit == 4) {
                digitRoman.append(rl).append(rl.value5);
            } else if (digit == 9) {
                digitRoman.append(rl).append(rl.value10);
            } else if (digit > 4 && digit < 9) {
                digitRoman.append(rl.value5);
                for (int i = 0; i < digit - 5; i++) {
                    digitRoman.append(rl);
                }
            }
            //System.out.println(digit + " -> " + digitRoman);
            position++;
            result.insert(0, digitRoman.toString());
        }
        return result.toString();
    }

}
