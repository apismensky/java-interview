package com.apismensky;

public class PowerOf {
    static long maxPower2 = 2l;
    static long maxPower3 = 3l;
    static long maxPower4 = 4l;

    static {

        while (maxPower2 * 2 <= Integer.MAX_VALUE)
            maxPower2 *= 2;
        System.out.println("maxPower2: " + maxPower2);

        while (maxPower3 * 3 <= Integer.MAX_VALUE)
            maxPower3 *= 3;
        System.out.println("maxPower3: " + maxPower3);

        while (maxPower4 * 4 <= Integer.MAX_VALUE)
            maxPower4 *= 4;
        System.out.println("maxPower4: " + maxPower4);
    }


    public boolean isPowerOfThree(int n) {
         return n > 0 && maxPower3 % n == 0;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && maxPower2 % n == 0;
    }

    public boolean isPowerOfFour(int n) {
        int sqrt = (int) Math.sqrt(n);
        return n == 1 || n >= 4 && sqrt * sqrt == n && n % 4 == 0;
    }

}
