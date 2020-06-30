package com.apismensky;

import java.util.Arrays;

/**
 * A child is running up a stair case with n steps and can hop either 1,2 or 3 steps at the time. Implement a method to count how many
 * possible ways the child can run up the stairs
 */
public class TripleStep {

    public static void main(String[] args) {
        // 4 = 1111, 121, 211, 112, 22, 13, 31  =  7
        long start = System.currentTimeMillis();
        System.out.println(compute(35));
        System.out.println("Took: " + (System.currentTimeMillis() - start) + " ms");
        long start1 = System.currentTimeMillis();
        System.out.println(compute2(35));
        System.out.println("Took: " + (System.currentTimeMillis() - start1) + " ms");
    }

    private static int compute(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i <= 3; i++) {
            result += compute(n - i);
        }
        return result;
    }

    private static int compute2(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return computeMemo(n, memo);
    }

    private static int computeMemo(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }
        if (memo[n] == -1) {
            int result = 0;
            for (int i = 1; i <= 3; i++) {
                result += computeMemo(n - i, memo);
            }
            memo[n] = result;
        }
        return memo[n];
    }

}
