package com.xxfc.queue;

import com.xxfc.link.Node;

/**
 * 用連結實現Queue
 * 
 * @author Eric
 *
 * @param <T>
 */
public class LinkQueue<T> {

	/**
	 * 最後的節點
	 */
	Node<T> front;

	/**
	 * 最後的節點
	 */
	Node<T> rear;

	/**
	 * Queue的大小
	 */
	int size;

	/**
	 * 建構子，須設定Queue的大小
	 * 
	 * @param size
	 *            設定Queue的大小
	 */
	public LinkQueue(int size) {
		front = null;
		rear = null;
		this.size = size;
	}

	/**
	 * 加入新節點到Queue
	 * 
	 * @param data
	 * @return
	 */
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

	/**
	 * 自Queue取出並移除節點
	 * 
	 * @return
	 */
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

	/**
	 * Queue是否為空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return front == null;
	}

	public static void main(String[] arg) {
		LinkQueue<String> queue = new LinkQueue<String>(4);
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
