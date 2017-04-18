package com.octanner;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static com.octanner.ReverseString.*;

public class ReverseStringTest {

    @Test
    public void testEmpty() {
        assertEquals("", reverseString(""));
    }

    @Test
    public void testOne() {
        assertEquals("a", reverseString("a"));
    }

    @Test
    public void testHello() {
        assertEquals("Hello", reverseString("olleH"));
    }

    @Test
    public void testEmpty1() {
        assertEquals("", reverseStr("", 1));
    }

    @Test
    public void testOne1() {
        assertEquals("a", reverseStr("a", 1));
    }

    @Test
    public void testHello1() {
        assertEquals("Hello", reverseStr("Hello", 1));
    }

    @Test
    public void test2() {
        assertEquals("bacdfeg", reverseStr("abcdefg", 2));
    }

}
