package com.apismensky;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 1) Initialize list of BSTs as empty.
 * 2) For every number i where i varies from 1 to N, do following
 * ......a)  Create a new node with key as 'i', let this node be 'node'
 * ......b)  Recursively construct list of all left subtrees.
 * ......c)  Recursively construct list of all right subtrees.
 * 3) Iterate for all left subtrees
 *    a) For current leftsubtree, iterate for all right subtrees
 *         Add current left and right subtrees to 'node' and add
 *         'node' to list.
 */

public class UniqueBinarySearchTrees {
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public int getVal() {
            return val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        TreeNode(int x,
                 TreeNode left,
                 TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                   "val=" + val +
                   '}';
        }
    }

    public static List<TreeNode> getTrees(int num) {
        if (num == 0) {
            return new ArrayList<>();
        }
        return getTrees(1, num);
    }

    private static List<TreeNode> getTrees(int from, int to) {
        List<TreeNode> result = new ArrayList<>();
        if (from > to) {
            result.add(null);
            return result;
        }
        for (int i = from; i <= to; i++) {
            List<TreeNode> leftNodes = getTrees(from, i - 1);
            List<TreeNode> rightNodes = getTrees(i + 1, to);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    result.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> trees = getTrees(4);
        for (TreeNode tree : trees) {
            traverse(tree);
            System.out.println();
        }

        System.out.println("numTrees: " + numTrees(6));
    }

    private static void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + ",");
        traverse(node.left);
        traverse(node.right);
    }

    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
