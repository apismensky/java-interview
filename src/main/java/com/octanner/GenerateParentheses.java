package com.octanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 * ((((,
 */

public class GenerateParentheses {

    private static final char L = '(';
    private static final char R = ')';


    public static List<String> generateParenthesis(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n can not be negative");

        }
        ArrayList<String> result = new ArrayList<String>();

// "))))))", ())))), )()))), (()))), ))())), )(()))

        for (int i = 0; i < n * 2; i++) {
            char[] arr = init(n);
            for (int j = 0; j < i; j++) {
                prn(arr);
                arr[j] = L;
                prn(arr);
//               if (isValid(seq)) {
//                   result.add(new String(seq));
//               }

            }
        }

        return result;
    }


    private static char[] init(int n) {
        char[] arr = new char[n * 2];
        for (int i = 0; i < n * 2; i++) {
            arr[i] = R;
        }
        return arr;
    }
    private static void prn(char[] chars) {
        for (char c : chars) {
            System.out.print(c);
        }
        System.out.println();
    }

    private static char[] construct(int i, int j) {
        return new char[0];
    }

    private static boolean isValid(char[] seq) {

        return true;
    }
}
