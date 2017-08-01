package com.veda.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private Node mRoot;
	private Node mTempRoot;
	private Node mLastInorder;
	
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
	
	public void preOrder() {
		System.out.println("Preorder.");
		preOrder(mRoot);
		System.out.println();
	}
	
	public void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.getInfo() + " ");
		preOrder(node.getLeftNode());
		preOrder(node.getRightNode());
	}
	
	public void inOrder() {
		System.out.println("Inorder.");
		inOrder(mRoot);
		System.out.println();
	}
	
	public void inOrder(Node node) {
		if(node == null) {
			return;
		}
		inOrder(node.getLeftNode());
		System.out.print(node.getInfo() + " ");
		inOrder(node.getRightNode());
	}
	
	public void postOrder() {
		System.out.println("Postorder.");
		postOrder(mRoot);
		System.out.println();
	}
	
	public void postOrder(Node node) {
		if(node == null) {
			return;
		}
		postOrder(node.getLeftNode());
		postOrder(node.getRightNode());
		System.out.print(node.getInfo() + " ");
	}
	
	public void levelOrder() {
		System.out.println("Level order.");
		if(mRoot == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		Node current = null;
		queue.add(mRoot);
		while(!queue.isEmpty()) {
			current = queue.remove();
			System.out.print(current.getInfo() + " ");
			if(current.getLeftNode() != null) {
				queue.add(current.getLeftNode());
			}
			
			if(current.getRightNode() != null) {
				queue.add(current.getRightNode());
			}
		}
		System.out.println();
	}
	
	public void height() {
		System.out.printf("Tree height is %d.", treeHeight(mRoot));
	}
	
	public int treeHeight(Node node) {
		if(node == null) {
			return 0;
		}
		int leftSubtreeHeight = treeHeight(node.getLeftNode());
		int rightSubtreeHeight = treeHeight(node.getRightNode());
		
		int maxHeight = leftSubtreeHeight > rightSubtreeHeight ? leftSubtreeHeight :rightSubtreeHeight;
		return 1 + maxHeight;
	}
	
	public void convertToLinkedList() {
		if(mRoot == null) {
			return;
		}
		
		fixLinksDuringInorder(mRoot);
		mRoot = mTempRoot;
		
		displayInorderLinkedList();
	}
	
	private void displayInorderLinkedList() {
		Node current = mRoot;
		if(current == null) {
			System.out.println("The list is empty.");
			return;
		}
		while(current != null) {
			System.out.print(current.getInfo() + "  ");
			current = current.getRightNode();
		}
	}
	
	private void fixLinksDuringInorder(Node node) {
		if(node == null) {
			return;
		}
		
		fixLinksDuringInorder(node.getLeftNode());
		
		if(mTempRoot == null) {
			mTempRoot = node;
		}
		if(mLastInorder == null) {
			mLastInorder = node;
		} else {
			mLastInorder.setRightNode(node);
		}
		
		mLastInorder = node;
		
		fixLinksDuringInorder(node.getRightNode());
	}
	
	
	public void create() {
		mRoot = new Node('P');
		mRoot.setLeftNode(new Node('Q'));
		mRoot.setRightNode(new Node('R'));
		mRoot.getLeftNode().setLeftNode(new Node('A'));
		mRoot.getLeftNode().setRightNode(new Node('B'));
		mRoot.getRightNode().setLeftNode(new Node('X'));
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.create();
		tree.display();
		
		tree.preOrder();
		tree.inOrder();
		tree.postOrder();
		tree.levelOrder();
		tree.height();
		
		System.out.println();
		tree.convertToLinkedList();
	}
}
