package com.octanner;


import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p/>
 * Rotate the image by 90 degrees (clockwise).
 * <prn/>
 * Follow up:
 * Could you do this in-place?
 * <p/>
 *  1  2  3 10      14  6  3  1
 *  3  4  5 11  =>  15  7  4  2
 *  6  7  8 12      16  8  5  3
 * 14 15 16 17      17 12 11 10
 *
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Can not pass null");
        }
        int n = matrix.length;
        if (n > 0 && n != matrix[0].length) {
            throw new IllegalArgumentException("Can process only arrays of N * N");
        }
//        System.out.println("Before: ");
//        prn(matrix);
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][n-1-j] = matrix[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = res[i][j];
            }
        }
//        System.out.println("After: ");
//        prn(matrix);
    }

    /**
     * Print matrix
     * @param matrix matrix
     */
    static void prn(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
