package com.octanner;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GenerateParenthesesTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNegative() {
        GenerateParentheses.generateParenthesis(-1);
    }

    @Ignore
    @Test
    public void testZero() {
        assertEquals(new ArrayList<String>(), GenerateParentheses.generateParenthesis(0));
    }

    @Ignore
    @Test
    public void testOne() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("()");
        assertEquals(expected, GenerateParentheses.generateParenthesis(1));
    }

    @Ignore
    @Test
    public void testThree() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("((()))");
        expected.add("(()())");
        expected.add("(())()");
        expected.add("()(())");
        expected.add("((()))");
        expected.add("()()()");
        assertEquals(expected, GenerateParentheses.generateParenthesis(3));
    }

}
