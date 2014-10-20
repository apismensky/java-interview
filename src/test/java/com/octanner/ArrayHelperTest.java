package com.octanner;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArrayHelperTest {

    // Passing null argument to the method should produce IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testReverseNullArray() {
        ArrayHelper.reverse(null);
    }

    // Passing empty array should return empty array
    @Test
    public void testReverseEmptyArray() {
        assertArrayEquals(new int[]{}, ArrayHelper.reverse(new int[]{}));
    }

    // Passing non-empty array should revert array
    @Test
    public void testReverse() {
        assertArrayEquals(new int[]{3, 2, 1}, ArrayHelper.reverse(new int[]{1, 2, 3}));
    }

    // Just another usecase - array with duplicated elements
    @Test
    public void testReverseWithDuplicate() {
        assertArrayEquals(new int[]{3, 2, 1, 5, 7, 1}, ArrayHelper.reverse(new int[]{1, 7, 5, 1, 2, 3}));
    }

    // If the first argument is null produce IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testSearchNull() {
        ArrayHelper.search(null, 1);
    }

    // Search in an empty array should always give -1
    @Test
    public void testSearchEmpty() {
        assertEquals(-1, ArrayHelper.search(new int[]{}, 1));
    }

    // One element array should work - found
    @Test
    public void testSearchArrayOneElementFound() {
        assertEquals(0, ArrayHelper.search(new int[]{4}, 4));
    }

    // One element array should work - not found
    @Test
    public void testSearchArrayOneElementNotFound() {
        assertEquals(-1, ArrayHelper.search(new int[]{2}, 1));
    }

    // Search in the array that does not contain given element should return -1
    @Test
    public void testSearchNotFound() {
        assertEquals(-1, ArrayHelper.search(new int[]{-4, -3, 0, 1, 2, 5, 8, 10}, 4));
    }

    // Search in the array that contains given element element should return element index
    @Test
    public void testSearchFound() {
        assertEquals(7, ArrayHelper.search(new int[]{-4, -3, 0, 1, 2, 5, 8, 10}, 10));
    }

    // Search in the array with duplicates should return one of the elements index
    @Test
    public void testSearchDuplicateFound() {
        assertEquals(3, ArrayHelper.search(new int[]{ -4, -3, 0, 0, 0, 0, 0, 1}, 0));
    }

}
