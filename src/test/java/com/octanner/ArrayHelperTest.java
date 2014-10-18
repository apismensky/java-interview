package com.octanner;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayHelperTest {

    // Passing null argument to the method should produce IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testNullArray() {
        ArrayHelper.reverse(null);
    }

    // Passing empty array should return empty array
    @Test
    public void testEmptyArray() {
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

}
