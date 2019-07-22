package com.apismensky;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    public static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        permutations("ABC", "");
        System.out.println(result);
    }

    public static void permutations(String input, String permutation) {
        if (input == null) {
            return;
        }

        if (input.equals("")) {
            result.add(permutation);
            System.out.println("Permutation: " + permutation);
        }

        for (int i = 0; i < input.length(); i++ ) {
            char currentChar = input.charAt(i);

            System.out.println("currentChar: " + currentChar);

            String before = input.substring(0, i);
            System.out.println("before: " + before);

            String after = input.substring(i + 1);
            System.out.println("after: " + after);

            permutations(before + after, permutation + currentChar);
        }
    }

}
