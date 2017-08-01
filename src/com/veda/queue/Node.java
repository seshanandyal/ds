package com.veda.queue;

public class Node {
	private int mInfo;
	private Node mNext;
	
	public Node(int value) {
		mInfo = value;
	}
	
	public int getInfo() {
		return mInfo;
	}
	
	public void setNext(Node next) {
		mNext = next;
	}
	
	public Node getNext() {
		return mNext;
	}
}
