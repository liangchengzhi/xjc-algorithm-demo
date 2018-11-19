package com.xjc.algorithm.liangcz.geek.lession20_binaryTree_1;
/**
 * 二叉树遍历
 * @author liangcz
 *
 */
public class BinaryTreePrinter {
	/**
	 * 前序遍历
	 * @param tree
	 */
	public static void printDLR(Node tree){
		if(tree == null){
			return;
		}
		printNode(tree);
		Node left = tree.getLeft();
		Node right = tree.getRight();
		printDLR(left);
		printDLR(right);
	}
	/**
	 * 中序遍历
	 * @param tree
	 */
	public static void printLRD(Node tree){
		if(tree == null){
			return;
		}
		Node left = tree.getLeft();
		Node right = tree.getRight();
		printLRD(left);
		printNode(tree);
		printLRD(right);
	}
	/**
	 * 后序遍历
	 * @param tree
	 */
	public static void printRLD(Node tree){
		if(tree == null){
			return;
		}
		Node left = tree.getLeft();
		Node right = tree.getRight();
		printRLD(left);
		printNode(tree);
		printRLD(right);
	}
	/**
	 * 打印节点
	 * @param node
	 */
	public static void printNode(Node node){
		int data = -1;
		if(node != null){
			data = node.getData();
			System.out.println(data);
		}
	}
	
	/**
	 * 二叉树节点
	 * @author liangcz
	 *
	 */
	static public class Node{
		/**
		 * 数据
		 */
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			super();
			this.data = data;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		
	}
	public static void main(String[] args) {
		BinaryTreePrinter.Node tree = new BinaryTreePrinter.Node(0);
		Node node1 = new BinaryTreePrinter.Node(01);
		Node node2 = new BinaryTreePrinter.Node(02);
		tree.setLeft(node1);
		tree.setRight(node2);
		
		Node node11 = new BinaryTreePrinter.Node(11);
		Node node12 = new BinaryTreePrinter.Node(12);
		node1.setLeft(node11);
		node1.setRight(node12);
		
		Node node21 = new BinaryTreePrinter.Node(21);
		Node node22 = new BinaryTreePrinter.Node(22);
		node2.setLeft(node21);
		node2.setRight(node22);
		//printDLR(tree);
		printLRD(tree);
		// printRLD(tree);
	}
}
