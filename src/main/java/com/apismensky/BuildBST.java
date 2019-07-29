package com.apismensky;

import java.util.LinkedList;
import java.util.Queue;

public class BuildBST {
    private static class Node {
        Node left;
        Node right;
        int val;
        public Node(int val) {
            this.val = val;
        }

        @Override public String toString() {
            return "Node{" +
                   "val=" + val +
                   '}';
        }
    }

    /**
     * Build BST from ordered array
     * @param input ordered array
     * @return TreeNode root node of BST
     */
    public static TreeNode buildBST(int[] input) {
        return buildBST(input, 0, input.length-1);
    }

    private static TreeNode buildBST(int[] input, int left, int right) {
        System.out.println("left = " + left + ", right = " + right);
        if (right < left) {
            return null;
        }
        int middle = (right + left) / 2;
        System.out.println("middle = " + middle);
        int val = input[middle];
        TreeNode tn = new TreeNode(val);
        tn.left = buildBST(input, left, middle - 1);
        tn.right = buildBST(input, middle + 1, right);
        return tn;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode treeNode = buildBST(input);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(treeNode);
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
}
