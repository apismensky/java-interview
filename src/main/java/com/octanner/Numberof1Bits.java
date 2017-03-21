package com.octanner;

/**
 * Write a function that takes an unsigned integer and returns
 * the number of ’1' bits it has (also known as the Hamming weight).

 * For example, the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 */
public class NumberOf1Bits {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int result = 0;
        String binaryString = Integer.toBinaryString(n);
        for (int i = 0; i < binaryString.length(); i++)
            if (binaryString.charAt(i) == '1') result ++;
        return result;
    }

    public static int hammingWeight1(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++)
            if (((n >> i) & 1) == 1) result ++;
        return result;
    }
}
