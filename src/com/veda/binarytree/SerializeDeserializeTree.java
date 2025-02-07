package com.veda.binarytree;
import java.util.*;


public class SerializeDeserialize{
    public static List<String> serialize(TreeNode<Integer> root) {
        List<String> serializedStringList = null;
        if(root == null) {
            return serializedStringList;
        }
        serializedStringList = new ArrayList<>();
        preorder(root, serializedStringList);
        return serializedStringList;
    }

    static void preorder(TreeNode<Integer> node, List<String> list) {
        if(node == null) {
            list.add("NULL");
            return;
        }
        list.add(String.valueOf(node.data));
        preorder(node.left, list);
        preorder(node.right, list);
    }
    public static TreeNode<Integer> deserialize(List<String> stream){
        if(stream == null) return null;
        String nodeString = stream.remove(0);
        if("NULL".equals(nodeString)) return null;

        TreeNode<Integer> head = new TreeNode<>(Integer.valueOf(nodeString));
        head.left = deserialize(stream);
        head.right = deserialize(stream);

        return head;
    }

    class TreeNode<T> {
        T data;
        com.veda.binarytree.TreeNode<T> left;
        com.veda.binarytree.TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}