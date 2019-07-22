package com.apismensky;


import java.util.Arrays;

/**
 * Complexity: Medium
 * You are given an n x n 2D matrix representing an image.
 * <p/>
 * Rotate the image by 90 degrees (clockwise).
 * <p/>
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
    }

    /**
     *  1  2  3  4              13  9  5  1
     *  5  6  7  8  =>          14 10  6  2
     *  9 10 11 12              15 11  7  3
     * 13 14 15 16              16 12  8  4
     * @param matrix
     */
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1)/2; i++) {
            for (int j = 0; j < n / 2 ; j++) {
                int first = matrix[i][j];
                int second = matrix[j][n-1-i];
                int third = matrix[n-1-i][n-1-j];
                int fourth = matrix[n-1-j][i];
                matrix[i][j] = fourth;
                matrix[j][n-1-i] = first;
                matrix[n-1-i][n-1-j] = second;
                matrix[n-1-j][i] = third;
                prn(matrix);
            }
        }

    }

    /**
     * Print matrix
     * @param matrix matrix
     */
    static void prn(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
