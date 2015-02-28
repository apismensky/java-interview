package com.octanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MajorityElementTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        MajorityElement.majorityElement(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmpty() {
        MajorityElement.majorityElement(new int[]{});
    }

    @Test
    public void test1Element() {
        assertEquals(10, MajorityElement.majorityElement(new int[]{10}));
    }

    @Test
    public void test3Elements() {
        assertEquals(4, MajorityElement.majorityElement(new int[]{4,5,4}));
    }


    @Test
    public void test10Elements() {
        assertEquals(3, MajorityElement.majorityElement(new int[]{1,3,3,1,3,4,3,2,3,3}));
    }
}
