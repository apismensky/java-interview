package com.octanner;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * We will sweep down the sequence starting at the pointer position shown above.

 As we sweep we maintain a pair consisting of a current candidate and a counter. Initially, the current candidate is unknown and the counter is 0.

 When we move the pointer forward over an element e:

 If the counter is 0, we set the current candidate to e and we set the counter to 1.
 If the counter is not 0, we increment or decrement the counter according to whether e is the current candidate.
 When we are done, the current candidate is the majority element, if there is a majority.
 */
public class MajorityElement {
    public static int majorityElement(int[] num) {
        if (num == null || num.length==0)
            throw new IllegalArgumentException("Argument can not be empty or null");
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
