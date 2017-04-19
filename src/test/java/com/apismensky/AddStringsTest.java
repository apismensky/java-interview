package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddStringsTest {
    @Test(expected = NullPointerException.class)
    public void testNull1() {
        new AddStrings().addStrings(null, "1");
    }

    @Test(expected = NullPointerException.class)
    public void testNull2() {
        new AddStrings().addStrings("1", null);
    }

    @Test
    public void testZero() {
        assertEquals("0", new AddStrings().addStrings("0", "0"));
    }

    @Test
    public void testOne() {
        assertEquals("1", new AddStrings().addStrings("1", "0"));
    }

    @Test
    public void test1010() {
        assertEquals("1010", new AddStrings().addStrings("1000", "10"));
    }

    @Test
    public void test10() {
        assertEquals("10", new AddStrings().addStrings("1", "9"));
    }


    @Test
    public void test2() {
        assertEquals("6984362587", new AddStrings().addStrings("6913259244", "71103343"));
    }

    @Test
    public void test3() {
        assertEquals("9419584439332250", new AddStrings().addStrings("9333852702227987", "85731737104263"));
    }

    @Test
    public void test4() {
        AddStrings.sum(new int[]{9}, new int[]{9});
    }

}
