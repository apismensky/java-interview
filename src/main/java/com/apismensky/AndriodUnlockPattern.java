package com.apismensky;

import java.util.Stack;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of
 * unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
 *
 *
 *
 * Rules for a valid pattern:
 *
 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously
 * selected in the pattern. No jumps through non selected key is allowed.
 * The order of keys used matters.
 *
 *
 * Explanation:
 *
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * Invalid move: 4 - 1 - 3 - 6
 * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 *
 * Invalid move: 4 - 1 - 9 - 2
 * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 *
 * Valid move: 2 - 4 - 1 - 3 - 6
 * Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
 *
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2
 * Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
 *
 *
 *
 * Example:
 *
 * Input: m = 1, n = 1
 * Output: 9
 */
public class AndriodUnlockPattern {

    private Stack<Integer> stack;
    private int count;
    private int n;

    public int numberOfPatterns(int m, int n) {
        count = 0;
        stack = new Stack<>();
        this.n = n;
        for (int len = m; len <= n; len++)
            advance(len);
        return count;
    }

    private void advance(int len) {
        for (int i = 1; i <= 9; i++) {
            if (isValid(i)) {
                stack.push(i);
                if (stack.size() == len) {
                    System.out.println(stack);
                    count++;
                }

                else
                    advance(len);
                if (!stack.isEmpty())
                    stack.pop();
            }
        }
    }

    private boolean isValid(int digit) {
        if (stack.contains(digit))
            return false;
        if (stack.isEmpty())
            return true;
        int last = stack.peek();
        // knight moves or adjacent cells (in a row or in a column)
        if ((digit + last) % 2 == 1)
            return true;
        // indexes are at both end of the diagonals for example 0,0, and 8,8
        int mid = (digit + last)/2;
        if (mid == 5)
            return stack.contains(mid);
        // adjacent cells on diagonal  - for example 0,0 and 1,0 or 2,0 and //1,1
        if ((digit % 3 != last % 3) && (digit / 3 != last / 3))
            return true;
        return stack.contains(mid);
    }


    public static void main(String[] args) {
        int number = new AndriodUnlockPattern().numberOfPatterns(1, 3);
        System.out.println(number);
    }

}
