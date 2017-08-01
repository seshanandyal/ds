package com.veda.binarytree;

public class Node {
	private char mInfo;
	private Node mLeftNode;
	private Node mRightNode;
	
	public Node(char info) {
		mInfo = info;
	}
	
	public char getInfo() {
		return mInfo;
	}
	
	public Node getLeftNode() {
		return mLeftNode;
	}
	
	public Node getRightNode() {
		return mRightNode;
	}
	
	public void setLeftNode(Node node) {
		mLeftNode = node;
	}
	
	public void setRightNode(Node node) {
		mRightNode = node;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null && !(o instanceof Node)) {
			return false;
		}
		
		Node passedNode = (Node) o;
		return passedNode.getInfo() == mInfo;
	}
	
	@Override
	public int hashCode() {
		return new Character(mInfo).hashCode();
	}
}
