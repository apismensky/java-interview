package com.octanner;

/**
 * Using TDD implement method and provide unit tests
 */
public class ArrayHelper {

    public static int[] reverse(int[] input) {
        //throw new UnsupportedOperationException("not implemented");
        if (input == null) {
            throw new IllegalArgumentException("argument can not be null");
        }
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
          result[input.length - i - 1] = input[i];
        }
        return result;
    }
}
