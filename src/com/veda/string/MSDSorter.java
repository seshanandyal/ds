package com.veda.string;

public class MSDSorter {
	static final int RADIX = 256 ; //extended ASCII;
	static String[] aux;
	
	public static void sort(String[] arr) {
		aux = new String[arr.length];
		sort(arr, 0, arr.length - 1, 0);
		for(int index = 0; index < arr.length; index++) {
			System.out.println(arr[index]);
		}
	}
	
	static void sort(String[] arr, int low, int high, int keyIndex) {
		if(high <= low) {
			return;
		}
		int[] count = new int[RADIX + 2];
		for (int index = low; index <= high; index++)
			   count[charAt(arr[index], keyIndex) + 2]++;
		
		//Compute the cumulative
		for(int radix = 0; radix < RADIX + 1; radix++) {
			count[radix+1] += count[radix];
		}
		
		//Access the cumulative
		for(int index = low; index <= high; index++) {
			aux[count[charAt(arr[index], keyIndex) + 1]++] = arr[index];
		}
		
		//Copy the aux to arr
		for(int index = low; index <= high; index++) {
			arr[index] = aux[index - low];
		}
		
		for(int radix = 0; radix < RADIX; radix++) {
			sort(arr, low + count[radix], low + count[radix + 1] - 1, keyIndex + 1);
		}
	}
	
	static int charAt(String str, int index) {
		if(index < str.length()) {
			return str.charAt(index);
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		String[] arr = generateTestData();
		sort(arr);
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
