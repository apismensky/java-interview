package com.apismensky;

/**
 * A prime number is a natural number that has exactly two distinct natural number divisors: 1 and itself.
 * Count the number of prime numbers less than a non-negative number, n
 * <p/>
 * Solution by Sieve of Eratosthenes algorithm https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 */
public class PrimeNumber {
    /**
     * Count the number of prime numbers less than a non-negative number, n
     *
     * @param n non negative number
     * @return number of primes less than n
     */
    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++)
            primes[i] = true;
        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int j = i * 2; j < n; j += i)
                    primes[j] = false;
            }
        }
        int count = 0;
        for (boolean prime : primes)
            if (prime) count++;
        return count;
    }
}
