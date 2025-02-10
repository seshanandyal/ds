package com.veda.binarytree;

import java.util.*;

public class Symmetric {

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


    public class Solution {
        public static boolean isSymmetric(TreeNode<Integer> root) {
            if (root == null) return false;
            if (root.left == null && root.right == null) return true;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root.left);
            q.add(root.right);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i = i + 2) {
                    System.out.println(q);
                    TreeNode left = q.remove();
                    TreeNode right = q.remove();

                    if (left == null && right == null) continue;
                    if (left == null || right == null || !left.data.equals(right.data)) return false;

                    q.add(left.left);
                    q.add(right.right);
                    q.add(left.right);
                    q.add(right.left);
                }
            }
            return true;
        }
    }
}
