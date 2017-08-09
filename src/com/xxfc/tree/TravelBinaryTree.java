package com.xxfc.tree;

public class TravelBinaryTree {

	public static void main(String[] args) {
		// build binary tree
		TravelBinaryTree bTree = new TravelBinaryTree();
		String[] values = new String[] { "A", "B", "C", "D", "E", "F", "G",
				"H", "I" };
		BTreeNode<String>[] array = new BTreeNode[9];
		for (int i = 0; i < 9; i++) {
			BTreeNode<String> node = new BTreeNode<String>(values[i]);
			array[i] = node;
		}
		array[0].setlNode(array[1]);
		array[0].setrNode(array[2]);
		array[1].setlNode(array[3]);
		array[2].setrNode(array[4]);
		array[3].setlNode(array[5]);
		array[3].setrNode(array[6]);
		array[4].setlNode(array[7]);
		array[4].setrNode(array[8]);

		preTravel(array[0]);
		System.out.println();
		System.out.println("-----------");
		inTravel(array[0]);
		System.out.println();
		System.out.println("-----------");
		postTravel(array[0]);
		System.out.println();
		System.out.println("-----------");
	}

	// 中序走訪
	static void inTravel(BTreeNode<String> node) {
		if (node != null) {
			inTravel(node.getlNode());
			System.out.print(node.getValue());
			inTravel(node.getrNode());
		}
	}

	// 前序走訪PreOrder
	static void preTravel(BTreeNode<String> node) {
		if (node != null) {
			System.out.print(node.getValue());
			preTravel(node.getlNode());
			preTravel(node.getrNode());

		}
	}

	// 後序走訪PreOrder
	static void postTravel(BTreeNode<String> node) {
		if (node != null) {
			postTravel(node.getlNode());
			postTravel(node.getrNode());
			System.out.print(node.getValue());
		}
	}

}