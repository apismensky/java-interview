package com.apismensky;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeVerticalOrder {

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<TreeNode>> levels = new TreeMap<>();
        traverse(root, 0, levels);
        return transform(levels);
    }

    private static List<List<Integer>> transform(Map<Integer, List<TreeNode>> levels) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> lvls = levels.keySet();
        for (Integer lvl : lvls) {
            List<Integer> treeValues = levels
                .get(lvl)
                .stream()
                .map(treeNode -> treeNode.val)
                .collect(Collectors.toList());
            result.add(treeValues);
        }
        return result;
    }

    private static void traverse(TreeNode node, int level, Map<Integer, List<TreeNode>> levels) {
        if (node == null) {
            return;
        }
        System.out.println("Node: " + node.val);
        System.out.println("Level: " + level);
        List<TreeNode> nodes = levels.get(level);
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(node);
        levels.put(level, nodes);
        traverse(node.left, level - 1, levels);
        traverse(node.right, level + 1, levels);
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        t3.left = t9;
        t3.right = t20;
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        t20.left = t15;
        t20.right = t7;
        List<List<Integer>> order = verticalOrder(t3);
        System.out.println(order);
    }

}
