package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        ValidParentheses.isValid(null);
    }

    @Test
    public void testEmpty() {
        assertTrue(ValidParentheses.isValid(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOtherChars() {
        ValidParentheses.isValid("ABC");
    }

    @Test
    public void testTwoBrackets() {
        assertTrue(ValidParentheses.isValid("()"));
    }

    @Test
    public void testOneBracket() {
        assertFalse(ValidParentheses.isValid("("));
    }

    @Test
    public void testValid() {
        assertTrue(ValidParentheses.isValid("()[]{}"));
    }

    @Test
    public void testValidLarge() {
        assertTrue(ValidParentheses.isValid("{()[{}]}"));
    }

    @Test
    public void testInvalid() {
        assertFalse(ValidParentheses.isValid("([)]"));
    }

    @Test
    public void testInvalidLarge() {
        assertFalse(ValidParentheses.isValid("{([{})]}"));
    }
}
