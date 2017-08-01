package com.veda.binarysearchtree;

import java.util.Optional;

public class BinarySearchTree {
	private Node mRoot;
	
	public boolean isEmpty() {
		return mRoot == null;
	}
	
	public void insert(int info) {
		Node newNode = new Node(info);
		if(isEmpty()) {
			mRoot = newNode;
			return;
		}
		Node current = mRoot;
		Node parent = null;
		boolean leftChild = false;
		while(current != null) {
			parent = current;
			if(current.getInfo() > info) {
				current = current.getLeftNode();
				leftChild = true;
			} else {
				current = current.getRightNode();
				leftChild = false;
			}
		}
		if(leftChild) {
			parent.setLeftNode(newNode);
		} else {
			parent.setRightNode(newNode);
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
	
	public boolean search(int value) {
		if(isEmpty()) {
			System.out.println("The tree is empty.");
			return false;
		}
		Node current = mRoot;
		while(current != null) {
			if(current.getInfo() == value) {
				System.out.printf("Found %d \n", value);
				return true;
			}
			if(current.getInfo() > value) {
				current = current.getLeftNode();
			} else {
				current = current.getRightNode();
			}
		}
		System.out.printf("Unable to find %d\n", value);
		return false;
	}
	
	public void delete(int value) {
		if(isEmpty()) {
			System.out.println("The tree is empty.");
			return;
		}
		Node current = mRoot;
		Node parent = current;
		boolean currentNodeIsToTheLeftOfParent = false;
		while(current != null) {
			if(current.getInfo() == value) {
				if(itsLeafNode(current)) {
					if(currentNodeIsToTheLeftOfParent) {
						parent.setLeftNode(null);
					} else {
						parent.setRightNode(null);
					}
				} else if(itHasOnlyLeftChild(current)) {
					if(currentNodeIsToTheLeftOfParent) {
						parent.setLeftNode(current.getLeftNode());
					} else {
						parent.setRightNode(current.getLeftNode());
					}
				} else if(itHasOnlyRightChild(current)) {
					if(currentNodeIsToTheLeftOfParent) {
						parent.setLeftNode(current.getRightNode());
					} else {
						parent.setRightNode(current.getRightNode());
					}
				} else {
					Node inOrderSuccessor = getInOrderSuccessor(current);
					current.setInfo(inOrderSuccessor.getInfo());
				}
				System.out.printf("Deleted %d. \n", value);
				return;
			} else {
				parent = current;
				if(current.getInfo() > value) {
					currentNodeIsToTheLeftOfParent = true;
					current = current.getLeftNode();
				} else {
					currentNodeIsToTheLeftOfParent = false;
					current = current.getRightNode();
				}
			}
		}
	}
	
	public Optional<Integer> max() {
		if(isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(mRoot.getInfo());
		}
	}
	
	public Optional<Integer> min() {
		if(isEmpty()) {
			return Optional.empty();
		} else {
			Node current = mRoot;
			Node parent = null;
			while(current != null) {
				parent = current;
				current = current.getLeftNode();
			}
			return Optional.of(parent.getInfo());
		}
	}
	
	private Node getInOrderSuccessor(Node node) {
		Node parent = node;
		Node current = node.getRightNode();
		
		boolean traversedLeftSubtree = false;
		while(current.getLeftNode() != null) {
			parent = current;
			current = current.getLeftNode();
		}
		
		if(traversedLeftSubtree) {
			if(current.getRightNode() != null) {
				parent.setLeftNode(current.getRightNode());
			} else {
				parent.setLeftNode(null);
			}
		} else {
			parent.setRightNode(null);
		}
		
		return current;
	}
	
	private boolean itHasOnlyRightChild(Node node) {
		return node.getRightNode() != null && node.getLeftNode() == null;
	}
	
	private boolean itHasOnlyLeftChild(Node node) {
		return node.getLeftNode() != null && node.getRightNode() == null;
	}
	
	private boolean itsLeafNode(Node node) {
		return node.getLeftNode() == null && node.getRightNode() == null;
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		int[] arr = {70,40,80,35,50,75,89, 30, 37, 55, 82, 93};
		for(int num: arr) {
			tree.insert(num);
		}
		tree.display();
		
		System.out.println("Max: " + tree.max());
		System.out.println("Min: " + tree.min());
		
		tree.search(45);
		tree.search(37);
		
		tree.delete(89);
		
		tree.display();
	}
}
