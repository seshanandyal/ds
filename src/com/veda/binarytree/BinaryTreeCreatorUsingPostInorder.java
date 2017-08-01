package com.veda.binarytree;

import java.util.Stack;

public class BinaryTreeCreatorUsingPostInorder {
	private Node mRoot;
	private Stack<Character> stack = new Stack<>();
	
	public void create(String postOrder, String inOrder) {
		if((postOrder == null || postOrder.length() == 0 ||
				inOrder == null || inOrder.length() == 0) &&
				postOrder.length() == inOrder.length()) {
			return;
		}
		char[] arr = postOrder.trim().toCharArray();
		for(char ch: arr) {
			stack.push(ch);
		}
		char last = stack.pop();
		mRoot = new Node(last);
		String leftInOrderString = getLeftInOrderString(last, inOrder);
		String rightInOrderString = getRightInOrderString(last, inOrder);
		
		if(rightInOrderString != null && rightInOrderString.length() != 0) {
			buildTree(mRoot, rightInOrderString, false);
		}
		
		if(leftInOrderString != null && leftInOrderString.length() != 0) {
			buildTree(mRoot, leftInOrderString, true);
		}
	}
	
	private void buildTree(Node parent, String inOrder, boolean left) {
		if(stack.isEmpty()) {
			return;
		}
		char ch = stack.pop();
		Node newNode = new Node(ch);
		if(left) {
			parent.setLeftNode(newNode);
		} else {
			parent.setRightNode(newNode);
		}
		
		String leftInOrderString = getLeftInOrderString(ch, inOrder);
		String rightInOrderString = getRightInOrderString(ch, inOrder);
		
		if(rightInOrderString != null && rightInOrderString.length() != 0) {
			buildTree(newNode, rightInOrderString, false);
		}
		
		if(leftInOrderString != null && leftInOrderString.length() != 0) {
			buildTree(newNode, leftInOrderString, true);
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
		String postOrder = "TQSDEAMCFRXP";
		String inOrder = "TSQAEDPMXCRF";
		
		BinaryTreeCreatorUsingPostInorder creator = new BinaryTreeCreatorUsingPostInorder();
		creator.create(postOrder, inOrder);
		creator.display();
	}
}
