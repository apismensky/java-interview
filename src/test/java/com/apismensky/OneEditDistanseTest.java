package com.apismensky;

import static com.apismensky.OneEditDistanse.isOneEditDistance;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OneEditDistanseTest {

    @Test
    public void test1() {
        assertTrue(isOneEditDistance("ab", "abc"));
    }

    @Test
    public void test2() {
        assertFalse(isOneEditDistance("cab", "ad"));
    }

    @Test
    public void test3() {
        assertTrue(isOneEditDistance("1203", "1213"));
    }

    @Test
    public void test4() {
        assertFalse(isOneEditDistance("1234", "123456"));
    }


    @Test
    public void test5() {
        assertTrue(isOneEditDistance("12534", "1234"));
    }

    @Test
    public void test6() {
        assertFalse(isOneEditDistance("ab", "acd"));
    }

    @Test
    public void test7() {
        assertFalse(isOneEditDistance("teacher", "bleacher"));
    }
}