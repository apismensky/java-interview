package com.octanner;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a non-empty string containing an out-of-order English representation of digits 0-9,
 * output the digits in ascending order.
 * <p>
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits.
 * That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 */
public class ReconstructDigits {
    /**
     * Linear complexity
     */
    public static String originalDigits(String s) {
        int[] cnt = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') cnt[0]++;
            if (c == 'o') cnt[1]++; // o=[zero, one, two, four]
            if (c == 'w') cnt[2]++;
            if (c == 'h') cnt[3]++; // h=[three, eight]
            if (c == 'u') cnt[4]++;
            if (c == 'f') cnt[5]++; // f=[four, five]
            if (c == 'x') cnt[6]++;
            if (c == 's') cnt[7]++; // s=[six, seven]
            if (c == 'g') cnt[8]++;
            if (c == 'i') cnt[9]++; // i=[five, six, eight, nine]
        }
        cnt[1] = cnt[1] - cnt[0] - cnt[2] - cnt[4];
        cnt[3] = cnt[3] - cnt[8];
        cnt[7] = cnt[7] - cnt[6];
        cnt[5] = cnt[5] - cnt[4];
        cnt[9] = cnt[9] - cnt[5] - cnt[6] - cnt[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt.length; i++)
            for (int j = 0; j < cnt[i]; j++)
                sb.append(i);
        return sb.toString();
    }

    public static void main(String[] a) {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        HashMap<Character, List<String>> charDistr = new HashMap<Character, List<String>>();
        for (String digit : digits) {
            for (char c : digit.toCharArray()) {
                if (!charDistr.containsKey(c))
                    charDistr.put(c, new ArrayList<String>());
                charDistr.get(c).add(digit);
            }
        }
        System.out.println(charDistr);
    }
}
