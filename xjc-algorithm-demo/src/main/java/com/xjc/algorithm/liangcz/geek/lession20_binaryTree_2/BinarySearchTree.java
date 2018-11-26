package com.xjc.algorithm.liangcz.geek.lession20_binaryTree_2;
/**
 * 二分查找树
 * @author liangcz
 *
 */
public class BinarySearchTree {
	private Node root;
	/**
	 * 查找
	 * @param data
	 * @return
	 */
	public Node find(int data){
		Node n = root;
		while(n != null){
			if(data < n.data){
				n = n.left;
			}else if(data == n.data){
				return n;
			}else if(data > n.data){
				n = n.right;
			}
		}
		return null;
	}
	/**
	 * 插入
	 */
	public void insert(int data){
		Node p = root;
		if(p == null) {
			root = new Node(data);
			return;
		}
		while(p != null){
			if(data < p.data){
				if(p.left == null){
					p.left = new Node(data);
					return;
				}
				p = p.left;
			}else{
				if(p.right == null){
					p.right = new Node(data);
					return;
				}
				p = p.right;
			}
		}
	}
	
	
	
	public static class Node{
		private Node left;
		private Node right;
		private int data;
		public Node(int data){
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
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return "Node [left=" + left + ", right=" + right + ", data=" + data
					+ "]";
		}
		
		
	}
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(10);
		Node node = binarySearchTree.find(10);
		System.out.println(node);
	}
}
