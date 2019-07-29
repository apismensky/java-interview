package com.apismensky;

import org.junit.Test;

import static com.apismensky.MaxDepthBinaryTree.BFS;
import static com.apismensky.MaxDepthBinaryTree.inOrder;
import static com.apismensky.MaxDepthBinaryTree.maxDepth;
import static com.apismensky.MaxDepthBinaryTree.postOrder;
import static com.apismensky.MaxDepthBinaryTree.preOrder;
import static org.junit.Assert.assertEquals;

public class MaxDepthBinaryTreeTest {

    @Test
    public void testNull() {
        assertEquals(0, maxDepth(null));
    }

    @Test
    public void testEmpty() {
        assertEquals(1, maxDepth(new TreeNode(1)));
    }

    @Test
    public void testDepth2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertEquals(2, maxDepth(root));
    }

    @Test
    public void testDepth4() {
        assertEquals(4, maxDepth(getTree()));
    }

    private TreeNode getTree() {
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
        return node1;
    }

    @Test
    public void testPreOrder() {
        /**
         * TreeNode{val=1}
         * TreeNode{val=2}
         * TreeNode{val=4}
         * TreeNode{val=5}
         * TreeNode{val=6}
         * TreeNode{val=3}
         * TreeNode{val=7}
         */
        preOrder(getTree());
    }

    @Test
    public void testInOrder() {
        /**
         * TreeNode{val=2}
         * TreeNode{val=4}
         * TreeNode{val=5}
         * TreeNode{val=6}
         * TreeNode{val=1}
         * TreeNode{val=3}
         * TreeNode{val=7}
         */
        inOrder(getTree());
    }

    @Test
    public void testPostOrder() {
        /**
         * TreeNode{val=2}
         * TreeNode{val=4}
         * TreeNode{val=5}
         * TreeNode{val=6}
         * TreeNode{val=3}
         * TreeNode{val=7}
         * TreeNode{val=1}
         */
        postOrder(getTree());
    }

    @Test
    public void testBFS() {
        /**
         * TreeNode{val=1}
         * TreeNode{val=2}
         * TreeNode{val=3}
         * TreeNode{val=4}
         * TreeNode{val=5}
         * TreeNode{val=7}
         * TreeNode{val=6}
         */
        BFS(getTree());
    }

}
