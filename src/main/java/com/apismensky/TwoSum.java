package com.apismensky;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
class TwoSum {
    /**
     * Brute force N ^ 2
     */
    static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2)
            throw new IllegalArgumentException("Array size should be greater or equals 2");

       for(int i = 0; i<nums.length; i++) {
           for (int j = i + 1; j<nums.length; j++) {
               if (nums[i] + nums[j] == target)
                   return new int[]{i,j};
           }
       }
       throw new IllegalArgumentException("No solution");
    }

    /**
     * Complexity N
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
