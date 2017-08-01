package com.veda.list.singlelinkedlist;

public class Node {
	private int mInfo;
	private Node mNext;
	
	public Node(int info) {
		mInfo = info;
		mNext = null;
	}
	
	public int getInfo() {
		return mInfo;
	}
	
	public Node getNext() {
		return mNext;
	}
	
	public void setNext(Node next) {
		mNext = next;
	}
}
