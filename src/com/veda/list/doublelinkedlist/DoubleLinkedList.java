package com.veda.list.doublelinkedlist;

public class DoubleLinkedList {
	private Node mHead;
	
	public void insertBeginning(int newNumber) {
		Node newNode = new Node(newNumber);
		if(mHead == null) {
			mHead = newNode;
			return;
		}
		
		newNode.setNext(mHead);
		mHead.setPrevious(newNode);
		mHead = newNode;
	}
	
	public void insertAtEnd(int number) {
		Node newNode = new Node(number);
		if(mHead == null) {
			mHead = newNode;
			return;
		}
		
		Node current = mHead;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(newNode);
		newNode.setPrevious(current);
	}
	
	public void insertAfter(int after, int newNumber) {
		Node newNode = new Node(newNumber);
		Node current = mHead;
		while(current != null) {
			if(current.getInfo() == after) {
				System.out.printf("Inserting after %d, the new number %d. \n", after, newNumber);
				newNode.setNext(current.getNext());
				if(current.getNext() != null) {
					current.getNext().setPrevious(newNode);
				}
				newNode.setPrevious(current);
				current.setNext(newNode);
				return;
			}
			current = current.getNext();
		}
		System.out.printf("Could not find %d in the list. \n", after);
	}
	
	public void insertBefore(int before, int newNumber) {
		Node newNode = new Node(newNumber);
		Node current = mHead;
		while(current != null) {
			if(current.getInfo() == before) {
				System.out.printf("Inserting before %d, the new number %d. \n", before, newNumber);
				current.getPrevious().setNext(newNode);
				newNode.setPrevious(current.getPrevious());
				newNode.setNext(current);
				current.setPrevious(newNode);
				return;
			}
			current = current.getNext();
		}
		System.out.printf("Could not find %d in the list. \n", before);
	}
	
	public void display() {
		Node current = mHead;
		while(current != null) {
			System.out.print(current.getInfo() + "  ");
			current = current.getNext();
		}
	}
	
	public void deleteFirstNode() {
		if(mHead == null) {
			System.out.println("The list is empty.");
			return;
		}
		
		System.out.println("Deleting first node.");
		if(mHead.getNext() != null) {
			mHead.getNext().setPrevious(null);
		}
		mHead = mHead.getNext();
	}
	
	public void deleteLastNode() {
		if(mHead == null) {
			System.out.println("The list is empty.");
			return;
		}
		
		System.out.println("Deleting last node");
		Node current = mHead;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		
		if(mHead == current) {
			mHead = null;
		} else {
			current.getPrevious().setNext(null);
		}
	}
	
	public void reverse() {
		System.out.println("Reversing list.");;
		if(mHead == null || mHead.getNext() == null) {
			return;
		}
		
		Node current = mHead;
		Node previous = null;
		while(current != null) {
			Node next = current.getNext();
			
			current.setNext(current.getPrevious());
			current.setPrevious(next);
			
			previous = current;
			current = next;
		}
		mHead = previous;
	}

	static DoubleLinkedList createInsertBeginning(int... args) {
		DoubleLinkedList list = new DoubleLinkedList();
		for(int arg: args) {
			list.insertBeginning(arg);
		}
		return list;
	}
	
	static DoubleLinkedList createInsertAtEnd(int... args) {
		DoubleLinkedList list = new DoubleLinkedList();
		for(int arg: args) {
			list.insertAtEnd(arg);
		}
		return list;
	}
	
	static void displayBlankLine() {
		System.out.println();
	}
	
	public static void main(String[] args) {
		DoubleLinkedList list = createInsertBeginning(23, 2, 4,1, 55, 98);
		list.display();
		
		displayBlankLine();
		
		list = createInsertAtEnd(23, 2, 4,1, 55, 98);
		list.display();
		
		displayBlankLine();
		
		list.insertAfter(0, 45);
		
		list.insertAfter(23, 234);
		list.display();
		
		displayBlankLine();
		
		list.insertBefore(3, 99);
		
		list.insertBefore(234, 99);
		list.display();
		
		displayBlankLine();
		list.reverse();
		list.display();
		
		displayBlankLine();
		list.reverse();
		list.display();
		
		displayBlankLine();
		list.deleteFirstNode();
		list.display();
		displayBlankLine();
		
		list.deleteLastNode();
		list.display();
		displayBlankLine();
		
		list.reverse();
		list.display();
		displayBlankLine();
	}
	
}
