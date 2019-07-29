package com.apismensky;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: 4
 */
public class ClosestBinarySearchTreeValue {
    private static class Node {
        private int data;
        private Node left, right;

        public Node(int value) {
            data = value;
        }

        public Node(int value, Node left, Node right) {
            data = value;
            this.left = left;
            this.right= right;
        }

        @Override
        public String toString() {
            return "Node{" +
                   "data=" + data +
                   '}';
        }
    }

    public static int closestValue(Node root, double target) {
        int result = root.data;
        double minDiff = Double.MAX_VALUE;
        while (root != null) {
            double diff = Math.abs(root.data - target);
            if (diff < minDiff) {
                result = root.data;
                minDiff = diff;
            }
            if (target > root.data)
                root = root.right;
            else if (target < root.data)
                root = root.left;
            else
                return root.data;
        }
        return result;
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n2 = new Node(2, n1, n3);

        Node n5 = new Node(5);
        Node n4 = new Node(4, n2, n5);
        int i = closestValue(n4, 3.76);
        System.out.println("i = " + n4);

    }
}
