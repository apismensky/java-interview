package com.apismensky;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression.
 * You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F
 * (T and F represent True and False respectively).
 *
 * Note:
 *
 * The length of the given string is ≤ 10000.
 * Each number will contain only one digit.
 * The conditional expressions group right-to-left (as usual in most languages).
 * The condition will always be either T or F. That is, the condition will never be a digit.
 * The result of the expression will always evaluate to either a digit 0-9, T or F.
 * Example 1:
 *
 * Input: "T?2:3"
 *
 * Output: "2"
 *
 * Explanation: If true, then result is 2; otherwise result is 3.
 * Example 2:
 *
 * Input: "F?1:T?4:5"
 *
 * Output: "4"
 *
 * Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
 *
 *              "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
 *           -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
 *           -> "4"                                    -> "4"
 * Example 3:
 *
 * Input: "T?T?F:5:3"
 *
 * Output: "F"
 *
 * Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
 *
 *              "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
 *           -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
 *           -> "F"                                    -> "F"
 *
 */
public class TernaryExpressionParser {
    private static final Pattern PATTERN = Pattern.compile(".*(([TF])\\?([0-9TF])\\:([0-9TF]))");

    public static String parseTernaryRegex(String expression) {
        while (expression.length() > 1) {
            Matcher matcher = PATTERN.matcher(expression);
            if (matcher.find()) {
                String value = matcher.group(2).equals("T") ? matcher.group(3) : matcher.group(4);
                int i = expression.lastIndexOf(matcher.group(1));
                expression = expression.substring(0, i) + value + expression.substring(i + 5);
            }
            else
                throw new IllegalArgumentException("Invalid expression: " + expression);
        }
        return expression;
    }

    public static String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] chars = expression.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            char current = chars[i];
            if (!stack.empty() && stack.peek() == '?') {
                stack.pop(); // ?
                Character second = stack.pop();
                stack.pop(); // :
                Character third = stack.pop();
                Character value = current == 'T' ? second : third;
                stack.push(value);
            }
            else {
                stack.push(current);
            }
        }
        return stack.pop().toString();
    }
}
