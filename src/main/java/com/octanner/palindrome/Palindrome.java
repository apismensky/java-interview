package com.octanner.palindrome;

/**
 * Longest palindromic substring
 * Runs as O (N * N)
 */
public class Palindrome {
    public static String findLongest(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string should not be null or empty");
        }
        String longest = "";
        for (int i = 0; i < input.length(); i++) {

            String odd = getLongest(input, i, 0);
            if (odd.length() > longest.length())
                longest = odd;

            String even = getLongest(input, i, 1);
            if (even.length() > longest.length())
                longest = even;

        }
        return longest;
    }

    /**
     * Helper function that returns the longest palindromic substring of the existing string that is positioned at index i
     *
     * @param input input string that may contain palindrome
     * @param i current char of the string in the loop
     * @param offset either 0 or 1. When it is 0 it is applicable for 'odd' palindromes, like "ABCBA", 1 - for palindromes like "ABBA"
     * @return
     */
    private static String getLongest(String input, int i, int offset) {
        int j = 0; // a distance from the currentChar
        while (i >= j && i + j + offset < input.length()) {
            if (input.charAt(i - j) != input.charAt(i + j + offset)) {
                break;
            }
            j++;
        }
        return input.substring(i - j + 1, i + j + offset);
    }

}
