package com.octanner;

import com.google.common.base.Preconditions;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p/>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * <p/>
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */
public class ArrayIntersect {

    public int[] intersectInt(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap1 = countMap(nums1);
        Map<Integer, Integer> countMap2 = countMap(nums2);
        List<Integer> result = new ArrayList<Integer>();

        for (Integer key : countMap1.keySet()) {
            Integer count1 = countMap1.get(key);
            Integer count2 = countMap2.get(key);
            if (count2 != null) {
                for (int i = 0; i < Math.min(count1, count2); i++)
                    result.add(key);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            res[i] = result.get(i);
        return res;
    }

    public static <T> T[] intersect(T[] o1, T[] o2) {
        Preconditions.checkNotNull(o1, "First element should not be null");
        Preconditions.checkNotNull(o2, "Second element should not be null");

        Map<T, Integer> countMap1 = countMap(o1);
        Map<T, Integer> countMap2 = countMap(o2);
        List<T> result = new ArrayList<T>();

        for (T key : countMap1.keySet()) {
            Integer count1 = countMap1.get(key);
            Integer count2 = countMap2.get(key);
            if (count2 != null) {
                for (int i = 0; i < Math.min(count1, count2); i++)
                    result.add(key);
            }
        }
        return (T[]) result.toArray();
    }

    private static <T> Map<T, Integer> countMap(T[] elements) {
        Map<T, Integer> count = new HashMap<T, Integer>();
        for (T each : elements) {
            Integer value = count.get(each);
            if (value == null)
                count.put(each, 1);
            else
                count.put(each, value + 1);
        }
        return count;
    }

    private static Map<Integer, Integer> countMap(int[] elements) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int each : elements) {
            Integer value = count.get(each);
            if (value == null)
                count.put(each, 1);
            else
                count.put(each, value + 1);
        }
        return count;
    }
}
