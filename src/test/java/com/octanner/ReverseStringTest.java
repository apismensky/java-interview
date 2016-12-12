package com.octanner;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ReverseStringTest {

    @Test
    public void testEmpty() {
        assertEquals("", ReverseString.reverseString(""));
    }
    @Test
    public void testOne() {
        assertEquals("a", ReverseString.reverseString("a"));
    }

    @Test
    public void testHello() {
        assertEquals("Hello", ReverseString.reverseString("olleH"));
    }

}
