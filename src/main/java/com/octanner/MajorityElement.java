package com.octanner;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public static int majorityElement(int[] num) {
        int cand = num[0];
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == cand)
                count++;
            else
                count--;
            if (count == 0) {
                cand = num[i];
                count = 1;
            }

        }
        return cand;

    }
}
