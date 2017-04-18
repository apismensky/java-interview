package com.octanner;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

import static com.octanner.ArrayIntersect.*;

public class ArrayIntersectTest {

    @Test (expected = NullPointerException.class)
    public void testNull1() {
       intersect(null, new Object[]{});
    }

    @Test (expected = NullPointerException.class)
    public void testNull2() {
        intersect(new Object[]{}, null);
    }

    @Test
    public void testEmpty() {
        assertArrayEquals(new Object[]{}, intersect(new Object[]{}, new Object[]{}));
    }

    @Test
    public void testEmpty1() {
        assertArrayEquals(new Object[]{}, intersect(new Object[]{}, new Object[]{new Object()}));
    }

    @Test
    public void testEmpty2() {
        assertArrayEquals(new Object[]{}, intersect(new Object[]{new Object()}, new Object[]{}));
    }

    @Test
    public void testFound() {
        assertArrayEquals(new Integer[]{1}, intersect(new Integer[]{1}, new Integer[]{1}));
    }

    @Test
    public void test1() {
        assertArrayEquals(new Integer[]{}, intersect(new Integer[]{0}, new Integer[]{1}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new Integer[]{2}, intersect(new Integer[]{1, 2}, new Integer[]{2, 3}));
    }

    @Test
    public void test3() {
        assertArrayEquals(new Integer[]{2,2}, intersect(new Integer[]{1, 2, 2, 1}, new Integer[]{2, 2}));
    }

    @Test
    public void test4() {
        assertArrayEquals(new int[]{2,2}, new ArrayIntersect().intersectInt(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

}
