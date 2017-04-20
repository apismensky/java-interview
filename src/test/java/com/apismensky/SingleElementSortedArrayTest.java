package com.apismensky;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleElementSortedArrayTest {

    private SingleElementSortedArray c = new SingleElementSortedArray();

    @Test(expected = NullPointerException.class)
    public void testNull() {
        c.singleNonDuplicate(null);
    }

    @Test
    public void testOneElement() {
        assertEquals(0, c.singleNonDuplicate(new int[]{0}));
    }

    @Test
    public void test01() {
        assertEquals(0, c.singleNonDuplicate(new int[]{0,1,1}));
    }

    @Test
    public void test3Element() {
        assertEquals(2, c.singleNonDuplicate(new int[]{1,1,2}));
    }

    @Test
    public void test5Element() {
        assertEquals(5, c.singleNonDuplicate(new int[]{1,1,2,2,4,4,5}));
    }


    @Test
    public void test1() {
        assertEquals(5, c.singleNonDuplicate(new int[]{1,1,5,6,6,8,8}));
        assertEquals(6, c.singleNonDuplicate(new int[]{1,1,5,5,6,8,8}));
    }

    @Test
    public void test2() {
        assertEquals(10, c.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }

    @Test
    public void test3() {
        assertEquals(4, c.singleNonDuplicate(new int[]{1,1,2,2,3,3,4,6,6,7,7}));
    }

    @Test
    public void test4() {
        assertEquals(2, c.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }

}
