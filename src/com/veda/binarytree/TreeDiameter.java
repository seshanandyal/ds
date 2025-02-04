package com.veda.binarytree;

import java.util.*;

// Definiton of a binary tree node class
 class TreeNode<T> {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     TreeNode(T data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

public class TreeDiameter{
    static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        diameter = 0;
        if(root == null) return -1;
        height(root);
        return diameter;
    }

    static int height(TreeNode<Integer> node) {
        if(node == null) return 0;

        int lHeight = height(node.left);
        int rHeight = height(node.right);

        diameter = Math.max(diameter, lHeight + rHeight);

        return Math.max(lHeight, rHeight) + 1;
    }
}