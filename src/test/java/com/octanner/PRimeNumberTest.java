package com.octanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeNumberTest {

    @Test(expected = NegativeArraySizeException.class)
    public void testNonNegative() {
        PrimeNumber.countPrimes(-1);
    }

    @Test
    public void test0() {
        assertEquals(0, PrimeNumber.countPrimes(0));
    }

    @Test
    public void test1() {
        assertEquals(0, PrimeNumber.countPrimes(1));
    }

    @Test
     public void test2() {
        assertEquals(0, PrimeNumber.countPrimes(2));
    }

    @Test
    public void test3() {
        assertEquals(1, PrimeNumber.countPrimes(3));
    }

    @Test
    public void test4() { // 2,3
        assertEquals(2, PrimeNumber.countPrimes(4));
    }

    @Test
    public void test5() { // 2,3
        assertEquals(2, PrimeNumber.countPrimes(5));
    }

    @Test
    public void test20() { // 2,3,5,7,11,13,17,19
        assertEquals(8, PrimeNumber.countPrimes(20));
    }

    @Test
    public void test10000000() {
        long before = System.currentTimeMillis();
        int actual = PrimeNumber.countPrimes(10000000);
        long after = System.currentTimeMillis();
        System.out.println("Time, ms: " + (after - before));
        assertEquals(664579, actual);
    }
}
