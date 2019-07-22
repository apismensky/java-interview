package com.apismensky;

import java.util.HashSet;
import java.util.Set;

public class FindSum {

    private static class Pair {
        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
        int l;
        int r;

        @Override
        public String toString() {
            return "[" + l + "," + r + "]";
        }
    }
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7};
        int sum = 6;
        Set<Pair> pairs = getPair(input, sum);
        System.out.println(pairs);
    }

    public static Set<Pair> getPair(int[] input, int sum) {
        Set<Pair> result = new HashSet<>();
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            numbers.add(input[i]);
            int target = sum - input[i];
            if (numbers.contains(target)) {
                result.add(new Pair(target, input[i]));
            }
        }
        return result;
    }
}
