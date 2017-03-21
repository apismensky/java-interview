package com.octanner;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

/**
 * Power Set Power set P(S) of a set S is the set of all subsets of S.
 * For example S = {a, b, c} then
 * P(S) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}.
 * <p/>
 * If S has n elements in it then P(s) will have 2^n elements
 */
public class PowerSet {

    public static <T> Set<Set<T>> powerSet(Set<T> input) {
        ArrayList<T> inp = newArrayList(input);
        int size = (int) Math.pow(2, input.size());
        Set<Set<T>> result = newHashSet();
        for (int i = 0; i < size; i++) {
            Set<T> r = newHashSet();
            for (int j = 0; j < input.size(); j++) {
                if(((i >> j) & 1) == 1)
                    r.add(inp.get(j));
            }
            result.add(r);
        }
        return result;
    }

    public static <T> Set<Set<T>> powerSet2(Set<T> input) {
        Set<Set<T>> result = newHashSet();
        result.add(Sets.<T>newHashSet());
        for (T each : input) { // For each element in the input
            // On each step we copy the existing superset from result and add a new element from outer loop
            Set<Set<T>> newResult = newHashSet();
            for (Set<T> found : result) {
                // New superset contains the old superset
                newResult.add(found);
                // Plus new extra elements with the current element from each
                Set<T> extraSet = newHashSet();
                extraSet.addAll(found);
                extraSet.add(each);
                newResult.add(extraSet);
            }
            result = newResult;
        }
        return result;
    }

}
