package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumSortedTest {
    @Test
    public void sumZeroArray() {
        int[] twoSum = TwoSumSorted.twoSum(new int[]{0, 0, 0}, 0);
        assertArrayEquals(new int[]{1, 2}, twoSum);
    }

    @Test
    public void sumOneArray() {
        int[] twoSum = TwoSumSorted.twoSum(new int[]{0,0,1}, 1);
        assertArrayEquals(new int[]{1,3},twoSum);
    }

    @Test
    public void sum1() {
        int[] twoSum = TwoSumSorted.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{1,2},twoSum);
    }

    @Test
    public void sum2() {
        int[] twoSum = TwoSumSorted.twoSum(new int[]{8, 18, 2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{3,4},twoSum);
    }

    @Test
    public void testTiming() {
        long l = System.currentTimeMillis();
        int[] a = new int[1000];
        TwoSumSorted.twoSum(a,0);
        System.out.println("Time: " + (System.currentTimeMillis() - l));
    }
    @Test(expected = IllegalArgumentException.class)
    public void exceptionArraySize() {
        TwoSumSorted.twoSum(new int[]{0}, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionNoSolution() {
        TwoSumSorted.twoSum(new int[]{1,5}, 8);
    }
}
