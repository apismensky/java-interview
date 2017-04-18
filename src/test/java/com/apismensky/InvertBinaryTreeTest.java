package com.apismensky;
import com.apismensky.InvertBinaryTree.TreeNode;
import static com.apismensky.InvertBinaryTree.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InvertBinaryTreeTest {


    @Test
    public void testOneNode() {
        TreeNode treeNode = new TreeNode(0);
        assertEquals(treeNode, invertTree(treeNode));
    }

    @Test
    public void testInvert() {
        TreeNode treeNode = buildTree();
        System.out.println(treeNode);
        TreeNode inverted = invertTree(treeNode);
        System.out.println(inverted);
        assertEquals(buildInvertedTree(), inverted);
    }


    /**

       4
     /   \
    2     7
   / \   / \
 1   3 6   9

     */
    private TreeNode buildTree() {
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        four.left = two;
        four.right = seven;
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        two.left = one;
        two.right = three;
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);
        seven.left = six;
        seven.right = nine;
        return four;
    }

    /**

       4
     /   \
    7     2
   / \   / \
 9   6 3   1

     */
    private TreeNode buildInvertedTree() {
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        four.left = seven;
        four.right = two;
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        two.right = one;
        two.left = three;
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);
        seven.right = six;
        seven.left = nine;
        return four;
    }

}
