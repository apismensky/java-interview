package com.apismensky;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3. Example 2:
 * <p>
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1. Example 3:
 * <p>
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke"
 * is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int right = 0;
        int size = s.length();
        int result = 0;
        while (left < size && right < size) {
            // Trying to move right
            char o = s.charAt(right);
            if (!window.contains(o)) {
                window.add(o);
                if (result < window.size()) {
                    result = window.size();
                }
                right++;
            } else {
                window.remove(s.charAt(left));
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters t = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(t.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(t.lengthOfLongestSubstring("bbbbb"));
        System.out.println(t.lengthOfLongestSubstring("pwwkew"));
    }
}
