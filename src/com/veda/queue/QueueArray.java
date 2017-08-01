package com.veda.queue;

import java.util.Optional;

public class QueueArray {
	private int[] mArray;
	private int mFront = -1, mRear = -1;
	static final int DEFAULT_MAX_SIZE = 30;
	
	public QueueArray() {
		mArray = new int[DEFAULT_MAX_SIZE];
	}
	
	public QueueArray(int size) {
		mArray = new int[size];
	}
	
	public boolean isEmpty() {
		return mFront == -1 && mRear == -1;
	}
	
	public int size() {
		if(mFront == -1 && mRear == -1) {
			return 0;
		} else {
			return mRear - mFront + 1;
		}
	}
	
	public boolean isFull() {
		return (size()) == mArray.length;
	}
	
	public void enqueue(int value) {
		if(isFull()) {
			System.out.println("Queue is full.");
			return;
		}
		if(mFront == -1) {
			mFront++;
		}
		mArray[++mRear] = value;
	}
	
	public Optional<Integer> dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
			return Optional.empty();
		} else {
			int value = mArray[mFront++];
			if(mFront > mRear) {
				mFront = -1;
				mRear = -1;
			}
			return Optional.of(value);
		}
	}
	
	public Optional<Integer> peek() {
		if(isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(mArray[mFront]);
		}
	}
	
	public void display() {
		if(mFront == -1) {
			System.out.println("Queue is empty.");
			return;
		}
		for(int index = mFront; index <= mRear; index++) {
			System.out.print(mArray[index] + "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		QueueArray queue = new QueueArray();
		queue.enqueue(15);
		queue.enqueue(30);
		queue.enqueue(67);
		queue.enqueue(43);
		queue.display();
		System.out.println("Peek: " + queue.peek().get());
		queue.display();
		queue.dequeue();
		queue.display();
		queue.dequeue();
		queue.dequeue();
		queue.display();
		queue.dequeue();
	}
}
