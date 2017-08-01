package com.veda.stack;

import java.util.Stack;

public class InfixToPrefixConverter {
	private StringBuilder mStringBuilder;
	private Stack<Character> mStack;
	
	public InfixToPrefixConverter() {
		mStringBuilder = new StringBuilder();
		mStack = new Stack<>();
	}
	
	
	public String convert(String infixExpression) {
		char[] arr = infixExpression.trim().toCharArray();
		if(arr.length == 0) {
			return "";
		}
		
		char poppedOperator = ' ';
		for(char ch: arr) {
			if(itsOperand(ch)) {
				mStringBuilder.append(ch);
			} else {
				if(mStack.isEmpty()) {
					pushOperatorToStack(ch);
				} else {
					while(stackedOperandHasHigherPrecedence(ch)) {
						poppedOperator = mStack.pop();
						if(poppedOperator != '(' && poppedOperator != ')') {
							mStringBuilder.append(poppedOperator);
						} else {
							break;
						}
					}
					pushOperatorToStack(ch);
				}
			}
		}
		
		while(!mStack.isEmpty()) {
			char popped = mStack.pop();
			if(popped != '(') {
				mStringBuilder.append(popped);
			}
		}
		return mStringBuilder.toString();
	}
	
	private void pushOperatorToStack(char ch) {
		if(ch != ')') {
			mStack.push(ch);
		}
	}
	
	private int precedence(char ch) {
		if(ch == '^') {
			return 1;
		} else if(ch == '*' || ch == '/') {
			return 2;
		} else if(ch == '+' || ch == '-') {
			return 3;
		} else if(ch == ')'){
			return 4;
		} else {
			return 5;
		}
	}
	
	private boolean stackedOperandHasHigherPrecedence(char ch) {
		if(mStack.isEmpty() || ch == '(') {
			return false;
		}
		if(ch == ')') {
			return true;
		}
		
		if(precedence(mStack.peek()) <= precedence(ch)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	private boolean itsOperand(char ch) {
		if(ch != '^' && ch != '*' && ch != '/' && ch != '+' && ch != '-' && ch != '(' && ch != ')') {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		InfixToPrefixConverter converter = new InfixToPrefixConverter();
		String infixRepresentation = "5+8*3^2/(8-2^2)+7*3";
		String prefixRepresentation =converter.convert(infixRepresentation);
		System.out.printf("The infix representation of %s in prefix is %s \n", 
				infixRepresentation, prefixRepresentation);
	}
}
