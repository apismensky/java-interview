package com.apismensky;


/**
 * Given a sorted array consisting of only integers where every
 * element appears twice except for one element which appears once.
 * Find this single element that appears only once.
 * <p>
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * <p>
 * Input: [1,1,2,2,3,3,4,6,6,7,7]
 * Output: 4
 * <p>
 * Note: Your solution should run in O(log n) time and O(1) space.
 */

public class SingleElementSortedArray {
    public int singleNonDuplicate(int[] n) {
        int l = 0, r = n.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m == 0 || m == n.length - 1 || n[m] != n[m - 1] && n[m] != n[m + 1])
                return n[m];
            boolean odd = m % 2 == 1;
            if (n[m - 1] == n[m])
                if (odd) l = m + 1;
                else r = m - 1;
             else
                if (odd) r = m - 1;
                else l = m + 1;
        }
        throw new IllegalArgumentException("No single element");
    }
}
