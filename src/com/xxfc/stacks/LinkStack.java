package com.xxfc.stacks;

import com.xxfc.link.Node;

public class LinkStack<T> {
	Node<T> topNode;

	public LinkStack() {
		topNode = null;
	}

	public void push(T data) {
		Node<T> node = new Node<T>(data);
		node.setNextNode(topNode);
		topNode = node;
	}

	public T pop() {
		T data = topNode.getData();
		topNode = topNode.getNextNode();
		return data;
	}

	public boolean isEmpty() {
		return topNode == null;
	}

	public static void main(String[] args) {
		String[] data = new String[] { "1", "2", "3", "4", "5" };
		LinkStack ls = new LinkStack();
		for (String str : data) {
			ls.push(str);
			System.out.println("put:" + str);
		}
		System.out.println("----------------");

		while (!ls.isEmpty()) {
			System.out.println("pop:" + ls.pop());
		}
		System.out.println("----------------");
	}
}
