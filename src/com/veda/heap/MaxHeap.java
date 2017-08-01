package com.veda.heap;

import java.util.Optional;

import com.veda.binarytree.Node;

public class MaxHeap {
	private int[] mArray;
	private int mSize = 0;
	static final int MAX_SIZE = 30;
	
	public MaxHeap() {
		mArray = new int[MAX_SIZE];
	}
	
	public void insert(int newValue) {
		if(mSize == MAX_SIZE - 1) {
			System.out.println("Insert failed. Heap is full");
			return;
		}
		mArray[++mSize] = newValue;
		restoreUp();
	}
	
	private void restoreUp() {
		if(mSize == 1) {
			return;
		}
		
		int index = mSize;
		int parentIndex = Math.floorDiv(index, 2);
		while(parentIndex >= 1 && mArray[index] > mArray[parentIndex]) {
			int temp = mArray[parentIndex];
			mArray[parentIndex] = mArray[index];
			mArray[index] = temp;
			index = parentIndex;
			parentIndex = Math.floorDiv(index, 2);
		}
	}
	
	public Optional<Integer> deleteRoot() {
		Optional<Integer> root = Optional.empty();
		if(mSize == 0) {
			System.out.println("Heap is empty.");
			return root;
		}
		root = Optional.of(mArray[1]);
		
		if(mSize == 1) {
			mSize = 0;
			return root;
		}
		
		mArray[1] = mArray[mSize];
		mSize--;
		restoreDown();
		
		return root;
	}
	
	public void restoreDown() {
		int parentIndex = 1;
		int leftIndex = 2 * parentIndex;
		int rightIndex = (2 * parentIndex) + 1;
		boolean moveLeft = false;
		while(leftIndex <= mSize) {
			
			if(!leftChildIsGreaterThanParent(parentIndex, leftIndex) &&
					!rightChildIsGreaterThanParent(parentIndex, rightIndex)) {
				break;
			}
			
			int temp = mArray[parentIndex];
			
			if(rightIndex <= mSize) {
				//Check if both the left child and right child are greater than the parent
				if(mArray[leftIndex] > mArray[parentIndex]
						&&
						mArray[rightIndex] > mArray[parentIndex]) {
					if(mArray[leftIndex] > mArray[rightIndex]) {
						mArray[parentIndex] = mArray[leftIndex];
						mArray[leftIndex] = temp;
						moveLeft = true;
					} else {
						mArray[parentIndex] = mArray[rightIndex];
						mArray[rightIndex] = temp;
						moveLeft = false;
					}
				} else if(rightChildIsGreaterThanParent(parentIndex, rightIndex)) {
					mArray[parentIndex] = mArray[rightIndex];
					mArray[rightIndex] = temp;
					moveLeft = false;
				}
			}
			
			if(leftChildIsGreaterThanParent(parentIndex, leftIndex)) {
				mArray[parentIndex] = mArray[leftIndex];
				mArray[leftIndex] = temp;
				moveLeft = true;
			}
			
			if(moveLeft) {
				parentIndex = leftIndex;
			} else {
				parentIndex = rightIndex;
			}
			
			leftIndex = 2 * parentIndex;
			rightIndex = (2 * parentIndex) + 1;
		}
	}

	private boolean rightChildIsGreaterThanParent(int parentIndex, int rightIndex) {
		return rightIndex <= mSize && mArray[rightIndex] > mArray[parentIndex];
	}
	
	private boolean leftChildIsGreaterThanParent(int parentIndex, int leftIndex) {
		return leftIndex <= mSize && mArray[leftIndex] > mArray[parentIndex];
	}
	
	public void display() {
		display(1, 0);
		System.out.println();
	}
	
	private void display(int index, int level) {
		if(index > mSize) {
			return;
		}
		
		display(2 * index + 1, level + 1);
		System.out.println();
		
		for(int count = 0; count < level; count++) {
			System.out.print("     ");
		}
		System.out.print(mArray[index]);
		
		display(2 * index, level + 1);
	}
	
	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap();
		int[] arr = {85, 70, 55, 56, 40, 42, 33, 16, 28, 19, 20, 25, 80};
		for(int num: arr) {
			heap.insert(num);
		}
		heap.display();
		
		heap.deleteRoot();
		System.out.println("-----------------------------------------------------------");
		
		heap.display();
	}
}
