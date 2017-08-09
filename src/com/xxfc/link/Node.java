package com.xxfc.link;

/**
 * 連結的節點
 * 
 * @author Eric
 *
 * @param <T>
 */
public class Node<T> {

	private Node<T> nextNode = null;
	private T data = null;

	public Node(T data) {
		this.setData(data);
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
