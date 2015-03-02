package com.octanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxDepthBinaryTreeTest {

    @Test
    public void testNull() {
        assertEquals(0, MaxDepthBinaryTree.maxDepth(null));
    }

    @Test
    public void testEmpty() {
        assertEquals(1, MaxDepthBinaryTree.maxDepth(new TreeNode(1)));
    }

    @Test
    public void testDepth2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertEquals(2, MaxDepthBinaryTree.maxDepth(root));
    }

    @Test
    public void testDepth4() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        node2.left = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.right = node5;
        node5.right = new TreeNode(6);
        TreeNode node3 = new TreeNode(3);
        node1.right = node3;
        node3.right = new TreeNode(7);

        assertEquals(4, MaxDepthBinaryTree.maxDepth(node1));
    }
}
