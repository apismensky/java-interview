package com.octanner.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    @Test
    public void testPushExists() {
        new Stack<Long>().push(1L);
    }

    @Test(expected = NullPointerException.class)
    public void testPopEmpty() {
        new Stack<Long>().pop();
    }

    @Test(expected = NullPointerException.class)
    public void testPushNull() {
        new Stack<Long>().push(null);
    }

    @Test
    public void testPushAndPopSingle() {
        Stack<Long> stack = new Stack<Long>().push(1L);
        assertEquals(1L, stack.pop().longValue());
    }

    @Test(expected = NullPointerException.class)
    public void testPushAndMultiplePop() {
        Stack<Long> stack = new Stack<Long>().push(1L);
        assertEquals(1L, stack.pop().longValue());
        stack.pop();
    }

    @Test
    public void testMultipleOperations() {
        Stack<Long> stack = new Stack<Long>()
                .push(1L)
                .push(2L)
                .push(6L);
        assertEquals(6L, stack.pop().longValue());
        assertEquals(2L, stack.pop().longValue());
        assertEquals(1L, stack.pop().longValue());
    }
}
