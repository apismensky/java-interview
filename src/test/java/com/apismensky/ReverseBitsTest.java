package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseBitsTest {

    @Test
    public void test0() {
        assertEquals(0, ReverseBits.reverseBits(0));
    }

    @Test
    public void test10() {
        assertEquals(1342177280, ReverseBits.reverseBits(10));
    }

    @Test
    public void test43261596() {
        assertEquals(964176192, ReverseBits.reverseBits(43261596));
    }

}
