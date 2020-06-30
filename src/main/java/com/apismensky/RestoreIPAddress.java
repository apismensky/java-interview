package com.apismensky;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 *
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddress {
    private List<String> result;
    private String input;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        input = s;
        advance(new Stack<>());
        return result;
    }

    /**
     * Iterate over three available slots curr_pos to place a dot.
     * Check if the segment from the previous dot to the current one is valid
     *      : Yes : Place the dot.
     *          Check if all 3 dots are placed
     *          : Yes : Add the solution into the output list.
     *          No : Proceed to place next dots advance(curr_pos, dots - 1). Remove the last dot to advance.
     */
    public void advance(Stack<Integer> dots) {
        int prevDot = 0;
        if (!dots.empty()) {
            prevDot = dots.peek();
        }
        for (int i = 1; i <= 3; i++) {
            if (isValidSegment(prevDot, prevDot + i)) {
                dots.push(prevDot + i);
                if (isValidIP(dots)) {
                    result.add(calculateResult(dots));
                    //dots.removeAllElements();
                }
                else {
                    advance(dots);
                }

            }
            // backtrack
            if (!dots.isEmpty()) dots.pop();
        }
    }

    /**
     * Returns true if the segment of IP address is valid (i.e 1.34, 255 are valid, 01, 287 are invalid)
     */
    private boolean isValidSegment(int prevDot, int currDot) {
        String segment = input.substring(prevDot, currDot);
        Integer value = Integer.parseInt(segment);
        return  value >= 0 && value <= 255 && value.toString().equals(segment);
    }

    /**
     * split the string by dots check if it has 4 segments each segment is valid
     */
    private boolean isValidIP(Stack<Integer> dots) {

        if (dots.size() != 4 || dots.isEmpty()) {
            return false;
        }
        System.out.println("Found elements: " + dots);
//        while (!dots.isEmpty()) {
//            String segment = input
//        }
        return true;
    }

    private String calculateResult(Stack<Integer> dots) {
        return input;
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddress().restoreIpAddresses("25525511135"));

       // System.out.println(new NestedWeightListSumII().restoreIpAddresses("25525511135"));

    }

    static class Solution {
        int n;
        String s;
        LinkedList<String> segments = new LinkedList<String>();
        ArrayList<String> output = new ArrayList<String>();

        public boolean valid(String segment) {
    /*
    Check if the current segment is valid :
    1. less or equal to 255
    2. the first character could be '0'
    only if the segment is equal to '0'
    */
            int m = segment.length();
            if (m > 3) {
                return false;
            }
            return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
        }

        public void update_output(int curr_pos) {
    /*
    Append the current list of segments
    to the list of solutions
    */
            String segment = s.substring(curr_pos + 1, n);
            if (valid(segment)) {
                segments.add(segment);
                output.add(String.join(".", segments));
                segments.removeLast();
            }
        }

        public void backtrack(int prev_pos, int dots) {
    /*
    prev_pos : the position of the previously placed dot
    dots : number of dots to place
    */
            // The current dot curr_pos could be placed
            // in a range from prev_pos + 1 to prev_pos + 4.
            // The dot couldn't be placed
            // after the last character in the string.
            int max_pos = Math.min(n - 1, prev_pos + 4);
            for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
                String segment = s.substring(prev_pos + 1, curr_pos + 1);
                if (valid(segment)) {
                    segments.add(segment);  // place dot
                    if (dots - 1 == 0)      // if all 3 dots are placed
                    {
                        update_output(curr_pos);  // add the solution to output
                    } else {
                        backtrack(curr_pos, dots - 1);  // continue to place dots
                    }
                    segments.removeLast();  // remove the last placed dot
                }
            }
        }

        public List<String> restoreIpAddresses(String s) {
            n = s.length();
            this.s = s;
            backtrack(-1, 3);
            return output;

        }
    }
}
