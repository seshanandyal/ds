package com.veda.binarytree;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {
    public static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, List<TreeNode<Integer>>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair pair = q.remove();
                map.computeIfAbsent(pair.index, k -> new ArrayList<>());
                map.get(pair.index).add(pair.node);

                if (pair.node.left != null) q.add(new Pair(pair.node.left, pair.index - 1));
                if (pair.node.right != null) q.add(new Pair(pair.node.right, pair.index + 1));
            }
        }

        for (int index : map.keySet()) {
            List<TreeNode<Integer>> nodeList = map.get(index);
            List<Integer> list = nodeList.stream()
                    .map(node -> node.data)
                    .collect(Collectors.toList());
            result.add(list);
        }
        return result;
    }

    static class Pair {
       TreeNode<Integer> node;
        int index;

        Pair(TreeNode<Integer> node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // Definiton of a binary tree node class
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
}


