package com.veda.list.doublelinkedlist;

public class Node {
	private int mInfo;
	private Node mPrevious;
	private Node mNext;
	
	public Node(int info) {
		mInfo = info;
	}
	
	public int getInfo() {
		return mInfo;
	}
	
	public Node getPrevious() {
		return mPrevious;
	}
	
	public void setPrevious(Node previous) {
		mPrevious = previous;
	}
	
	public Node getNext() {
		return mNext;
	}
	
	public void setNext(Node next) {
		mNext = next;
	}
}
