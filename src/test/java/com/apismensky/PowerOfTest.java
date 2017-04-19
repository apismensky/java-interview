package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PowerOfTest {

    public static final PowerOf PowerOf = new PowerOf();

    @Test
    public void test2() {
        assertTrue(PowerOf.isPowerOfTwo(2));
    }

    @Test
    public void test0() {
        assertFalse(PowerOf.isPowerOfTwo(0));
    }

    @Test
    public void test02() {
        assertTrue(PowerOf.isPowerOfTwo(1));
    }

    @Test
    public void test3() {
        assertTrue(PowerOf.isPowerOfThree(1));
    }

    @Test
    public void test256() {
        assertTrue(PowerOf.isPowerOfTwo(256));
    }

    @Test
    public void test254() {
        assertFalse(PowerOf.isPowerOfTwo(254));
    }


    @Test
    public void test4() {
        assertTrue(PowerOf.isPowerOfFour(1));
    }

    @Test
    public void testM3() {
        assertFalse(PowerOf.isPowerOfThree(-3));
    }

    @Test
    public void test03() {
        assertFalse(PowerOf.isPowerOfThree(0));
    }

    @Test
    public void test81() {
        assertTrue(PowerOf.isPowerOfThree(81));
    }

    @Test
    public void test80() {
        assertFalse(PowerOf.isPowerOfThree(80));
    }

    @Test
    public void test8() {
        assertFalse(PowerOf.isPowerOfFour(8));
    }

    @Test
    public void test16() {
        assertTrue(PowerOf.isPowerOfFour(16));
    }
}
