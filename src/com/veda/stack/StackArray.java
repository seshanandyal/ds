package com.veda.stack;

import java.util.Optional;

public class StackArray {
	private int[] mArray;
	private int mTop = -1;
	static final int DEFAULT_MAX_SIZE = 30;
	
	public StackArray() {
		mArray = new int[DEFAULT_MAX_SIZE];
	}
	
	public StackArray(int maxSize) {
		mArray = new int[maxSize];
	}
	
	public int size() {
		return mTop + 1;
	}
	
	public boolean isEmpty() {
		return mTop == -1;
	}
	
	public boolean isFull() {
		return mTop == (mArray.length - 1);
	}
	
	public void push(int value) {
		if(!isFull()) {
			mArray[++mTop] = value;
		} else {
			System.out.println("The stack is full.");
		}
	}
	
	public Optional<Integer> pop() {
		if(!isEmpty()) {
			return Optional.of(mArray[mTop--]);
		} else {
			return Optional.empty();
		}
	}
	
	public Optional<Integer> peek() {
		if(!isEmpty()) {
			return Optional.of(mArray[mTop]);
		} else {
			return Optional.empty();
		}
	}
	
	public void display() {
		for(int count = mTop; count >= 0; count--) {
			System.out.print(mArray[count] + "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		StackArray stack = new StackArray();
		stack.push(15);
		stack.push(30);
		stack.push(67);
		stack.push(43);
		System.out.println("Peek: " + stack.peek().get());
		stack.display();
		stack.pop();
		stack.display();
	}
}
