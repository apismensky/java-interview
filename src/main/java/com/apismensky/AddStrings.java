package com.apismensky;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/**
 * Given two non-negative integers num1 and num2 represented as string,
 * return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        Preconditions.checkNotNull(num1, "Number1 must not be null");
        Preconditions.checkNotNull(num2, "Number2 must not be null");
        return toStr(sum(toDigits(num1), toDigits(num2)));
    }

    static String toStr(int[] num) {
        StringBuilder sb = new StringBuilder();
        if (num[0] > 0)
            sb.append(num[0]);
        for (int i = 1; i < num.length; i++)
            sb.append(num[i]);
        return sb.toString();
    }

    @VisibleForTesting
    static int[] toDigits(String num) {
        char[] chars = num.toCharArray();
        int[] result = new int[chars.length];
        for (int i = 0; i < chars.length; i++)
            result[i] = (Character.getNumericValue(chars[i]));
        return result;
    }

    @VisibleForTesting
    static int[] sum(int[] digits1, int[] digits2) {
        int sumSize = Math.max(digits1.length, digits2.length) + 1;
        int[] result = new int[sumSize];
        int carry = 0;
        for (int i = 1; i < sumSize; i++) {
            int d1 = (digits1.length - i >= 0) ? digits1[digits1.length - i] : 0;
            int d2 = (digits2.length - i >= 0) ? digits2[digits2.length - i] : 0;
            int sumDigits = d1 + d2 + carry;
            if (sumDigits > 9) {
                carry = 1;
                result[result.length - i] = sumDigits - 10;
            }
            else {
                carry = 0;
                result[result.length - i] = sumDigits;
            }
        }
        result[0] = carry;
        return result;
    }


}
