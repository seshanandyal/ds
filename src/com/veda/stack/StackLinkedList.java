package com.veda.stack;

import java.util.Optional;

import com.veda.list.singlelinkedlist.SingleLinkedList;

public class StackLinkedList {
	private SingleLinkedList mList;
	
	public StackLinkedList() {
		mList = new SingleLinkedList();
	}
	
	public int size() {
		return mList.size();
	}
	
	public boolean isEmpty() {
		return mList.isEmpty();
	}
	
	public void push(int value) {
		mList.insertBeginning(value);
	}
	
	public Optional<Integer> pop() {
		return mList.deleteFirstNode();
	}
	
	public Optional<Integer> peek() {
		return mList.first();
	}
	
	public void display() {
		mList.display();
	}
	
	public static void main(String[] args) {
		StackLinkedList stack = new StackLinkedList();
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
