package com.veda.list.circularlinkedlist;

public class Node {
	private int mInfo;
	private Node mNext;
	
	public Node(int info) {
		mInfo = info;
	}
	
	public void setNext(Node next) {
		mNext = next;
	}
	
	public Node getNext() {
		return mNext;
	}
	
	public int getInfo() {
		return mInfo;
	}
}
