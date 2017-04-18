package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissingNumberTest {

    @Test(expected = NullPointerException.class)
    public void testNull() {
        MissingNumber.missingNumber(null);
    }

    @Test
    public void testEmpty() {
        assertEquals(0, MissingNumber.missingNumber(new int[]{}));
    }

    @Test
    public void test0() {
        assertEquals(1, MissingNumber.missingNumber(new int[]{0}));
    }

    @Test
    public void test1() {
        assertEquals(2, MissingNumber.missingNumber(new int[]{1, 0}));
    }

    @Test
    public void test2() {
        assertEquals(2, MissingNumber.missingNumber(new int[]{0, 1}));
    }

    @Test
    public void test() {
        assertEquals(2, MissingNumber.missingNumber(new int[]{0, 1, 3}));
    }
}
