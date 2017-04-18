package com.apismensky.reversepolish;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ReversePolishTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        ReversePolish.calculate(null);
    }

    @Test
    public void testCalculateSimple() {
        assertEquals(2, ReversePolish.calculate(new String[]{"1", "1", "+"}));
    }

    @Test(expected = NumberFormatException.class)
    public void testInvalidInput() {
        ReversePolish.calculate(new String[]{"1", "ABC", "+"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooManyOperations() {
        ReversePolish.calculate(new String[]{"1", "1", "+", "+"});
    }

    @Test
    public void testLessOperations() {
        assertEquals(3, ReversePolish.calculate(new String[]{"1", "1", "2", "+"}));
    }

    // ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    @Test
    public void testCalculateComplex() {
        assertEquals(9, ReversePolish.calculate(new String[]{"2", "1", "+", "3", "*"}));
    }

    // ["4", "13", "5", "/", "+"] -> (4 + (15 / 5)) -> 7
    @Test
    public void testCalculateComplex2() {
        assertEquals(7, ReversePolish.calculate(new String[]{"4", "15", "5", "/", "+"}));
    }

    @Test
    public void testCalculateEmpty() {
        assertEquals(0, ReversePolish.calculate(new String[]{}));
    }

}
