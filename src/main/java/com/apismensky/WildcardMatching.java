package com.apismensky;

import java.util.regex.Pattern;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 */
public class WildcardMatching {
    public static boolean isMatch(String str, String pattern) {
        return Pattern.compile(pattern.replaceAll("\\*+", "[a-z]*").replace("?", "[a-z]"))
                      .matcher(str)
                      .matches();
    }
}