package com.octanner;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p/>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        if (nums.length % 2 == 0)
            throw new IllegalArgumentException("Expected odd number of elements");
        int result = 0;
        for (int num : nums)
            result ^= num;
        return result;
    }
}
