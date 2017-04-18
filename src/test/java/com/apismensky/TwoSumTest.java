package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {
    @Test
    public void sumZeroArray() {
        int[] twoSum = TwoSum.twoSum(new int[]{0, 0, 0}, 0);
        assertArrayEquals(new int[]{0, 1}, twoSum);
    }

    @Test
    public void sumOneArray() {
        int[] twoSum = TwoSum.twoSum(new int[]{0,0,1}, 1);
        assertArrayEquals(new int[]{0,2},twoSum);
    }

    @Test
    public void sum1() {
        int[] twoSum = TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0,1},twoSum);
    }

    @Test
    public void sum2() {
        int[] twoSum = TwoSum.twoSum(new int[]{8, 18, 2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{2,3},twoSum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionArraySize() {
        TwoSum.twoSum(new int[]{0}, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionNoSolution() {
        TwoSum.twoSum(new int[]{1,5}, 8);
    }
}
