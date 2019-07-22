package com.apismensky;

public class BalancedBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return false;
    }

    public int depth(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
