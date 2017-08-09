package com.xxfc.queue;

/**
 * 用陣列實現Queue
 * 
 * @author Eric
 *
 */
public class ArrayQueue {

	/**
	 * 最前的index
	 */
	int front;

	/**
	 * 最後的index
	 */
	int rear;

	/**
	 * Queue是否為空
	 */
	boolean isEmpty;

	/**
	 * 存放Queue的陣列
	 */
	String[] array;

	/**
	 * 建構子，須設定Queue的大小
	 * 
	 * @param size
	 *            設定Queue的大小
	 */
	public ArrayQueue(int size) {
		array = new String[size];
		front = 0;
		rear = 0;
		isEmpty = true;
	}

	/**
	 * 加入新的字串到Queue
	 * 
	 * @param string
	 * @return
	 */
	public boolean enqueue(String string) {
		// int newRear = (rear + 1) % array.length;
		System.out.println("new rear index:" + rear);
		if (rear != front || (isEmpty && rear == front)) {
			array[rear] = string;
			rear = (rear + 1) % array.length;
			isEmpty = false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 自Queue取出並移除字串
	 * 
	 * @return
	 */
	public String dequeue() {
		String result = null;
		if (front < rear || (front == rear && !isEmpty)) {
			result = array[front];
			front = front + 1;
			if (front == rear) {
				isEmpty = true;
			}
		} else if (front > rear) {
			result = array[front];
			front = (front + 1) % array.length;
			if (front == rear) {
				isEmpty = true;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(4);
		System.out.println(queue.enqueue("1"));
		System.out.println(queue.enqueue("2"));
		System.out.println(queue.enqueue("3"));
		System.out.println(queue.enqueue("4"));
		System.out.println("==========");
		System.out.println(queue.enqueue("5"));
		System.out.println("===error====");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println("==========");
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue("4");
		queue.enqueue("5");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		System.out.println("==========");
	}

}
