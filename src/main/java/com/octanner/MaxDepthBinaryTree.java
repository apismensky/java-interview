package com.octanner;

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

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
