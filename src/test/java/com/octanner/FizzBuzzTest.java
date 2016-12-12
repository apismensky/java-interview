package com.octanner;

import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;
import static com.octanner.FizzBuzz.*; 

public class FizzBuzzTest {

    @Test
    public void testZero() {
        assertEquals(newArrayList(), fizzBuzz(0));
    }

    @Test
    public void testTwo() {
        assertEquals(newArrayList("1", "2"), fizzBuzz(2));
    }

    @Test
    public void testThree() {
        assertEquals(newArrayList("1", "2", FIZZ), fizzBuzz(3));
    }

    @Test
    public void testFive() {
        assertEquals(newArrayList("1", "2", FIZZ, "4", BUZZ), fizzBuzz(5));
    }

    @Test
    public void testFifteen() {
        assertEquals(newArrayList("1", "2", FIZZ, "4", BUZZ, FIZZ, "7", "8", FIZZ, BUZZ, "11", FIZZ, "13", "14", FIZZBUZZ), fizzBuzz(15));
    }

}
