package com.xxfc.tree;

import com.xxfc.queue.LinkQueue;

public class BTree {
	BTreeNode<Integer> root;
	int maxLevel;
	static final String BLANK = " ";
	LinkQueue<PrintInfo> linkQueue = new LinkQueue<PrintInfo>(30);

	public static void main(String[] args) {

		// build binary tree
		BTree bTree = new BTree();
		int[] values = new int[] { 6, 4, 1, 12, 43, 65, 19, 31, 39, 87, 99 };
		// BTreeNode<String>[] array = new BTreeNode[11];
		for (int i = 0; i < values.length; i++) {
			bTree.add(values[i]);
		}
		// ?為什麼要前後序走訪??
		preTravel(bTree.root);
		System.out.println();
		System.out.println("-----------");
		inTravel(bTree.root);
		System.out.println();
		System.out.println("-----------");
		postTravel(bTree.root);
		System.out.println();
		System.out.println("-----------");

		BTreeNode<Integer> node = search(bTree.root, 28);
		if (node == null) {
			System.out.println("not find");
		} else {
			System.out.println("find");
		}

		bTree.reCalculateMaxLevel(bTree.root, 0);
		System.out.println("max level:" + bTree.maxLevel);
		System.out.println("-------------------");
		bTree.printBTree(bTree.root, bTree.maxLevel);

	}

	public void add(int value) {
		BTreeNode<Integer> node = new BTreeNode<Integer>(value);
		BTreeNode<Integer> current = null;
		BTreeNode<Integer> backup = null;
		if (root == null) {
			root = node;
		} else {
			current = root;
			do {
				backup = current;
				if (current.getValue() > value) {
					current = current.getlNode();
				} else {
					current = current.getrNode();
				}

			} while (current != null);
			if (backup.getValue() > value) {
				backup.setlNode(node);
			} else {
				backup.setrNode(node);
			}
		}
	}

	public void delete(BTreeNode<Integer> node) {
		if (node.getlNode() != null && node.getrNode() != null) {
			BTreeNode<Integer> backup = null;
			BTreeNode<Integer> lNode = node.getlNode();
			while (lNode.getrNode() != null) {
				backup = lNode;
				lNode = lNode.getrNode();
			}
			node.setValue(lNode.getValue());
			if (backup != null) {
				backup.setrNode(null);
			} else {
				node.setlNode(node.getlNode().getlNode());
			}
		} else if (node.getlNode() == null) {
			// if(node=)
		}
	}

	public static BTreeNode<Integer> search(BTreeNode<Integer> rootNode,
			int value) {
		int count = 0; // 查詢次數
		BTreeNode<Integer> current = rootNode;

		while (true) {
			count++;
			if (current == null) {
				break;
			} else if (current.getValue() == value) {
				break;
			} else if (current.getValue() > value) {
				current = current.getlNode();
			} else {
				current = current.getrNode();
			}
		}
		System.out.println("time:" + count);
		return current;
	}

	void reCalculateMaxLevel(BTreeNode<Integer> node, int currentLevel) {
		if (node != null) {
			currentLevel++;
			if (maxLevel < currentLevel) {
				maxLevel = currentLevel;
			}
			reCalculateMaxLevel(node.getlNode(), currentLevel);
			reCalculateMaxLevel(node.getrNode(), currentLevel);
		}
	}

	void printBTree(BTreeNode<Integer> node, int maxLevel) {
		// 計算root的位置
		double position = calculatePosition(1, 0d, 1);
		for (int targetLevel = 1; targetLevel <= maxLevel; targetLevel++) {
			getLevelNode(node, 0, position, targetLevel);
			printOut(linkQueue);
			for (int line = 0; line < maxLevel / 5; line++) {
				System.out.println();
			}
		}
	}

	void getLevelNode(BTreeNode<Integer> node, int level, double position,
			int targetLevel) {
		if (node != null) {
			level++;
			if (targetLevel == level) {
				PrintInfo pInfo = new PrintInfo(node.getValue(), position);
				linkQueue.enqueue(pInfo);
			} else {
				double lNodePosition = calculatePosition(level + 1, position,
						-1); // -1 左
				getLevelNode(node.getlNode(), level, lNodePosition, targetLevel);
				double rNodePosition = calculatePosition(level + 1, position, 1); // 1
																					// 右
				getLevelNode(node.getrNode(), level, rNodePosition, targetLevel);
			}
		}
	}

	/**
	 * 總長度 為2^n-1 root 位置為 2^(n-1) lNod為 root位置 - 2^(n-2) rNode為 root位置 +2^(n-2)
	 * 
	 * @param currentLevel
	 *            該node的level
	 * @param parentPosition
	 *            父節點的位置
	 * @param phase
	 *            -1 左 1 右
	 * @return
	 */
	double calculatePosition(int currentLevel, double parentPosition, int phase) {
		double newPosition = parentPosition + phase
				* Math.pow(2, maxLevel - currentLevel);
		// System.out.printf(
		// "currentLevel:%s  P position:%s  LR:%s  newPosition:%s ",
		// currentLevel, position, phase, newPosition);
		// System.out.println();
		return newPosition;
	}

	static void printOut(LinkQueue<PrintInfo> linkQueue) {
		// link 已依小到大排序，依序取出後一個一個列印出來
		double tmpPosition = 0;
		StringBuilder stb = new StringBuilder();
		while (!linkQueue.isEmpty()) {
			PrintInfo pInfo = linkQueue.dequeue();
			double length = pInfo.position - tmpPosition;
			length = length - (String.valueOf(pInfo.value).length());
			tmpPosition += length;
			for (; length > 0; length--) {
				stb.append(BLANK);
			}
			stb.append(pInfo.value);

		}
		System.out.println(stb.toString());
	}

	// 中序走訪
	static void inTravel(BTreeNode<Integer> node) {
		if (node != null) {
			inTravel(node.getlNode());
			System.out.print(node.getValue() + ",");
			inTravel(node.getrNode());
		}
	}

	// 前序走訪PreOrder
	static void preTravel(BTreeNode<Integer> node) {
		if (node != null) {
			System.out.print(node.getValue() + ",");
			preTravel(node.getlNode());
			preTravel(node.getrNode());

		}
	}

	// 後序走訪PreOrder
	static void postTravel(BTreeNode<Integer> node) {
		if (node != null) {
			postTravel(node.getlNode());
			postTravel(node.getrNode());
			System.out.print(node.getValue() + ",");
		}
	}

}

class PrintInfo {
	Integer value;
	double position;

	public PrintInfo(Integer value, double position) {
		this.value = value;
		this.position = position;
	}

}