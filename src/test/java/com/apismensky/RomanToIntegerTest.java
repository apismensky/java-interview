package com.apismensky;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RomanToIntegerTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        RomanToInteger.romanToInt(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmpty() {
        RomanToInteger.romanToInt("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCharacters() {
        RomanToInteger.romanToInt("QQQ");
    }

    @Test
    public void testI() {
        assertEquals(1, RomanToInteger.romanToInt("I"));
    }

    @Test
    public void testV() {
        assertEquals(5, RomanToInteger.romanToInt("V"));
    }

    @Test
    public void testX() {
        assertEquals(10, RomanToInteger.romanToInt("X"));
    }

    @Test
    public void testL() {
        assertEquals(50, RomanToInteger.romanToInt("L"));
    }

    @Test
    public void testC() {
        assertEquals(100, RomanToInteger.romanToInt("C"));
    }

    @Test
    public void testD() {
        assertEquals(500, RomanToInteger.romanToInt("D"));
    }

    @Test
    public void testM() {
        assertEquals(1000, RomanToInteger.romanToInt("M"));
    }

    @Test
    public void testII() {
        assertEquals(2, RomanToInteger.romanToInt("II"));
    }

    @Test
    public void testXV() {
        assertEquals(15, RomanToInteger.romanToInt("XV"));
    }

    @Test
    public void testIV() {
        assertEquals(4, RomanToInteger.romanToInt("IV"));
    }

    @Test
    public void testDC() {
        assertEquals(600, RomanToInteger.romanToInt("DC"));
    }

    @Test
    public void testMMMMCMXCIX(){
        assertEquals(3999, RomanToInteger.romanToInt("MMMCMXCIX"));
    }
}
