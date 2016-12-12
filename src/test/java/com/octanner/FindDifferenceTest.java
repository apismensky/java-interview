package com.octanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindDifferenceTest {

    @Test
    public void testEmpty() {
        assertEquals('s', FindDifference.findTheDifference("", "s"));
    }

    @Test
    public void test1() {
        assertEquals('e', FindDifference.findTheDifference("abcd", "abcde"));
    }

    @Test
    public void test2() {
        assertEquals('r', FindDifference.findTheDifference("abrrrrrcd", "abrrrrrrcd"));
    }

    @Test
    public void test3() {
        assertEquals('a', FindDifference.findTheDifference("ae", "aea"));
    }
}
