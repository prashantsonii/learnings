package com.promouit.misc;

import java.util.Stack;

public class ExpressionUtils {
	public Integer evaluatePrefixExpression(String prefixExpression) {
		int strLength = prefixExpression.length();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < prefixExpression.length(); i++) {
			char c = prefixExpression.charAt(strLength - i - 1);
			Integer i1;
			Integer i2;
			switch (c) {
			case '+':
				i1 = stack.pop();
				i2 = stack.pop();
				stack.push(i1 + i2);
				break;
			case '-':
				i1 = stack.pop();
				i2 = stack.pop();
				stack.push(i1 - i2);
				break;
			case '*':
				i1 = stack.pop();
				i2 = stack.pop();
				stack.push(i1 * i2);
				break;
			case '/':
				i1 = stack.pop();
				i2 = stack.pop();
				stack.push(i1 / i2);
				break;
			default:
				stack.push(Integer.valueOf(c - 48));
				break;
			}
		}
		return stack.pop();
	}

	public Integer evaluatePostfixExpression(String postfixExpression) {
		Stack<Integer> stack = new Stack<Integer>();
		for (char c : postfixExpression.toCharArray()) {
			Integer i1;
			Integer i2;
			switch (c) {
			case '+':
				i1 = stack.pop();
				i2 = stack.pop();
				stack.push(i1 + i2);
				break;
			case '-':
				i1 = stack.pop();
				i2 = stack.pop();
				stack.push(i1 - i2);
				break;
			case '*':
				i1 = stack.pop();
				i2 = stack.pop();
				stack.push(i1 * i2);
				break;
			case '/':
				i1 = stack.pop();
				i2 = stack.pop();
				stack.push(i1 / i2);
				break;
			default:
				stack.push(Integer.valueOf(c - 48));
				break;
			}
		}
		return stack.pop();
	}
	
	public String convertInfixToPostfix(String infixExpression) {
		StringBuffer postfix = new StringBuffer();
		Stack<Character> operatorStack = new Stack<Character>();
		for (char c : infixExpression.toCharArray()) {
			if (c >= '0' && c <= '9') {
				postfix.append(c);
			} else if (c == '(') {
				operatorStack.push(c);
			} else if (c == ')') {
				char operator;
				while ((operator = operatorStack.pop()) != '(') {
					postfix.append(operator);
				}
			} else {
				while (!operatorStack.isEmpty()
						&& (precedence(operatorStack.peek()) > precedence(c))
						&& (operatorStack.peek() != '(')) {
					postfix.append(operatorStack.pop());
				}
				operatorStack.push(c);
			}
		}
		while (!operatorStack.isEmpty())
			postfix.append(operatorStack.pop());

		return postfix.toString();
	}

	private int precedence(Character operator) {
		switch (operator) {
		case '+':
			return 1;
		case '-':
			return 2;
		case '*':
			return 3;
		case '/':
			return 4;
		}
		return 0;
	}

}
