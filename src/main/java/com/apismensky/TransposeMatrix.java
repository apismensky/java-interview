package com.apismensky;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] transposed = transpose(input);
        for (int[] each: transposed) {
            System.out.println(Arrays.toString(each));
        }
    }

    public static int[][] transpose(int[][] input) {
        int[][] res = new int[input[0].length][input.length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                res[i][j] = input[j][i];
            }
        }
        return res;
    }
}