package com.apismensky;

import static com.apismensky.AllienDictionary.alienOrder;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class AllienDictionaryTest {

    @Test
    public void test1() {
        assertEquals("wertf", alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }

    @Test
    public void test2() {
        assertEquals("zx", alienOrder(new String[]{"z", "x"}));
    }

    @Test
    public void test3() {
        assertEquals("", alienOrder(new String[]{"z", "x", "z"}));
    }

    @Test
    @Ignore
    public void test4() {
        assertEquals("wrtq", alienOrder(new String[]{"wrtq", "wrt"}));
    }
}