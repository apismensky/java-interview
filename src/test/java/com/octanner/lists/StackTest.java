package com.octanner.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    @Test
    public void testPushExists() {
        new Stack().push(1L);
    }

    @Test(expected = NullPointerException.class)
    public void testPopEmpty() {
        new Stack().pop();
    }

    @Test(expected = NullPointerException.class)
    public void testPushNull() {
        new Stack().push(null);
    }

    @Test
    public void testPushAndPopSingle() {
        Stack stack = new Stack().push(1L);
        assertEquals(1L, stack.pop());
    }

    @Test(expected = NullPointerException.class)
    public void testPushAndMultiplePop() {
        Stack stack = new Stack().push(1L);
        assertEquals(1L, stack.pop());
        stack.pop();
    }

    @Test
    public void testMultipleOperations() {
        Stack stack = new Stack()
                .push(1L)
                .push(2L)
                .push("Hello");
        assertEquals("Hello", stack.pop());
        assertEquals(2L, stack.pop());
        assertEquals(1L, stack.pop());
    }
}
