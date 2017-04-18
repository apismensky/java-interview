package com.apismensky;

/**
 *
 * Invert a binary tree.

      4
    /   \
   2     7
  / \   / \
 1   3 6   9

 to

      4
    /   \
   7     2
  / \   / \
 9   6 3   1

 */
public class InvertBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public boolean equals(Object other) {
            if (other != null
                    && (other instanceof TreeNode)) {
                TreeNode otherNode = (TreeNode) other;
                return (
                        otherNode.val == this.val
                        && ( (otherNode.left != null && otherNode.left.equals(this.left)) || (otherNode.left == null && this.left == null))
                        && ( (otherNode.right != null && otherNode.right.equals(this.right)) || (otherNode.right == null && this.right == null))
                );
            }
            return false;
        }

        @Override
        public String toString() {
            return traverseTree(this, "");
        }
    }


    public static TreeNode invertTree(TreeNode node) {
        if (node == null)
            return null;
        TreeNode left = invertTree(node.left);
        TreeNode right = invertTree(node.right);
        node.left = right;
        node.right = left;
        return node;
    }

    public static String traverseTree(TreeNode root, String acc) {
        if (root == null) return "";
        acc += traverseTree(root.left, acc);
        acc += "-" + root.val;
        acc += traverseTree(root.right, acc);
        return acc;
    }


}


