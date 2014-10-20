package com.octanner;

/**
 * Using TDD implement method and provide unit tests
 */
public class ArrayHelper {
    /**
     * Reverse elements in the array.
     *
     * @param input array
     * @return reversed array
     * @throws IllegalArgumentException if argument is null
     */
    public static int[] reverse(int[] input) {
        //throw new UnsupportedOperationException("not implemented");
        if (input == null)
            throw new IllegalArgumentException("argument can not be null");
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++)
            result[input.length - i - 1] = input[i];
        return result;
    }

    /**
     * Searches the specified sorted array of integers for the specified value.
     * If it is not sorted, the results are undefined.
     * If the array contains multiple elements with the specified value, there is no guarantee which one will be found.
     * If the element is not found return -1
     * @param array the array to be searched
     * @param value the value to be searched for
     * @return index of the element
     * @throws IllegalArgumentException if first argument is null
     */
    public static int search(int[] array, int value) {
        //throw new UnsupportedOperationException("not implemented");
        if (array == null)
            throw new IllegalArgumentException("argument can not be null");
        //      trivial - why it is better to use binary search?
        //      for (int i = 0; i < array.length; i++)
        //         if (array[i] == key) return i;
        return search(array, value, 0, array.length - 1);
    }

    private static int search(int[] array, int value, int lower, int upper) {
        if (array.length == 0 || lower > upper)
            return -1;
        int center = lower + (upper - lower) / 2;
        if (array[center] == value) return center;
        else if (array[center] > value) return search(array, value, lower, center - 1);
        else return search(array, value, center + 1, upper);
    }
}
