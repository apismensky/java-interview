package com.apismensky;

import java.util.LinkedList;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 *                      1
 *                     / \
 *                    2   3
 *                   / \   \
 *                  4   5   7
 *                       \
 *                        6
 *                        ↑ (4)
 */
public class MaxDepthBinaryTree {

    public static int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(maxDepth(node.left) + 1, maxDepth(node.right) + 1);
    }

    public static void BFS(TreeNode node) {
        java.util.Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            System.out.println(current);
            if (current.left != null) {
                q.add(current.left);
            }
            if (current.right != null) {
                q.add(current.right);
            }
        }
    }

    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.println(node);
        preOrder(node.right);
    }

    public static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override public String toString() {
        return "TreeNode{" +
               "val=" + val +
               '}';
    }
}
