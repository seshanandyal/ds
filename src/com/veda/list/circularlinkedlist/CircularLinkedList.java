package com.veda.list.circularlinkedlist;

import java.util.Optional;

public class CircularLinkedList {
	private Node mTail;
	
	public boolean isEmpty() {
		return mTail == null;
	}
	
	public void insertBeginning(int newNumber) {
		Node newNode = new Node(newNumber);
		if(mTail == null) {
			mTail = newNode;
			newNode.setNext(newNode);
			return;
		}
		
		newNode.setNext(mTail.getNext());
		mTail.setNext(newNode);
	}
	
	public void insertAtEnd(int newNumber) {
		Node newNode = new Node(newNumber);
		if(mTail == null) {
			mTail = newNode;
			newNode.setNext(newNode);
			return;
		}
		newNode.setNext(mTail.getNext());
		mTail.setNext(newNode);
		mTail = newNode;
	}
	
	public void display() {
		if(mTail == null) {
			System.out.println("The circular list is empty.");
			return;
		}
		Node current = mTail.getNext();
		do {
			System.out.print(current.getInfo() + "  ");
			current = current.getNext();
		} while(current != mTail.getNext());
	}
	
	public void insertAfter(int after, int newNumber) {
		Node current = mTail.getNext();
		do {
			if(current.getInfo() == after) {
				System.out.printf("Inserting %d after %d. \n", newNumber, after);
				Node newNode = new Node(newNumber);
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				return;
			}
			current = current.getNext();
		} while(current != mTail.getNext());
		System.out.printf("%d does not exists in the list. \n", after);
	}
	
	public void deleteAfter(int after) {
		Node current = mTail.getNext();
		Node previous = current;
		do {
			if(current.getInfo() == after) {
				System.out.printf("Deleting after %d. \n", after);
				
				if(current.getNext() == mTail) {
					mTail = current;
				}
				current.setNext(current.getNext().getNext());
				
				return;
			}
			previous = current;
			current = current.getNext();
			
		} while(current != mTail.getNext());
		System.out.println("There is no element " + after + " in the list");
		
	}
	
	public Optional<Integer> deleteFirst() {
		if(mTail == null) {
			System.out.println("The circular list is empty. Nothing to delete.");
			return Optional.empty();
		}
		Optional<Integer> result = null;
		
		if(mTail.getNext() == mTail) {
			result = Optional.of(mTail.getInfo());
			mTail = null;
		} else {
			result = Optional.of(mTail.getNext().getInfo());
			mTail.setNext(mTail.getNext().getNext());			
		}
		return result;
	}
	
	public Optional<Integer> deleteLast() {
		if(mTail == null) {
			System.out.println("The circular list is empty. Nothing to delete.");
			return Optional.empty();
		}
		
		Optional<Integer> result = Optional.of(mTail.getInfo());
		if(mTail.getNext() == mTail) {
			result = Optional.of(mTail.getInfo());
			mTail = null;
		} else  {
			Node current = mTail.getNext();
			while(current.getNext() != mTail) {
				current = current.getNext();
			}
			current.setNext(mTail.getNext());
			mTail = current;
		}
		return result;
	}
	
	public Optional<Integer> first() {
		Optional<Integer> result = Optional.empty();
		if(!isEmpty()) {
			if(mTail.getNext() == null) {
				result = Optional.of(mTail.getInfo());
			} else {
				result = Optional.of(mTail.getNext().getInfo());
			}
		}
		return result;
	}
	
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		
		if(mTail.getNext() == null) {
			return 1;
		} else {
			int count = 1;
			Node current = mTail.getNext();
			while(current != mTail) {
				count++;
				current = current.getNext();
			}
			return count;
		}
	}
	
	static CircularLinkedList createCircularListInsertionAtHead(int... args) {
		CircularLinkedList list = new CircularLinkedList();
		for(int arg: args) {
			list.insertBeginning(arg);
		}
		return list;
	}
	
	static CircularLinkedList createCircularListInsertionAtTail(int...args ) {
		CircularLinkedList list = new CircularLinkedList();
		for(int arg: args) {
			list.insertAtEnd(arg);
		}
		return list;
	}
	
	static void displayBlankLine() {
		System.out.println();
	}
	
	public static void main(String[] args) {
		CircularLinkedList list = createCircularListInsertionAtHead(23, 2, 4, 1, 55, 98);
		list.display();
		displayBlankLine();
		
		list = createCircularListInsertionAtTail(23, 2, 4, 1, 55, 98);
		list.display();
		displayBlankLine();
		
		list.insertAfter(0,  34);
		list.insertAfter(98,  34);
		list.display();
		displayBlankLine();
		
		list.deleteAfter(1);
		list.display();
		displayBlankLine();
		
		System.out.println("Deleting the first node in the circular list.");
		list.deleteFirst();
		list.display();
		displayBlankLine();
		
		System.out.println("Deleting the last node in the circular list.");
		list.deleteLast();
		list.display();
		displayBlankLine();
	}
}
