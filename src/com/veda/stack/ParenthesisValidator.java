package com.veda.stack;

import java.util.Stack;

public class ParenthesisValidator {
	private Stack<Character> mStack;
	static final String EMPTY = "";
	
	public ParenthesisValidator() {
		mStack = new Stack<>();
	}
	
	public boolean validate(String expressionString) {
		if(EMPTY.equals(expressionString.trim())) {
			return true;
		}
		
		char[] arr = expressionString.trim().toCharArray();
		char popped;
		for(char ch: arr) {
			if(ch == '(' || ch == '[' || ch == '{') {
				mStack.push(ch);
			} else if(ch == ')' || (ch == ']') || (ch == '}')) {
				if(mStack.empty()) {
					return false;
				}
				popped = mStack.pop();
				if(ch == ')' && popped != '(') {
					return false;
				} else if(ch == ']' && popped != '[') {
					return false;
				} else if(ch == '}' && popped != '{') {
					return false;
				}
			}
		}
		return mStack.isEmpty();
	}
	public static void main(String[] args) {
		ParenthesisValidator validator = new ParenthesisValidator();
		boolean valid = validator.validate("[p/{q-r}^s]");
		String result = valid?"The expression is valid":"The expression is not valid";
		System.out.println(result);
	}
}
