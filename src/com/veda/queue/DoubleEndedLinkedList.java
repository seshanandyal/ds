package com.veda.queue;

import java.util.Optional;

public class DoubleEndedLinkedList {
	private Node mFront;
	private Node mRear;
	
	public void insertAtRear(int value) {
		Node newNode = new Node(value);
		if(mRear == null) {
			mFront = newNode;
		} else {
			mRear.setNext(newNode);
		}
		mRear = newNode;
	}
	
	public Optional<Integer> deleteFromFront() {
		if(isEmpty()) {
			return Optional.empty();
		} else {
			int value = mFront.getInfo();
			mFront = mFront.getNext();
			if(mFront == null) {
				mRear = null;
			}
			return Optional.of(value);
		}
	}
	
	public Optional<Integer> front() {
		if(mFront == null) {
			return Optional.empty();
		} else {
			return Optional.of(mFront.getInfo());
		}
	}
	
	public boolean isEmpty() {
		return mFront == null && mRear == null;
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
		} else {
			Node current = mFront;
			while(current != null) {
				System.out.print(current.getInfo() + "   ");
				current = current.getNext();
			}
			System.out.println();
		}
	}
	
	public int size() {
		int count = 0;
		if(isEmpty()) {
			return 0;
		}
		
		Node current = mFront;
		while(current != null) {
			current = current.getNext();
			count++;
		}
		return count;
	}
}
