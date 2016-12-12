package com.octanner;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TriSumTest {
    @Test
    public void testEmpty() {
        List<List<Integer>> sum = TriSum.threeSum(new int[]{});
        assertEquals(new ArrayList<List<Integer>>(), sum);
    }

    @Test
    public void testNoSolution() {
        List<List<Integer>> sum = TriSum.threeSum(new int[]{1,1,1});
        assertEquals(new ArrayList<List<Integer>>(), sum);
    }

    @Test
    @Ignore
    public void testSolution() {
        List<List<Integer>> sum = TriSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        ArrayList<List<Integer>> expected = new ArrayList<List<Integer>>();
        ArrayList<Integer> i1 = new ArrayList<Integer>();
        i1.add(-1);
        i1.add(0);
        i1.add(1);
        expected.add(i1);

        ArrayList<Integer> i2 = new ArrayList<Integer>();
        i2.add(-1);
        i2.add(-1);
        i2.add(2);
        expected.add(i2);

        assertEquals(expected, sum);
    }

    @Test
    public void testTileLimit() {
        long start = System.currentTimeMillis();
        List<List<Integer>> sum = TriSum.threeSum(new int[]{8,5,12,3,-2,-13,-8,-9,-8,10,-10,-10,-14,-5,-1,-8,-7,-12,4,4,10,-8,0,-3,4,11,-9,-2,-7,-2,3,-14,-12,1,-4,-6,3,3,0,2,-9,-2,7,-8,0,14,-1,8,-13,10,-11,4,-13,-4,-14,-1,-8,-7,12,-8,6,0,-15,2,8,-4,11,-4,-15,-12,5,-9,1,-2,-10,-14,-11,4,1,13,-1,-3,3,-7,9,-4,7,8,4,4,8,-12,12,8,5,5,12,-7,9,4,-12,-1,2,5,4,7,-2,8,-12,-15,-1,2,-11});
        System.out.println(sum);
        long time = System.currentTimeMillis() - start;
        System.out.println("Time: " + time);
        assertTrue("Took more than 100 ms", time < 100);

    }
}
