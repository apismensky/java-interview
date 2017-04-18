package com.octanner;

import com.google.common.base.Preconditions;

import java.util.Arrays;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        Preconditions.checkNotNull(nums, "Input array can not be null");
        Arrays.sort(nums);
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return i;
    }
}
