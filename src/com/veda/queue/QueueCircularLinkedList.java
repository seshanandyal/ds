package com.veda.queue;

import java.util.Optional;

import com.veda.list.circularlinkedlist.CircularLinkedList;

public class QueueCircularLinkedList {
	private CircularLinkedList mList;
	
	public QueueCircularLinkedList() {
		mList = new CircularLinkedList();
	}
	
	public boolean isEmpty() {
		return mList.isEmpty();
	}
	
	public void enqueue(int value) {
		mList.insertAtEnd(value);
	}
	
	public Optional<Integer> dequeue() {
		return mList.deleteFirst();
	}
	
	public Optional<Integer> peek() {
		return mList.first();
	}
	
	public void display() {
		mList.display();
		System.out.println();
	}
	
	public int size() {
		return mList.size();
	}
	
	public static void main(String[] args) {
		QueueCircularLinkedList queue = new QueueCircularLinkedList();
		queue.enqueue(30);
		queue.enqueue(67);
		queue.enqueue(43);
		queue.display();
		System.out.println("Peek: " + queue.peek().get());
		queue.dequeue();
		queue.display();
		queue.dequeue();
		System.out.println("Size: " + queue.size());
		queue.dequeue();
		queue.display();
		queue.dequeue();
		System.out.println("Size: " + queue.size());
	}
}
