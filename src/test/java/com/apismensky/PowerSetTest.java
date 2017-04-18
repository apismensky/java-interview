package com.apismensky;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.assertEquals;

public class PowerSetTest {

    private static final Set<Set<Integer>> PS0 = newHashSet();
    private static final Set<Set<Integer>> PS1 = newHashSet();
    private static final Set<Set<Integer>> PS2 = newHashSet();
    private static final Set<Set<Integer>> PS3 = newHashSet();

    static {
        PS0.add(Sets.<Integer>newHashSet());
        PS1.addAll(PS0);
        PS1.add(newHashSet(1));
        PS2.addAll(PS1);
        PS2.addAll(newHashSet(newHashSet(2), newHashSet(1,2)));
        PS3.addAll(PS2);
        PS3.addAll(newHashSet(newHashSet(3), newHashSet(1,3), newHashSet(2,3), newHashSet(1,2,3)));
    }

    @Test
    public void testEmpty() {
        assertEquals(PS0, PowerSet.powerSet(newHashSet()));
    }


    @Test
    public void test1() {
        assertEquals(PS1, PowerSet.powerSet(newHashSet(1)));
    }

    @Test
    public void test2() {
        assertEquals(PS2, PowerSet.powerSet(newHashSet(1, 2)));
    }

    @Test
    public void test3() {
        assertEquals(PS3, PowerSet.powerSet(newHashSet(1, 2, 3)));
    }

    @Test
    public void testEmpty2() {
        assertEquals(PS0, PowerSet.powerSet2(newHashSet()));
    }

    @Test
    public void test21() {
        assertEquals(PS1, PowerSet.powerSet2(newHashSet(1)));
    }

    @Test
    public void test22() {
        assertEquals(PS2, PowerSet.powerSet2(newHashSet(1, 2)));
    }

    @Test
    public void test23() {
        assertEquals(PS3, PowerSet.powerSet2(newHashSet(1, 2, 3)));
    }
}
