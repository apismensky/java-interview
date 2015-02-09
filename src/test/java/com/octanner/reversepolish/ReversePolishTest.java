package com.octanner.reversepolish;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ReversePolishTest {

    private ReversePolish rp;

    @Before
    public void before() {
        rp = new ReversePolish();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        rp.calculate(null);
    }

    @Test
    public void testCalculateSimple() {
        assertEquals(2, rp.calculate(new String[]{"1", "1", "+"}));
    }

    @Test(expected = NumberFormatException.class)
    public void testInvalidInput() {
        rp.calculate(new String[]{"1", "ABC", "+"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooManyOperations() {
        rp.calculate(new String[]{"1", "1", "+", "+"});
    }

    @Test
    public void testLessOperations() {
        assertEquals(3, rp.calculate(new String[]{"1", "1", "2", "+"}));
    }

    // ["2", "1", "+", "3", "*"] -> ((2 + 1) + 3) -> 6
    @Test
    public void testCalculateComplex() {
        assertEquals(9, rp.calculate(new String[]{"2", "1", "+", "3", "*"}));
    }

    // ["4", "13", "5", "/", "+"] -> (4 + (15 / 5)) -> 7
    @Test
    public void testCalculateComplex2() {
        assertEquals(7, rp.calculate(new String[]{"4", "15", "5", "/", "+"}));
    }

    @Test
    public void testCalculateEmpty() {
        assertEquals(0, rp.calculate(new String[]{}));
    }

    @Test
    public void testGetNumber() {
        assertEquals(1, rp.getNumber("1"));
    }

    @Test(expected = NumberFormatException.class)
    public void testGetNumberInvalid() {
        rp.getNumber("ABC");
    }

}
