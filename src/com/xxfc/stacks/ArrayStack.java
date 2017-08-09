package com.xxfc.stacks;

public class ArrayStack {
	int top;
	String[] stack;

	public ArrayStack() {
		super();
	}

	public ArrayStack(int size) {
		top = 0;
		stack = new String[size];
	}

	public boolean push(String data) {
		if (top < stack.length) {
			stack[top++] = data;
			return true;
		} else {
			return false;
		}
	}

	public String pop() {
		if (top > 0) {
			return stack[--top];
		} else {
			return null;
		}
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public boolean isFull() {
		return top == stack.length;
	}

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(3);
		int i = 1;
		while (!stack.isFull()) {
			System.out.println("put:" + String.valueOf(i));
			stack.push(String.valueOf(i++));

		}
		System.out.println("--------------");
		while (!stack.isEmpty()) {
			System.out.println("pop:" + stack.pop());
		}
		System.out.println("--------------");
	}

}
