package com.apismensky.lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {
    /**
     * Adding new elements to the list should increase its size
     */
    @Test
    public void testAdd() {
        List<Long> list = new List<Long>();
        assertEquals(0, list.size());
        list.add(7L).add(9L);
        assertEquals(2, list.size());
        assertEquals(9L, list.get(0).longValue());
        assertEquals(new Long(7), list.get(1));
    }

    /**
     * Calling get method with negative argument should produce IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNegative() {
        new List<Long>().get(-1);
    }

    /**
     * Calling get method with index >= size() should produce IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmpty() {
        new List<Long>().get(0);
    }

    /**
     * Calling get method with index >= size() should produce IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBound() {
        new List<Long>(6L).get(1);
    }

    /**
     * toString method on the empty list should produce {}
     */
    @Test
    public void testToStringEmpty() {
        assertEquals("{}", new List<Long>().toString());
    }

    /**
     * toString method for List(7L) should produce {7}
     */
    @Test
    public void testToStringOne() {
        List list = new List<Long>(7L);
        assertEquals(1, list.size());
        assertEquals("{7}", list.toString());
    }

    /**
     * toString method for list with multiple should work but the list values may be reversed
     */
    @Test
    public void testToStringMany() {
        List list = new List<Long>(7L,8L);
        assertEquals(2, list.size());
        assertEquals("{8,7}", list.toString());
    }

    /**
     * Non null List is not equals to null
     */
    @Test
    public void testEqualsNull() {
        assertNotEquals(new List(), null);
    }

    /**
     * A List instance is not equal to the object of the type other than list
     */
    @Test
    public void testEqualsOtherType() {
        assertNotEquals(new List(), "Foo");
    }

    /**
     * Two empty lists are equals
     */
    @Test
    public void testEqualsEmpty() {
        assertEquals(new List(), new List());
    }

    /**
     * Lists that don't have same elements but the same size are not equal
     */
    @Test
    public void testEqualsFalse() {
        assertNotEquals(new List<Integer>(1, 2, 3), new List<Integer>(2, 3, 4));
    }

    /**
     * Lists that have same number of elements and all elements are equal should be equal
     */
    @Test
    public void testEqualsTrue() {
        assertEquals(new List<Integer>(1, 2, 3), (new List<Integer>(1, 2, 3)));
    }

    /**
     * Lists with different number of elements are not equal
     */
    @Test
    public void testEqualsDifferentNumber() {
        assertNotEquals(new List<Integer>(1, 2, 3, 3), new List<Integer>(1, 2, 3));
    }

    /**
     * Lists containing nulls are not equal
     */
    @Test
    public void testEqualsWithNull() {
        assertNotEquals(new List<Integer>(1, null, 3), (new List<Integer>(1, null, 3)));
    }

    /**
     * If lists are equal their hashCode are equal
     */
    @Test
    public void testHashCodeEquals() {
        List first = new List<Integer>(1, 2, 3);
        List second = new List<Integer>(1, 2, 3);
        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    /**
     * Hash code method should return value !=0 even if one of the elements is null
     */
    @Test
    public void testHashCodeWithNull() {
        List list = new List<Integer>(1, null, 3);
        assertTrue(list.hashCode() != 0);
    }

    /**
     * Removing elements with negative index argument should produce IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteNegative() {
        new List().remove(-1);
    }

    /**
     * Removing elements when index >= size() argument should produce IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteBiggerThanMaxIndex() {
        new List().remove(1);
    }

    /**
     * Removing the element from one-element list should return empty list
     */
    @Test
    public void testDeleteOneElem() {
        List list = new List<Long>(5L);
        assertEquals(5L, list.remove(0));
        assertEquals(0, list.size());
    }

    /**
     * Removing element from the middle of the list should "shift" the remaining elements
     */
    @Test
    public void testDeleteMiddle() {
        List<Long> list = new List<Long>(5L,3L,1L,4L,7L);
        assertEquals(4, list.remove(1).longValue());
        assertEquals(new List<Long>(5L,3L,1L,7L), list);
    }

    /**
     * Removing head element should work
     */
    @Test
    public void testDeleteHead() {
        List<Long> list = new List<Long>(5L,3L,1L,4L,7L);
        assertEquals(7L, list.remove(0).longValue());
        assertEquals(new List<Long>(5L,3L,1L,4L), list);
    }

    /**
     * Removing tail element should work
     */
    @Test
    public void testDeleteTail() {
        List<Long> list = new List<Long>(5L,3L,1L,4L,7L);
        assertEquals(5L, list.remove(4).longValue());
        assertEquals(new List<Long>(3L,1L,4L,7L), list);
    }

    /**
     * IndexOf null should return -1 even if the list contains null
     */
    @Test
    public void testIndexOfNull() {
        assertEquals(-1, new List<Long>(null, 1L).indexOf(null));
    }

    /**
     * IndexOf in empty list should return -1
     */
    @Test
    public void testIndexEmpty() {
        assertEquals(-1, new List<Long>().indexOf(1L));
    }

    /**
     * IndexOf should return correct index value if the element exists in the list
     */
    @Test
    public void testIndexFound() {
        assertEquals(1, new List<Integer>(1,2,4).indexOf(2));
    }

    /**
     * IndexOf should return -1 if the element does not exists in the list
     */
    @Test
    public void testIndexNotFound() {
        assertEquals(-1, new List<Integer>(1, 2, 4).indexOf(7));
    }

    @Test
    public void testMap() {
        assertEquals(new List<Integer>(8, 4, 2), new List<Integer>(1, 2, 4).map(new Function<Integer>() {
            public Integer apply(Integer o) {
                return o * 2;
            }
        }));
    }
}
