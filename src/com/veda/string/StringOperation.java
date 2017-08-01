package com.veda.string;

public class StringOperation {
	public static int longestCommonPrefix(String string1, String string2) {
		if(string1 == null || string1.length() == 0 || string2 == null || string2.length() == 0) {
			return 0;
		}
		
		int minLength = Math.min(string1.length(), string2.length());
		for(int index = 0; index < minLength; index++) {
			if(string1.charAt(index) != string2.charAt(index)) {
				return index;
			}
			index++;
		}
		return minLength;
	}
	
	public static String reverse(String str) {
		if(str == null || str.trim().length() == 0) {
			return null;
		}
		
		int length = str.length();
		StringBuilder builder = new StringBuilder();
		for(int index = length - 1; index >= 0; index--) {
			builder.append(str.charAt(index));
		}
		return builder.toString();
	}
	
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
	
	public static void main(String[] args) {
		int index = StringOperation.longestCommonPrefix("prefetch", "a");
		int length = index == 0 ? -1 : index; 
		System.out.printf("The longest common prefix of %s and %s is %d \n", "prefetch", "prefix", length);
		
		String str = "prefetch";
		System.out.printf("Reverse of %s is %s \n", str, StringOperation.reverse(str));
	}
}
