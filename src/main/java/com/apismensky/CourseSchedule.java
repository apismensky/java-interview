package com.apismensky;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
 */
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0)
            throw new IllegalArgumentException("numCourses < 0");
        if (prerequisites.length > 0)
            for (int[] p : prerequisites)
                if (p.length != 2)
                    throw new IllegalArgumentException("Invalid prerequisites: one ore more edges contains !=2 elements");


        if (prerequisites.length == 0 || numCourses == 0)
            return true;

        // Structure that represents prerequisites
        // Key is the number of the course, Set<Integer> - set of prerequisites
        Map<Integer, Set<Integer>> adj = new HashMap<Integer, Set<Integer>>();
        for (int[] p : prerequisites) {
            if (!adj.containsKey(p[0])) adj.put(p[0], new HashSet<Integer>());
            Set<Integer> prereq = adj.get(p[0]);
            prereq.add(p[1]);
            adj.put(p[0], prereq);
        }
        boolean visited[] = new boolean[numCourses-1];
        int count = 0;
        for (Integer key: adj.keySet()) {
            count++;
            visited[key] = true;
            DFS(adj.get(key), adj, visited);
        }
        System.out.println(adj);

        return false;
    }

    public static class TreeNode {
        private final int course;
        private Set<TreeNode> prerequisites;

        public TreeNode(int course) {
            this.course = course;
            this.prerequisites = new HashSet<TreeNode>();
        }

        public int getCourse() {
            return this.course;
        }

    }

    /**
     *
     */
    private static  void DFS(Set prereq, Map<Integer, Set<Integer>> adj, boolean[] visited) {

    }
}
