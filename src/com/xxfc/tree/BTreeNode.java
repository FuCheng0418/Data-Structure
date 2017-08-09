package com.xxfc.tree;

public class BTreeNode<T> {
	private T value;
	private BTreeNode<T> lNode;
	private BTreeNode<T> rNode;

	public BTreeNode(T value) {
		this.setValue(value);
	}

	public BTreeNode(T value, BTreeNode<T> lNode, BTreeNode<T> rNode) {
		this.setValue(value);
		this.lNode = lNode;
		this.rNode = rNode;
	}

	public BTreeNode<T> getlNode() {
		return lNode;
	}

	public void setlNode(BTreeNode<T> lNode) {
		this.lNode = lNode;
	}

	public BTreeNode<T> getrNode() {
		return rNode;
	}

	public void setrNode(BTreeNode<T> rNode) {
		this.rNode = rNode;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
