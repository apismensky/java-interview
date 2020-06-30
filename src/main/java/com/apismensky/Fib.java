package com.apismensky;

public class Fib {
    public static void main(String[] args) {
        // 0,1,1,2,3,5,8
        System.out.println(fib(45));

        System.out.println(fib2(45));
    }

    // top down dynamic
    public static long fib(int n) {
        return fib(n, new long[n + 1]);
    }

    // top down dynamic
    private static long fib(int n, long[] memo) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] == 0) {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        }
        return memo[n];
    }

    // bottom up dynamic
    public static long fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        long[] memo = new long[n];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n - 1] + memo[n - 2];
    }
}
