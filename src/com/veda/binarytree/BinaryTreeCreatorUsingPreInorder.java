package com.veda.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeCreatorUsingPreInorder {
	private Node mRoot;
	private Queue<Character> mQueue = new LinkedList<>();
	
	public void create(String preOrder, String inOrder) {
		if(preOrder.trim().length() == 0 || inOrder.trim().length() == 0) {
			return;
		}
		char[] preOrderArr = preOrder.trim().toCharArray();
		for(char ch: preOrderArr) {
			mQueue.add(ch);
		}
		char first = mQueue.remove();
		mRoot = new Node(first);
		String inOrderLeftString = getLeftInOrderString(first, inOrder);
		String inOrderRightString = getRightInOrderString(first, inOrder);
		if(inOrderLeftString != null && inOrderLeftString.length() != 0) {
			createSubtree(mRoot, inOrderLeftString, true);
		}
		
		if(inOrderRightString  != null && inOrderRightString.length() != 0) {
			createSubtree(mRoot, inOrderRightString, false);
		}
	}
	
	private void createSubtree(Node parent, String inOrder, boolean left) {
		if(mQueue.isEmpty()) {
			return;
		}
		char ch = mQueue.remove();
		Node newNode = new Node(ch);
		if(left) {
			parent.setLeftNode(newNode);
		} else {
			parent.setRightNode(newNode);
		}
		String inOrderLeftString = getLeftInOrderString(ch, inOrder);
		String inOrderRightString = getRightInOrderString(ch, inOrder);
		
		if(inOrderLeftString != null && inOrderLeftString.length() != 0) {
			createSubtree(newNode, inOrderLeftString, true);
		}
		
		if(inOrderRightString != null && inOrderRightString.length() != 0) {
			createSubtree(newNode, inOrderRightString, false);
		}
	}
	
	public void display() {
		display(mRoot, 0);
		System.out.println();
	}
	
	private void display(Node node, int level) {
		if(node == null) {
			return;
		}
		
		display(node.getRightNode(), level + 1);
		System.out.println();
		
		for(int count = 0; count < level; count++) {
			System.out.print("     ");
		}
		System.out.print(node.getInfo());
		
		display(node.getLeftNode(), level + 1);
	}
	
	private String getLeftInOrderString(char ch, String inOrder) {
		return inOrder.substring(0, inOrder.indexOf(ch));
	}
	
	private String getRightInOrderString(char ch, String inOrder) {
		return inOrder.substring(inOrder.indexOf(ch) + 1);
	}
		
	public static void main(String[] args) {
		String preorder = "PASTQEDXMRCF";
		String inorder = "TSQAEDPMXCRF";
		
		BinaryTreeCreatorUsingPreInorder tree = new BinaryTreeCreatorUsingPreInorder();
		tree.create(preorder, inorder);
		tree.display();
	}
}
