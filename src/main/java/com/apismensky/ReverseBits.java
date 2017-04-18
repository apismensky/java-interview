package com.apismensky;

/**
 *
 * Reverse bits of a given 32 bits unsigned integer.

 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).

 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 32 - binaryString.length(); i++) sb.append('0');
        sb.append(binaryString);
        String padded = sb.toString();
        int result = 0;
        for (int i = 0; i < padded.length(); i++)
            if (padded.charAt(i) == '1') result = result | (1 << i);
        return result;
    }

}
