package com.veda.queue;

import java.util.Optional;

public class CircularQueue {
	private int mFront = -1;
	private int mRear = -1;
	private int[] mArr;

	static final int DEFAULT_MAX_SIZE = 5;

	public CircularQueue() {
		mArr = new int[DEFAULT_MAX_SIZE];
	}

	public CircularQueue(int size) {
		mArr = new int[size];
	}

	public boolean isEmpty() {
		return mFront == mRear && mFront == -1;
	}

	public boolean isFull() {
		if (mFront < mRear) {
			return (mRear - mFront + 1) == mArr.length;
		} else if (mFront > mRear) {
			int count = mArr.length - mFront;
			count = count + mRear + 1;
			return count == mArr.length;
		} else {
			return false;
		}
	}

	public void insert(int value) {
		if (!isFull()) {
			if (isEmpty()) {
				mFront = 0;
			}
			mRear = (mRear + 1) % mArr.length;
			mArr[mRear] = value;
			System.out.printf("Inserting %d \n", value);
			display();
		} else {
			System.out.printf("Circular quue is full. %d not added \n", value);
		}
	}

	public Optional<Integer> delete() {
		Optional<Integer> value = Optional.empty();
		if (!isEmpty()) {
			System.out.printf("Deleting %d \n", mArr[mFront]);
			value = Optional.of(mArr[mFront]);
			if (mFront == mRear) {
				mFront = -1;
				mRear = -1;
			} else {
				mFront = (mFront + 1) % mArr.length;
			}
		}
		display();
		return value;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Circular queue is empty.");
			return;
		}
		if (mFront <= mRear) {
			for (int index = mFront; index <= mRear; index++) {
				System.out.print(mArr[index] + "  ");
			}
			System.out.println();
		} else {
			for (int index = mFront; index < mArr.length; index++) {
				System.out.print(mArr[index] + "  ");
			}
			for (int index = 0; index < mFront; index++) {
				System.out.print(mArr[index] + "  ");
			}
			System.out.println();
		}
	}

	public Optional<Integer> peek() {
		if (isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(mArr[mFront]);
		}
	}

	public int size() {
		int size = 0;
		if (!isEmpty()) {
			if (mFront <= mRear) {
				size = mRear - mFront + 1;
			} else {
				size = mArr.length - mFront;
				size = size + mRear + 1;
			}
		}
		return size;
	}

	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue();
		queue.insert(12);
		queue.insert(31);
		queue.delete();
		queue.delete();
		queue.insert(65);
		queue.insert(23);
		queue.insert(14);
		queue.insert(78);
		queue.delete();
		queue.insert(56);
		queue.insert(76);
		queue.insert(44);
		queue.delete();
		queue.insert(10);
		queue.insert(51);
		queue.delete();
		queue.delete();
		queue.delete();
		queue.delete();
		queue.delete();
	}
}
