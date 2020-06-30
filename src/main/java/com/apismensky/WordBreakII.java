package com.apismensky;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 *
 * The naive approach to solve this problem is to use recursion.
 * For finding the solution, we check every possible prefix of that string (ss) in the dictionary of words,
 * if it is found in the dictionary (say s1), then the recursive function is called for the remaining portion of that string.
 * This function returns the prefix s1 appended by the result of the recursive
 * call using the remaining portion of the string (s-s1),
 * if the remaining portion is a substring which can lead to the formation
 * of a valid sentence as per the dictionary. Otherwise, empty list is returned.
 *
 * In the previous approach we can see that many subproblems were redundant,
 * i.e we were calling the recursive function multiple times for the same
 * substring appearing through multiple paths. To avoid this we can use memorization method,
 * where we are making use of a hashmap to store the results in the form of a key:valuekey:value pair.
 * In this hashmap, the keykey used is the starting index of the string currently considered and
 * the valuevalue contains all the sentences which can be formed using the substring
 * from this starting index onwards. Thus, if we encounter the same starting index from
 * different function calls, we can return the result directly from the
 * hashmap rather than going for redundant function calls.
 *
 * With memorization many redundant subproblems are avoided and recursion tree is
 * pruned and thus it reduces the time complexity by a large factor.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }

    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start))
            return map.get(start);
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length())
            res.add("");

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = wordBreak(s, wordDict, end);
                for (String l : list)
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
            }
        }
        map.put(start, res);
        return res;
    }
}
