package com.octanner.lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void testAddExists() {
        new Queue<Long>().add(1L);
    }

    @Test
    public void testPollEmpty() {
        assertNull(new Queue().poll());
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        new Queue<Long>().add(null);
    }

    @Test
    public void testAddAndPollSingle() {
        Queue q = new Queue<Long>().add(1L);
        assertEquals(1L, q.poll());
    }

    @Test
    public void testAddAndPollMultiple() {
        Queue q = new Queue<Long>().add(1L);
        assertEquals(1L, q.poll());
        assertNull(q.poll());
    }

    @Test
    public void testMultipleOperations() {
        Queue q = new Queue<Long>()
                .add(1L)
                .add(2L)
                .add(6L);
        assertEquals(1L, q.poll());
        assertEquals(2L, q.poll());
        assertEquals(6L, q.poll());
        assertNull(q.poll());
    }
}
