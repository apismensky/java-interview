package com.apismensky;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

    private static Set<String> results = new HashSet<>();

    public static String minWindow(String input, String search) {
        if (input.equals("") || search.equals("")) {
            return "";
        }

        Map<Character, Integer> searchMap = toMap(search.toCharArray());
        int left = 0, right = 0;

        while (right <= input.length()) {
            String candidate = input.substring(left, right);
            if (contains(candidate, searchMap)) {
                int contractedCandidate = contractCandidate(candidate, searchMap);
                left += contractedCandidate;
            }
            right++;
        }

        System.out.println(results);
        return results.stream().min(Comparator.comparingInt(String::length)).orElse("");
    }

    private static int contractCandidate(String candidate, Map<Character, Integer> searchMap) {
        int result = 0;
        do {
            result++;
        } while (contains(candidate.substring(result), searchMap));
        String minSubs = candidate.substring(result-1);
        results.add(minSubs);
        return result;
    }

    private static boolean contains(String candidate, Map<Character, Integer> searchMap) {
        return contains(toMap(candidate.toCharArray()), searchMap);
    }

    private static boolean contains(Map<Character, Integer> candidateMap, Map<Character, Integer> searchMap) {
        for (Character character : searchMap.keySet()) {
            if (candidateMap.getOrDefault(character, 0) < searchMap.getOrDefault(character, 0)) {
                return false;
            }
        }
        return true;
    }

    private static  Map<Character, Integer> toMap(char[] searchArray) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : searchArray) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }
        return map;
    }

    public static void main(String[] args) {
        String window = minWindow("FFADOBECODEBANC", "ABC");
        System.out.println(window);
    }
}