package com.apismensky;

import java.util.Arrays;

public class ReverseArrayInPlace {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8,9};
        reverseInPlace(input);
        System.out.println(Arrays.toString(input));

        int[] input2 = {1,2,3,4,5,6,7,8};
        reverseInPlace(input2);
        System.out.println(Arrays.toString(input2));
    }

    public static void reverseInPlace(int [] arr) {
        int len = arr.length;
        int median = arr.length / 2;
        System.out.println("median: " + median);

        for (int i = 0; i < median; i++) {
            int temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
    }
}