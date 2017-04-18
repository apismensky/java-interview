package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeapYearTest {
    @Test
    public void test3() {
        assertFalse(LeapYear.isLeapYear(3));
    }
    @Test
    public void test4() {
        assertTrue(LeapYear.isLeapYear(4));
    }
    @Test
    public void test1600() {
        assertTrue(LeapYear.isLeapYear(1600));
    }
    @Test
    public void test1700() {
        assertFalse(LeapYear.isLeapYear(1700));
    }
    @Test
    public void test1800() {
        assertFalse(LeapYear.isLeapYear(1800));
    }
    @Test
    public void test1928() {
        assertTrue(LeapYear.isLeapYear(1928));
    }
    @Test
    public void test1950() {
        assertFalse(LeapYear.isLeapYear(1950));
    }

}
