package com.apismensky;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {


    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                if (stack.peek() == '(' && c == ')')
                    stack.pop();
                else
                    stack.push(c);
            }
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }

    public int longestValidParentheses(String s) {

        return 0;
    }

    public static void main(String[] args) {
        String input = ")()())";
        int validParentheses = new LongestValidParentheses().longestValidParentheses(input);
        System.out.println(validParentheses);
    }
}
