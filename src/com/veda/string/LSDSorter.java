package com.veda.string;

public class LSDSorter {
	String[] mArr;
	int mRadix;
	int mWordLength;
	
	public LSDSorter(String[] arr, int wordLength, int radix) {
		mArr = arr;
		mWordLength = wordLength;
		mRadix = radix;
	}
	
	public void sort() {
		String[] aux = new String[mArr.length];
		for(int index = mWordLength - 1; index >= 0; index--) {
			int[] temp = new int[mRadix+1];
			for(int counter = 0; counter < mArr.length; counter++) {
				temp[mArr[counter].charAt(index) + 1]++;
			}
			
			//Compute the cumulates
			for(int counter = 0; counter < mRadix; counter++) {
				temp[counter + 1] += temp[counter];
			}
			
			//Access the cumulates
			for(int counter = 0; counter < mArr.length; counter++) {
				int cumulateIndex = temp[mArr[counter].charAt(index)];
				temp[mArr[counter].charAt(index)]++;
				aux[cumulateIndex] = mArr[counter];
			}
			
			//Copy the aux to mArr
			for(int counter = 0; counter < mArr.length; counter++) {
				mArr[counter] = aux[counter];
				System.out.println(mArr[counter]);
			}
			
			System.out.println("---------------------------------------------------");
		}
	}
	
	public static void main(String[] args) {
		String[] arr = generateTestData();
		LSDSorter sorter = new LSDSorter(arr, 6, 256);
		sorter.sort();
	}
	
	static String[] generateTestData() {
		String[] arr = new String[5];
		arr[0] = "aditya";
		arr[1] = "zuluuu";
		arr[2] = "aryaaa";
		arr[3] = "boiiii";
		arr[4] = "oracle";
		return arr;
	}
}
