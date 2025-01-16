package com.veda.stack;

import java.util.*;

public class BasicCalculator {
    public static int calculator(String expression) {
        int result = 0, current = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(char ch: expression.toCharArray()) {
            if(Character.isDigit(ch)) {
                current = current * 10 + Character.getNumericValue(ch);
            } else if(ch == '+' || ch == '-') {
                result += (current * sign);
                if(ch == '+') sign = 1;
                else sign = -1;
                current = 0;
            } else if(ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if(ch == ')') {
                result += (sign * current);
                result *= stack.pop(); //sign will be on the top of the stack.
                result += stack.pop();
                current = 0;
            }
        }
        result += (current * sign);
        return result;
    }
}