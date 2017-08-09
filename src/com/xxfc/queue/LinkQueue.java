package com.xxfc.queue;

import com.xxfc.link.Node;

public class LinkQueue<T> {
	Node<T> front;
	Node<T> rear;
	int size;

	public LinkQueue(int size) {
		front = null;
		rear = null;
		this.size = size;
	}

	public boolean enqueue(T data) {
		if (size == 0) {
			return false;
		} else {
			Node<T> node = new Node<T>(data);
			if (front == null) {
				front = node;
			} else {
				rear.setNextNode(node);
			}
			rear = node;
			size--;
			return true;
		}
	}

	public T dequeue() {
		if (front != null) {
			T result = front.getData();
			front = front.getNextNode();
			size++;
			return result;
		} else {
			return null;
		}
	}

	public boolean isEmpty() {
		return front == null;
	}

	public static void main(String[] arg) {
		LinkQueue queue = new LinkQueue(4);
		System.out.println(queue.enqueue("1"));
		System.out.println(queue.enqueue("2"));
		System.out.println(queue.enqueue("3"));
		System.out.println(queue.enqueue("4"));
		System.out.println(queue.enqueue("5"));
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		System.out.println(queue.enqueue("6"));
		System.out.println(queue.enqueue("7"));
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}
}
