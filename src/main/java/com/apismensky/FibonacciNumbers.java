package com.apismensky;


public class FibonacciNumbers {
    /**
     * Complexity: Easy
     *
     * Generate array of fibonacci numbers
     * 1,1,2,3,5,8 ...
     * where F(N) = F(N-1) + F(N-2)
     * Use TDD - write tests first and then provide implementation
     *
     * @param size array size
     * @return array consisting of fibonacci numbers
     */
    public static long[] generate(int size) {
        //throw new UnsupportedOperationException("not implemented");
        if (size < 0)
            throw new IllegalArgumentException("Array size can not be negative");
        long[] result = new long[size];
        if (size > 0) result[0] = 1;
        for (int i = 1; i < size; i++) {
            long fn_1 = result[i - 1];
            long fn_2 = (i == 1) ? 0 : result[i - 2];
            result[i] = fn_1 + fn_2;
        }
        return result;
    }


}
