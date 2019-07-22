package com.apismensky;

import java.util.Stack;

public class BinTree {
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

    private Node root;

    public BinTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    /**
     * Java function to check if binary tree is empty or not * Time Complexity of this solution is constant O(1) for * best, average
     * and worst case. * * @return true if binary search tree is empty
     */
    public boolean isEmpty() {
        return null == root;
    }

    /**
     * Java function to return number of nodes in this binary search tree. * Time complexity of this method is O(n) * @return size of
     * this binary search tree
     */
    public int size() {
        Node current = root;
        int size = 0;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                size++;
                current = stack.pop();
                current = current.right;
            }
        }
        return size;
    }

    /**
     * Java function to clear the binary search tree. * Time complexity of this method is O(1)
     */
    public void clear() {
        root = null;
    }

    public static void traverse(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node);
            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.left!=null) {
                stack.push(node.left);
            }
        }
    }

    public static int countLeaves(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static int countLeavesStack(Node root) {
        int count = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.left!=null) {
                stack.push(node.left);
            }
            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.isLeaf()) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n4 = new Node(4);
        Node n3 = new Node(3, n1, n4);
        Node n6 = new Node(6);
        Node n5 = new Node(5, n3, n6);

        Node n8 = new Node(8);
        Node n10 = new Node(10);
        Node n9 = new Node(9, n8, n10);

        Node n13 = new Node(13);
        Node n17 = new Node(17);
        Node n15 = new Node(15, n13, n17);

        Node n12 = new Node(12, n9, n15);

        Node root = new Node(7, n5, n12);

        BinTree tree = new BinTree(root);
        int size = tree.size();
        System.out.println(size);

        traverse(root);

        int leaves = countLeaves(root);
        System.out.println("Leaves: " + leaves);

        int leaves2 = countLeavesStack(root);
        System.out.println("Leaves2: " + leaves2);


    }

}
