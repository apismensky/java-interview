package com.apismensky;

/**
 * [2147483647]
 *
 *         2
 *       1   4
 *
 */
public class VBT {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
    }

    private static boolean traverse(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min || max != null && node.val >= max) {
            return false;
        }
        return traverse(node.left, min, node.val) && traverse(node.right, node.val, max);
    }
}
