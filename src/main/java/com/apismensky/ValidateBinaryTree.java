package com.apismensky;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidateBinaryTree {
    private static class Node {
        private int data;
        private Node left, right;

        public Node(int value) {
            data = value;
            left = right = null;
        }

        public Node(int value, Node left, Node right) {
            data = value;
            this.left = left;
            this.right= right;
        }

        public boolean isLeaf() {
            return left==null && right == null;
        }

        @Override
        public String toString() {
            return "Node{" +
                   "data=" + data +
                   '}';
        }
    }

    public static boolean isValid(Node node) {
        return traverse(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean traverse(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        System.out.println(node + ", min = " + min + ", max = " + max);
        if (node.data >= max || node.data <= min) return false;
        return traverse(node.left, min, node.data) && traverse(node.right, node.data, max);
    }

    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int depthLeft = depth(root.left);
        int depthRight = depth(root.right);
        System.out.println("depthLeft = " + depthLeft);
        System.out.println("depthRight = " + depthRight);

        return Math.abs(depthLeft - depthRight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int depth(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    public static int[] twoSum(Node root, int target) {
        Set<Integer> values = new HashSet<>();
        traverse(root, values);
        for (Integer value : values) {
            if (values.contains((target-value))) {
                return new int[] {value, target - value};
            }
        }
        return null;
    }

    private static void traverse(Node node, Set<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.data);
        traverse(node.left, result);
        traverse(node.right, result);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n6 = new Node(6);
        Node n5 = new Node(5, n1, n6);

        Node n13 = new Node(13);
        Node n21 = new Node(21);
        Node n15 = new Node(15, n13, n21);

        Node n25 = new Node(25);
        Node n20 = new Node(20, n15, n25);

        Node n10 = new Node(10, n5, n20);
        boolean valid = isValid(n10);
        System.out.println("valid = " + valid);
        int depth = depth(n10);
        System.out.println("depth = " + depth);

        boolean balanced = isBalanced(n10);
        System.out.println("Balanced = " + balanced);

        int[] twoSum = twoSum(n10, 34);
        System.out.println("result = " + Arrays.toString(twoSum));
    }
}