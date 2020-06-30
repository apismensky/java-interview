package com.apismensky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 */

class ReorderLogFiles {
    private static final Pattern PATTERN_DIGIT = Pattern.compile("^[0-9a-z]+ [0-9]+.*");
    private static final Pattern PATTERN_LETTER = Pattern.compile("^([0-9a-z]+) ([a-z]+.*)$");

    public String[] reorderLogFiles(String[] logs) {

        if (logs == null || logs.length < 2) return logs;

        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs  = new ArrayList<>();

        for (String log: logs) {
            Matcher matcherDigit = PATTERN_DIGIT.matcher(log);
            Matcher matcherLetter = PATTERN_LETTER.matcher(log);
            if (matcherDigit.matches()) {
                digitLogs.add(log);
            } else if (matcherLetter.matches()) {
                letterLogs.add(log);
            }
        }
        letterLogs.sort((s1, s2) -> {
            Matcher m1 = PATTERN_LETTER.matcher(s1);
            Matcher m2 = PATTERN_LETTER.matcher(s2);
            if (m1.matches() && m2.matches()) {
                return (m1.group(2) + m1.group(1)).compareTo(m2.group(2) + m2.group(1));
            }
            return 0;
        });
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] input = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] strings = new ReorderLogFiles().reorderLogFiles(input);
        System.out.println(Arrays.toString(strings));
    }
}