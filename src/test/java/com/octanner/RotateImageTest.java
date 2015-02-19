package com.octanner;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RotateImageTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        RotateImage.rotate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDifferentSizes() {
        RotateImage.rotate(new int[][] {{1, 2},{1,2},{1,2}});
    }

    @Test
    public void test1() {
        int[][] matrix = {{1}};
        RotateImage.rotate(matrix);
        assertArrayEquals(matrix.clone(), matrix);
    }

    @Test
    public void test3() {
        int[][] matrix = {{1,2,3}, {3,4,5}, {6,7,8}};
        int[][] expected = {{6,3,1}, {7,4,2}, {8,5,3}};
        RotateImage.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void test4() {
        int[][] matrix = {{1,2,3,10}, {3,4,5,11}, {6,7,8,12},{14,15,16,17}};
        int[][] expected = {{14,6,3,1}, {15,7,4,2}, {16,8,5,3}, {17,12,11,10} };
        RotateImage.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }
}
