package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerToRomanTest {

    @Test(expected = IllegalArgumentException.class)
    public void testRangeLess() {
        IntegerToRoman.intToRoman(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRangeMore() {
        IntegerToRoman.intToRoman(4000);
    }

    @Test
    public void test1() {
        assertEquals("I", IntegerToRoman.intToRoman(1));
    }

    @Test
    public void test5() {
        assertEquals("V", IntegerToRoman.intToRoman(5));
    }

    @Test
    public void test10() {
        assertEquals("X", IntegerToRoman.intToRoman(10));
    }

    @Test
    public void test50() {
        assertEquals("L", IntegerToRoman.intToRoman(50));
    }

    @Test
    public void test1000() {
        assertEquals("M", IntegerToRoman.intToRoman(1000));
    }


    @Test
    public void test1100() {
        assertEquals("MC", IntegerToRoman.intToRoman(1100));
    }

    @Test
    public void test2() {
        assertEquals("II", IntegerToRoman.intToRoman(2));
    }

    @Test
    public void test3098() {
        assertEquals("MMMXCVIII", IntegerToRoman.intToRoman(3098));
    }

    @Test
    public void test3999() {
        assertEquals("MMMCMXCIX", IntegerToRoman.intToRoman(3999));
    }
}
