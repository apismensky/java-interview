package com.apismensky;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class AllienDictionary {
    public static String alienOrder(String[] words) {

        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> next = new HashMap<>();

        for (String s : words) {
            for (char c : s.toCharArray()) {
                indegree.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            String nextWord = words[i + 1];
            int minWordLen = Math.min(word.length(), nextWord.length());
            for (int j = 0; j < minWordLen; j++) {
                char c1 = word.charAt(j);
                char c2 = nextWord.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (next.containsKey(c1))
                        set = next.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        next.put(c1, set);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

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
            if (nexts == null) {
                continue;
            }

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

    public static String alienOrder2(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<>();
        Map<Character, Integer> degree=new HashMap<>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }
}
