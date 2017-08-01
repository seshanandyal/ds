package com.veda.stack;

import java.util.Stack;

public class PostfixEvaluator {
	private Stack<Double> mStack;
	
	public PostfixEvaluator() {
		mStack = new Stack<>();
	}
	public double evaluate(String infixRepresentation) {
		char[] arr = infixRepresentation.trim().toCharArray();
		double leftOperand, rightOperand;
		for(char ch: arr) {
			if(itsOperator(ch)) {
				rightOperand = mStack.pop();
				leftOperand = mStack.pop();
				double result = compute(ch, leftOperand, rightOperand);
				mStack.push(result);
			} else {
				mStack.push(new Double(Character.getNumericValue(ch)));
			}
		}
		return mStack.pop();
	}
	
	private double compute(char ch, double leftOperand, double rightOperand) {
		switch(ch) {
		case '^': return Math.pow(leftOperand, rightOperand);
		case '*': return leftOperand * rightOperand;
		case '/': return leftOperand / rightOperand;
		case '+': return leftOperand + rightOperand;
		default:  return leftOperand - rightOperand;
		}
	}
	
	private boolean itsOperator(char ch) {
		if(ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-') {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		InfixToPrefixConverter converter = new InfixToPrefixConverter();
		String infixRepresentation = "5+8*3^2/(8-2^2)+7*3";
		String prefixRepresentation =converter.convert(infixRepresentation);
		
		System.out.printf("The prefix representation of %s is %s \n", infixRepresentation, prefixRepresentation);
		
		PostfixEvaluator evaluator = new PostfixEvaluator();
		System.out.printf("The expression %s evaluates to %f \n", 
				infixRepresentation, evaluator.evaluate(prefixRepresentation));
	}
}
