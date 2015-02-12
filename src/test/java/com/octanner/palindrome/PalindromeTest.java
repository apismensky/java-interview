package com.octanner.palindrome;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        Palindrome.findLongest(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmpty() {
        Palindrome.findLongest("");
    }

    @Test
    public void testOneCharInput() {
        assertEquals("a", Palindrome.findLongest("a"));
    }

    @Test
    public void testEven() {
        assertEquals("12344321", Palindrome.findLongest("12344321"));
    }

    @Test
    public void testOdd() {
        assertEquals("123454321", Palindrome.findLongest("1234543210"));
    }

    @Test
    public void testAllChar() {
        assertEquals("AAAA", Palindrome.findLongest("AAAA"));
    }

}
