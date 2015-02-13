package com.octanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseIntegerTest {
    @Test
    public void testZero() {
        assertEquals(0, ReverseInteger.reverse(0));
    }

    @Test
    public void testOne() {
        assertEquals(1, ReverseInteger.reverse(1));
    }

    @Test
    public void testMinusOne() {
        assertEquals(-1, ReverseInteger.reverse(-1));
    }

    @Test
    public void testMinus10() {
        assertEquals(-1, ReverseInteger.reverse(-10));
    }

    @Test
    public void test12() {
        assertEquals(21, ReverseInteger.reverse(12));
    }

    @Test
    public void test1534236469() {
        assertEquals(0, ReverseInteger.reverse(1534236469));
    }
}
