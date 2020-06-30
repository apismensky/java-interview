package com.apismensky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MInStackTest {

    @Test
    public void testEmpty() {
        MinStack stack = new MinStack();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushTopPop() {
        MinStack stack = new MinStack();
        stack.push(0);
        assertEquals(0, stack.top());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testMin() {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(-9);
        stack.push(8);
        stack.push(1);
        assertEquals(-9, stack.getMin());
    }

    @Test
    public void testMinPush() {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        assertEquals(0,stack.getMin());
        stack.pop();
        assertEquals(0, stack.getMin());
    }
}
