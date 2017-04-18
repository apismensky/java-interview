package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddDigitsTest {

    @Test
    public void test0() {
        assertEquals(0, AddDigits.addDigits(0));
    }

    @Test
    public void test99() {
        assertEquals(9, AddDigits.addDigits(99));
    }

    @Test
    public void test38() {
        assertEquals(2, AddDigits.addDigits(38));
    }
}
