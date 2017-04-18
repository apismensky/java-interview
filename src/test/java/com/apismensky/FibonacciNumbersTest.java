package com.apismensky;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciNumbersTest {

   // passing 0 should return empty array
   @Test
   public void testZero() {
       Assert.assertArrayEquals(new long[]{}, FibonacciNumbers.generate(0));
   }

    // passing negative number should produce IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testNegative() {
        FibonacciNumbers.generate(-1);
    }

    // passing 1 should return array of {1}
    @Test
    public void testOne() {
        Assert.assertArrayEquals(new long[]{1}, FibonacciNumbers.generate(1));
    }

    // passing 6 should return array of {1,1,2,3,5,8}
    @Test
    public void testSeq() {
        Assert.assertArrayEquals(new long[]{1,1,2,3,5,8}, FibonacciNumbers.generate(6));
    }
}
