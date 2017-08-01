package com.veda.binarysearchtree;

public class Node {
	private int mInfo;
	private Node mLeftNode;
	private Node mRightNode;
	
	public Node(int info) {
		mInfo = info;
	}
	
	public void setLeftNode(Node node) {
		mLeftNode = node;
	}
	
	public void setRightNode(Node node) {
		mRightNode = node;
	}
	
	public Node getLeftNode() {
		return mLeftNode;
	}

	public Node getRightNode() {
		return mRightNode;
	}
	
	public int getInfo() {
		return mInfo;
	}
	
	public void setInfo(int value) {
		mInfo = value;
	}
}
