package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTwoIntegersTest {

    @Test
    public void testZeros() {
       assertEquals(0, SumTwoIntegers.getSum(0, 0));
    }

    @Test
    public void testZeroOne() {
        assertEquals(1, SumTwoIntegers.getSum(0,1));
    }

    @Test
    public void testOneZero() {
        assertEquals(1, SumTwoIntegers.getSum(1,0));
    }

    @Test
    public void test15() {
        assertEquals(15, SumTwoIntegers.getSum(7,8));
    }

    @Test
    public void test13() {
        assertEquals(13, SumTwoIntegers.getSum(7,6));
    }

    @Test
    public void test10() {
        assertEquals(10, SumTwoIntegers.getSum(5,5));
    }
}
