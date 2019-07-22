package com.apismensky;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Complexity: Easy
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid
 but "(]" and "([)]" are not.
 */

public class ValidParentheses {

    private enum Matching {
        CURLY ('{', '}'),
        SQUARE('[', ']'),
        NORMAL('(', ')');

        private char l;
        private char r;

        Matching(char l, char r) {
            this.l = l;
            this.r = r;
        }

        static boolean isClosingAndMatch(char left, char right) {
            for (Matching each: Matching.values()) {
                if (each.l == left && right == each.r)
                    return true;
            }
            return false;
        }
    }

    public static boolean isValid(String s) {
        if (s == null)
            throw new IllegalArgumentException("Can not pass null");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                if (Matching.isClosingAndMatch(stack.peek(), c))
                    stack.pop();
                else
                    stack.push(c);
            }
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
