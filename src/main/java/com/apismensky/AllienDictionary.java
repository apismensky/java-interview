package com.apismensky;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 *
 * Example 1:
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 * Example 2:
 *
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * Output: "zx"
 * Example 3:
 *
 * Input:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 *
 * Output: ""
 *
 * Explanation: The order is invalid, so return "".
 * Note:
 *
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 *
 *
 */
public class AllienDictionary {
    public static String alienOrder(String[] strings) {

        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> next = new HashMap<>();

        /*
         *  First, build a degree map for each character in all the words:
         *
         *  w:0
         *  r:0
         *  t:0
         *  f:0
         *  e:0
         *
         */
        for (String s : strings) {
            for (char c : s.toCharArray()) {
                indegree.put(c, 0);
            }
        }

        /*
         * Then build the hashmap by comparing the adjacent words, the first character that is different between two adjacent words reflect the lexicographical order. For example:
         *
         *  "wrt",
         *  "wrf",
         *     first different character is 3rd letter, so t comes before f
         *
         *  "wrf",
         *  "er",
         *     first different character is 1rd letter, so w comes before e
         * The characters in set come after the key. x->y means letter x comes before letter y. x -> set: y,z,t,w means x comes before all the letters in the set. The final HashMap "map" looks like.
         *
         * t -> set: f
         * w -> set: e
         * r -> set: t
         * e -> set: r
         * and final HashMap "degree" looks like, the number means "how many letters come before the key":
         *
         * w:0
         * r:1
         * t:1
         * f:1
         * e:1
         *
         */
        // {"wrt", "wrf", "er", "ett", "rftt"}
        for (int i = 0; i < strings.length - 1; i++) {
            String word = strings[i];
            String nextWord = strings[i + 1];
            int minWordLen = Math.min(word.length(), nextWord.length());
            for (int j = 0; j < minWordLen; j++) {
                char c1 = word.charAt(j);
                char c2 = nextWord.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (next.containsKey(c1)) {
                        set = next.get(c1);
                    }
                    if (!set.contains(c2)) {
                        set.add(c2);
                        next.put(c1, set);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        System.out.println(indegree);

        /*
           Topological sort
         * L ← Empty list that will contain the sorted elements
         * S ← Set of all nodes with no incoming edge
         * while S is non-empty do
         *     remove a node n from S
         *     add n to tail of L
         *     for each node m with an edge e from n to m do
         *         remove edge e from the graph
         *         if m has no other incoming edges then
         *             insert m into S
         * if graph has edges then
         *     return error   (graph has at least one cycle)
         * else
         *     return L   (a topologically sorted order)
         */

        Queue<Character> roots = indegree
            .keySet()
            .stream()
            .filter(c -> indegree.get(c) == 0)
            .distinct()
            .collect(Collectors.toCollection(LinkedList::new));

        StringBuilder result = new StringBuilder();

        while (!roots.isEmpty()) {
            Character current = roots.poll();
            result.append(current);
            Set<Character> nexts = next.get(current);
            if (nexts == null)
                continue;

            for (Character nxt : nexts) {
                indegree.compute(nxt, (key, val) -> val - 1);
                if (indegree.get(nxt) == 0) {
                    roots.add(nxt);
                } else {
                    result.append(nxt);
                }
            }
        }
        System.out.println(indegree);
        System.out.println(next);
        return result.toString();
    }

    public static void main(String[] args) {

        String s = alienOrder(new String[] {"wrt", "wrf", "er", "ett", "rftt"});
        System.out.println(s);
    }
}
