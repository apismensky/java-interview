package com.apismensky;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LRUCacheIntTest {


    private LRUCacheInt cache;

    @Before
    public void init() {
        cache = new LRUCacheInt(2);
    }

    @Test
    public void testNotFound() {
        cache.put(1, 4);
        assertEquals(-1, cache.get(2));
    }

    @Test
    public void testFound() {
        cache.put(1, 2);
        assertEquals(2, cache.get(1));
    }

    /*
      ["LRUCache","put","put","get","put","get","put","get","get","get"]
      [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     */
    @Test
    public void test1() {

        cache.put(1, 1);
        validate("LRU", cache.lruNode, newArrayList(1));
        validate("MRU", cache.mruNode, newArrayList(1));
        cache.put(2, 2);
        validate("LRU", cache.lruNode, newArrayList(1,2));
        validate("MRU", cache.mruNode, newArrayList(2, 1));
        assertEquals(1, cache.get(1));

        validate("LRU", cache.lruNode, newArrayList(2,1));
        validate("MRU", cache.mruNode, newArrayList(1,2));

        cache.put(3, 3);

        validate("LRU", cache.lruNode, newArrayList(1, 3));
        validate("MRU", cache.mruNode, newArrayList(3, 1));

        assertEquals(-1, cache.get(2));

        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    public void test2() {
        cache = new LRUCacheInt(1);
        cache.put(1, 1);
        validate("LRU", cache.lruNode, newArrayList(1));
        validate("MRU", cache.mruNode, newArrayList(1));
        cache.put(2, 2);
        validate("LRU", cache.lruNode, newArrayList(2));
        validate("MRU", cache.mruNode, newArrayList(2));
    }

    @Test
    public void test4() {
        cache = new LRUCacheInt(2);
        cache.put(1, 1);
        validate("LRU", cache.lruNode, newArrayList(1));
        validate("MRU", cache.mruNode, newArrayList(1));
        cache.put(2, 2);
        validate("LRU", cache.lruNode, newArrayList(1, 2));
        validate("MRU", cache.mruNode, newArrayList(2, 1));
    }

    /**
     * ["LRUCache","put","get","put","get","get"]
     [[1],[2,1],[2],[3,2],[2],[3]]
     */
    @Test
    public void test3() {
        cache = new LRUCacheInt(1);
        cache.put(2, 1);
        validate("LRU", cache.lruNode, newArrayList(2));
        validate("MRU", cache.mruNode, newArrayList(2));
        assertEquals(1, cache.get(2));
        validate("LRU", cache.lruNode, newArrayList(2));
        validate("MRU", cache.mruNode, newArrayList(2));

        cache.put(3, 2);
        assertEquals(-1, cache.get(2));
        assertEquals(2, cache.get(3));
    }


    @Test
    public void test5() {
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        validate("MRU", cache.mruNode, newArrayList(3, 2));
        validate("LRU", cache.lruNode, newArrayList(2, 3));
        assertEquals(3, cache.get(3));
        validate("MRU", cache.mruNode, newArrayList(3, 2));
        validate("LRU", cache.lruNode, newArrayList(2, 3));
    }

    @Test
    public void test6() {
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        validate("MRU", cache.mruNode, newArrayList(1, 2));
        validate("LRU", cache.lruNode, newArrayList(2, 1));
    }

    @Test
    public void test7() {
        cache = new LRUCacheInt(4);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);

        validate("MRU", cache.mruNode, newArrayList(4, 3, 2, 1));
        validate("LRU", cache.lruNode, newArrayList(1, 2, 3, 4));


        assertEquals(3, cache.get(3));
        validate("MRU", cache.mruNode, newArrayList(3, 4, 2, 1));
        validate("LRU", cache.lruNode, newArrayList(1, 2, 4, 3));

    }

    /**
     * ["LRUCache","put","put","get","put","put","get"]
     [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
     */
    @Test
    public void test8() {
        cache.put(2, 1);
        cache.put(2, 2);

        assertEquals(2, cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        assertEquals(-1, cache.get(2));
    }

    /**
     * ["LRUCache","put","put","put","put","get","get"]
     [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
     */

    @Test
    public void test9() {
        cache.put(2, 1);
        cache.put(1, 1);
        validate("MRU", cache.mruNode, newArrayList(1, 2));
        validate("LRU", cache.lruNode, newArrayList(2, 1));
        cache.put(2, 3);
        validate("MRU", cache.mruNode, newArrayList(2, 1));
        validate("LRU", cache.lruNode, newArrayList(1, 2));
        cache.put(4, 1);
        validate("MRU", cache.mruNode, newArrayList(4, 2));
        validate("LRU", cache.lruNode, newArrayList(2, 4));
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }

    /**
      ["LRUCache","get","put","get","put","put","get","get"]
      [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
     */
    @Test
    public void test11() {
        cache.put(2, 6);
        cache.put(1, 5);

        validate("MRU", cache.mruNode, newArrayList(1, 2));
        validate("LRU", cache.lruNode, newArrayList(2, 1));

        cache.put(1, 2);
        validate("LRU", cache.lruNode, newArrayList(2, 1));
        validate("MRU", cache.mruNode, newArrayList(1, 2));


        assertEquals(2, cache.get(1));
        assertEquals(6, cache.get(2));
    }

    private void validate(String label, LRUCacheInt.Node node, List<Integer> expectedKeys) {
        System.out.print(label + ": ");
        Set<LRUCacheInt.Node> visited = new HashSet<LRUCacheInt.Node>();
        int count = 0;
        LRUCacheInt.Node current = node;
        while (current != null) {
            System.out.print(current);
            if (visited.contains(current))
                fail("Cycle found");
            else
                visited.add(current);

            String arrow;

            if (count >= expectedKeys.size())
                fail("expected list contains " + expectedKeys.size() + ", but actual list has at least " + (count + 1) + " element(s)");

            if (!expectedKeys.get(count).equals(current.getKey()))
                fail("Wrong key found at index " + count + ": " + current.getKey());

            if ("MRU".equals(label)) {
                current = current.getNext();
                arrow = " -> ";
            }
            else {
                current = current.getPrev();
                arrow = " <- ";
            }
            if (current != null)
                System.out.print(arrow);

            count++;

        }
        if (count!=expectedKeys.size())
            fail("Count does not match, expected: " + expectedKeys.size() + ", but was: " + count);
        System.out.println();
    }


}
