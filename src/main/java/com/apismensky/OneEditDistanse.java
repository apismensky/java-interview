package com.apismensky;

/**
 * Given two strings s and t, determine if they are both one edit distance apart.
 *
 * Note:
 *
 * There are 3 possiblities to satisify one edit distance apart:
 *
 * Insert a character into s to get t
 * Delete a character from s to get t
 * Replace a character of s to get t
 * Example 1:
 *
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * Example 2:
 *
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * Example 3:
 *
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 */
public class OneEditDistanse {
    public static boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || Math.abs(s.length()-t.length()) > 1) {
            return false;
        }
        String longest = s;
        String shortest = t;
        if (s.length() < t.length()) {
            longest = t;
            shortest = s;
        }
        boolean isUpdate = shortest.length() == longest.length();
        int count = 0;
        if (isUpdate) {
            for (int i = 0; i < shortest.length(); i++) {
                if (count > 1) {
                    return false;
                }
                if (shortest.charAt(i) != longest.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
        else {
            // Insert Or Delete
            int i = 0;
            int j = 0;
            while (i < longest.length() && j < shortest.length()) {
                if (count > 1) {
                    return false;
                }
                char lc = longest.charAt(i);
                char sc = shortest.charAt(j);
                if (lc != sc) {
                    count++;
                    i++;
                }
                else {
                    i++;
                    j++;
                }
            }
            return count <= 1;
        }

    }
}