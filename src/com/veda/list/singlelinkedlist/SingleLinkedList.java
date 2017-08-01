package com.veda.list.singlelinkedlist;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SingleLinkedList {
	private Node mHead;
	
	public boolean isEmpty() {
		return mHead == null;
	}
	
	public Optional<Integer> first() {
		if(isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(mHead.getInfo());
		}
	}

	public void display() {
		Node current = mHead;
		if (current == null) {
			System.out.println("The linked list is empty.");
		} else {
			while (current != null) {
				System.out.print(current.getInfo() + "  ");
				current = current.getNext();
			}
			System.out.println();
		}
	}
	
	public boolean search(int searchForNumber) {
		Node current = mHead;
		boolean exists = false;
		while(current != null) {
			if(current.getInfo() == searchForNumber) {
				exists = true;
				break;
			}
			current = current.getNext();
		}
		return exists;
	}
	
	public int  size() {
		int count = 0;
		Node current = mHead;
		while(current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}
	
	public void insertBeginning(int number) {
		Node newNode = new Node(number);
		newNode.setNext(mHead);
		mHead = newNode;
	}
	
	public void insertAtEnd(int number) {
		Node newNode = new Node(number);
		Node current = mHead;
		if(current == null) {
			mHead = newNode;
		} else {
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
	}
	
	public static SingleLinkedList createInsertAtBeginning(Integer... args) {
		List<Integer> list = Arrays.asList(args);
		SingleLinkedList linkedList = new SingleLinkedList();
		
		for(int number: list) {
			linkedList.insertBeginning(number);
		}
		return linkedList;
	}
	
	public static SingleLinkedList createInsertAtEnd(Integer... args ) {
		List<Integer> list = Arrays.asList(args);
		SingleLinkedList linkedList = new SingleLinkedList();
		
		for(int number: list) {
			linkedList.insertAtEnd(number);
		}
		return linkedList;
	}
	
	public void insertAfter(int before, int newNumber) {
		Node current = mHead;
		if(current == null) {
			System.out.println("The list is empty and the number is not added");
			return;
		}
		while(current.getNext() != null) {
			if(current.getInfo() == before) {
				Node newNode = new Node(newNumber);
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				return;
			}
			current = current.getNext();
		}
		if(current.getInfo() == before) {
			Node newNode = new Node(newNumber);
			current.setNext(newNode);
		} else {
			System.out.printf("The list does not contain %d. So %d is not added \n", before, newNumber);
		}
	}
	
	public void insertBefore(int after, int newNumber) {
		Node current = mHead;
		if(current == null) {
			System.out.println("The list is empty and the new number is not added");
			return;
		}
		Node previous = current;
		while(current != null) {
			if(current.getInfo() == after) {
				Node newNode = new Node(newNumber);
				newNode.setNext(current);
				if(previous == null) {
					mHead = newNode;
				} else {
					previous.setNext(newNode);
				}
				return;
			}
			previous = current;
			current = current.getNext();
		}
		System.out.printf("The list does not contain %d. So %d is not added \n", after, newNumber);
	}
	
	public void insertAtPosition(int position, int newNumber) {
		int count = 0;
		Node current = mHead;
		if(current == null) {
			if(position == 0) {
				Node newNode = new Node(newNumber);
				mHead = newNode;
			} else {
				System.out.printf("%d is not added to the list. \n", newNumber);
			}
			return;
		}
		
		Node previous = current;
		while(current != null && count < position) {
			previous = current;
			current = current.getNext();
			count++;
		}
		Node newNode = new Node(newNumber);
		if(current == null) {
			System.out.printf("Adding the %d at the end of the list. \n", newNumber);			
		} else {
			newNode.setNext(current);
		}
		previous.setNext(newNode);
	}
	
	public Optional<Integer> deleteFirstNode() {
		if(mHead == null) {
			System.out.println("The list is empty.");
			return Optional.empty();
		}
		
		Optional<Integer> optional = Optional.of(mHead.getInfo());
		mHead = mHead.getNext();
		return optional;
	}
	
	public void deleteLastNode() {
		if(mHead == null) {
			System.out.println("The list is empty.");
			return;
		}
		
		if(mHead.getNext() == null) {
			mHead = null;
			return;
		}
		
		Node current = mHead;
		Node previous = current;
		while(current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}
		previous.setNext(null);
	}
	
	public void reverse() {
		if(mHead == null) {
			return;
		}
		
		Node current = mHead;
		Node previous = null;
		while(current.getNext() != null) {
			Node next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		current.setNext(previous);
		mHead = current;
	}
	
	public void bubbleSort() {
		Node current = mHead;
		if(current == null || current.getNext() == null) {
			return;
		}
		
		Node last = null;
		
		do {
			current = mHead;
			Node previous = current;
			while(current.getNext() != last) {
				Node next = current.getNext();
				if(current.getInfo() > next.getInfo()) {
					if(previous == current) {
						current.setNext(next.getNext());
						next.setNext(current);
						mHead = next;
					} else {
						previous.setNext(next);
						current.setNext(next.getNext());
						next.setNext(current);
					}
					previous = next;
				} else {
					previous = current;
					current = current.getNext();
				}
			}			
			last = current;
		} while(current != mHead);
	}
	
	public void mergeSortedLists(SingleLinkedList sortedList) {
		if(size() == 0 && sortedList.size() == 0) {
			return;
		}
		
		if(size() == 0) {
			mHead = sortedList.mHead;
			return;
		} else if(sortedList.size() == 0) {
			return;
		}
		
		Node current1 = mHead;
		Node current2 = sortedList.mHead;
		Node current = mHead;
		
		if(mHead.getInfo() < sortedList.mHead.getInfo()) {
			current1 = current1.getNext();
		} else {
			mHead = sortedList.mHead;
			current = current2;
			current2 = current2.getNext();
		}
		
		while(current1 != null && current2 != null) {
			if(current1.getInfo() < current2.getInfo()) {
				current.setNext(current1);
				current = current1;
				current1 = current1.getNext();
			} else {
				current.setNext(current2);
				current = current2;
				current2 = current2.getNext();
			}
		}
		
		while(current1 != null) {
			current.setNext(current1);
			current = current1;
			current1 = current1.getNext();
		}
		
		while(current2 != null) {
			current.setNext(current2);
			current = current2;
			current2 = current2.getNext();
		}
	}
	
	public void insertCycle(int nodeInfo) {
		if(mHead == null) {
			System.out.println("The linked list is empty.");
			return;
		}
		Node current = mHead, previous = mHead, nodePtr = null;
		
		while(current != null) {
			if(current.getInfo() == nodeInfo) {
				nodePtr = current;
			}
			previous = current;
			current = current.getNext();
		}
		if(nodePtr == null) {
			System.out.printf("%d does not exists in the list.\n", nodeInfo);
			return;
		}
		
		previous.setNext(nodePtr);
		System.out.println(previous.getNext().getInfo() +" ......");
	}
	
	public boolean detectCycle() {
		Node slowPtr = mHead, fastPtr = mHead;
		do {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext();
			if(fastPtr != null) {
				fastPtr = fastPtr.getNext();
			}
			
		} while(fastPtr != null && slowPtr != fastPtr);
		
		if(fastPtr == null) {
			System.out.println("There is no cycle.");
			return false;
		}
		
		int cycleLength = 0;
		do {
			fastPtr = fastPtr.getNext();
			cycleLength++;
		} while(slowPtr != fastPtr);
		
		System.out.printf("Cycle length: %d.\n", cycleLength);
		
		int nonCycleLength = 0;
		slowPtr = mHead;
		while(slowPtr != fastPtr) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext();
			nonCycleLength++;
		}
		System.out.printf("Non-cycle length: %d,\n", nonCycleLength);
		
		System.out.printf("The length of the list: %d.\n", cycleLength + nonCycleLength);
		return true;
	}
	
	public static void main(String[] args) {
		
		SingleLinkedList linkedList1 = SingleLinkedList.createInsertAtBeginning(23, 2, 4,1, 55, 98);
		
		System.out.printf("The number of elements in the list is: %d \n", linkedList1.size());
		
		linkedList1.display();
		
		linkedList1.insertAtEnd(100);
		
		System.out.println("After adding 100 to the end of the Single Linked List: ");
		linkedList1.display();
		
		String output = linkedList1.search(4)?"The number 4 exists.":"The number 4 does not exists.";
		System.out.println(output);
		
		output = linkedList1.search(980)?"The number 980 exists.":"The number 980 does not exists.";
		System.out.println(output);
		
		System.out.println("Inserting 45 before 4.");
		linkedList1.insertBefore(4, 45);
		linkedList1.display();
		
		System.out.println("Inserting 54 after 4.");
		linkedList1.insertAfter(4, 54);
		linkedList1.display();
		
		System.out.println("Inserting 345 at position 4.");
		linkedList1.insertAtPosition(4, 345);
		linkedList1.display();
		
		System.out.println("Inserting 6758 at position 10. ");
		linkedList1.insertAtPosition(10, 6758);
		linkedList1.display();
		
		System.out.println("Deleting the first node.");
		linkedList1.deleteFirstNode();
		linkedList1.display();
		
		System.out.println("Deleting the last node.");
		linkedList1.deleteLastNode();
		linkedList1.display();
		
		System.out.println("Reversing the linked list.");
		linkedList1.reverse();
		linkedList1.display();
		
		System.out.println("Calling bubble sort.");
		linkedList1.bubbleSort();
		linkedList1.display();
		
		System.out.println("Creating another linked list 2");
		SingleLinkedList linkedList2 = SingleLinkedList.createInsertAtBeginning(123, 23, 40,61, 545, 918);
		
		System.out.println("Calling bubble sort on linked list2.");
		linkedList2.bubbleSort();
		linkedList2.display();
		
		System.out.println("Merging the two sorted lists 1 and 2");
		linkedList1.mergeSortedLists(linkedList2);
		linkedList1.display();
		
		System.out.println("Creating a cycle at 44.");
		linkedList1.insertCycle(44);
		
		linkedList1.detectCycle();
		
		System.out.println("Creating a cycle at 45.");
		linkedList1.insertCycle(45);
		linkedList1.detectCycle();
		
	}
	
}
