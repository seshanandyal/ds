package com.veda.queue;

import java.util.Optional;

public class QueueLinkedList {
	private DoubleEndedLinkedList mList;
	
	public QueueLinkedList() {
		mList = new DoubleEndedLinkedList();
	}
	
	public int size() {
		return mList.size();
	}
	
	public void enqueue(int value) {
		mList.insertAtRear(value);
	}
	
	public Optional<Integer> dequeue() {
		return mList.deleteFromFront();
	}
	
	public Optional<Integer> peek() {
		return mList.front();
	}
	
	public boolean isEmpty() {
		return mList.isEmpty();
	}
	
	public void display() {
		mList.display();
	}
	
	public static void main(String[] args) {
		QueueLinkedList queue = new QueueLinkedList();
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
