package com.apismensky;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[words.length - 1 - i];
            if (word.length() == 0) {
                continue;
            }
            sb.append(word).append(" ");
        }

        return sb.toString().trim();
    }
}
