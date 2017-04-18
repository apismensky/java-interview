package com.octanner;

import com.google.common.base.Preconditions;

public class ReverseString {
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i=0; i<chars.length;i++) {
            reversed[chars.length - i -1] = chars[i];
        }
        return new String(reversed);
    }

    /**
     * Given a string and an integer k,
     * you need to reverse the first k characters for every 2k characters
     * counting from the start of the string. If there are less than k characters left,
     * reverse all of them. If there are less than 2k but greater than or equal to k characters,
     * then reverse the first k characters and left the other as original.
       Example:
       Input: s = "abcdefg", k = 2
       Output: "bacdfeg"
       Restrictions:
       The string consists of lower English letters only.
       Length of the given string and k will in the range [1, 10000]

     * @param s String
     * @param k number of char to reverse
     * @return String reversed
     */
    public static String reverseStr(String s, int k) {
        Preconditions.checkArgument(k > 0, "k expected to be > 0");
        StringBuilder r = new StringBuilder();
        int numberOfChunks = (int) Math.ceil((double) s.length() / k);
        for (int i = 0; i < numberOfChunks; i++) {
            int beginIndex = i * k;
            String chunk = s.substring(beginIndex, Math.min(s.length(), beginIndex + k));
            if ((i + 1) % 2 == 0)
                 r.append(chunk); // do not reverse
            else
                 r.append(reverseString(chunk));
        }
        return r.toString();
    }
}
