package com.octanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOf1BitsTest {
    @Test
    public void test0() {
        assertEquals(0, NumberOf1Bits.hammingWeight(0));
    }

    @Test
    public void test11() {
        assertEquals(3, NumberOf1Bits.hammingWeight(11));
    }

    @Test
    public void test01() {
        assertEquals(0, NumberOf1Bits.hammingWeight1(0));
    }

    @Test
    public void test111() {
        assertEquals(3, NumberOf1Bits.hammingWeight1(11));
    }

}
