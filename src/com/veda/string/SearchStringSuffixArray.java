package com.veda.string;

import java.util.Arrays;

public class SearchStringSuffixArray {
	public static String[] suffixes(String str) {
		if(str == null || str.trim().length() == 0) {
			return null;
		}
		
		int length = str.length();
		String[] suffixes = new String[length];
		for(int index = 0; index < length; index++) {
			suffixes[index] = str.substring(index);
		}
		return suffixes;
	}
	
	public static void search(String text, String searchText) {
		String[] suffixArr = suffixes(text);

		for(int index = 0; index < suffixArr.length; index++) {
			System.out.println(suffixArr[index]);
		}
		
		
		Arrays.sort(suffixArr);
		
		
		int lowIndex = 0, highIndex = suffixArr.length;
		int midIndex = (lowIndex + highIndex) / 2;
		boolean foundAMatch = false;
		while(lowIndex < highIndex) {
			if(suffixArr[midIndex].equals(searchText) ) {
				System.out.println("Found a match " + suffixArr[midIndex]);
				foundAMatch = true;
				break;
			} else if(suffixArr[midIndex].compareTo(searchText) > 0){
				highIndex = midIndex - 1;
			} else {
				lowIndex = midIndex + 1;
			}
			
			midIndex = (lowIndex + highIndex) / 2;
			
			if(lowIndex == midIndex || highIndex == midIndex) {
				System.out.println(suffixArr[midIndex]);
				if(suffixArr[midIndex].startsWith(searchText)) {
					System.out.println("Found a match in " + suffixArr[midIndex]);
					foundAMatch = true;
					break;
				} else {
					break;
				}
			}
			
		}
		if(!foundAMatch) {
			System.out.println("Did not find a match.");
		}
	}
	
	public static void main(String[] args) {
		String text = "It was the best of times";
		String searchText = "tim";
		search(text, searchText);
	}
}
