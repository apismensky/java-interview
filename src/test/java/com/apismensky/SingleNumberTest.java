package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleNumberTest {
    @Test (expected = IllegalArgumentException.class)
    public void testZero() {
        SingleNumber.singleNumber(new int[]{});
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEven() {
        SingleNumber.singleNumber(new int[]{1,1});
    }

    @Test
    public void testOne() {
        assertEquals(1, SingleNumber.singleNumber(new int[]{1}));
    }

    @Test
    public void testMany() {
        assertEquals(4, SingleNumber.singleNumber(new int[]{1,2,5,4,5,1,2}));
    }
}
