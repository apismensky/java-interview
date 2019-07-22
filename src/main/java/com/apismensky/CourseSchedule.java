package com.apismensky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * <p/>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * <p/>
 * Given the total number of courses and a list of prerequisite pairs,
 * is it possible for you to finish all courses?
 * <p/>
 * For example:
 * <p/>
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * <p/>
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0,
 * and to take course 0 you should also have finished course 1. So it is impossible.
 * <p/>
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.

 *
 */
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) {
            return true;
        }

        if (numCourses < 0) {
            throw new IllegalArgumentException("numCourses can not be negative");
        }

        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> next = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            indegree[pair[1]]++;
            List<Integer> linked = next.get(pair[0]);
            if (linked == null) {
                List<Integer> connected = new ArrayList<>();
                connected.add(pair[1]);
                next.put(pair[0], connected);
            }
            else {
                linked.add(pair[1]);
            }
        }

        Queue<Integer> roots = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                roots.add(i);
            }
        }

        List<Integer> traversal = new ArrayList<>();
        while (!roots.isEmpty()) {
            Integer current = roots.poll(); // current root node
            traversal.add(current);
            List<Integer> nextNodes = next.get(current);
            if (nextNodes == null) {
                continue;
            }
            for (Integer nextNode: nextNodes) {
                indegree[nextNode]--;
                if (indegree[nextNode] == 0) {
                    roots.add(nextNode);
                }
            }
        }

        return numCourses == traversal.size();
    }

}
