package com.apismensky;

import java.util.Arrays;

/**
 * Given an array of characters, compress it in-place.
 *
 * The length after compression must always be smaller than or equal to the original array.
 *
 * Every element of the array should be a character (not int) of length 1.
 *
 * After you are done modifying the input array in-place, return the new length of the array.
 *
 *
 * Follow up:
 * Could you solve it using only O(1) extra space?
 *
 *
 * Example 1:
 *
 * Input:
 * ["a","a","b","b","c","c","c"]
 *
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 *
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 *
 *
 * Example 2:
 *
 * Input:
 * ["a"]
 *
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 *
 * Explanation:
 * Nothing is replaced.
 *
 *
 * Example 3:
 *
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 *
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 *
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 *
 *
 * Note:
 *
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 */
public class StringCompressor {

    public StringCompressor(char[] ch) {
        this.chars = ch;
    }

    private int write = 0;
    private final char[] chars;

    public int compress() {
        if (chars.length < 2)
            return 1;
        int count = 1;
        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (prev != chars[i]) {
                writeAll(prev, count);
                count = 1;
                prev = chars[i];
            } else
                count++;
        }
        writeAll(prev, count);
        System.out.println(Arrays.toString(chars));
        return write;
    }

    private void writeAll(char ch, int count) {
        write(ch);
        if (count > 1) {
            char[] digits = ("" + count).toCharArray();
            for (char digit : digits)
               write(digit);
        }
   }

    private void write(char ch) {
        chars[write] = ch;
        this.write++;
    }

    public static void main(String[] args) {
        int compressSize = new StringCompressor("aabbccc".toCharArray()).compress();
        System.out.println(compressSize);
    }
}
