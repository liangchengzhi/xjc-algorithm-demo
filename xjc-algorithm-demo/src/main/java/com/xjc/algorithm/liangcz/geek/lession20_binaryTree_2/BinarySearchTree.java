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
	/**
	 * 删除节点
	 * @param data
	 */
	public boolean delete(int data){
		Node p = root; // 表示要删除的节点，初始化为根节点
		Node pp = null; 
		// 寻找节点对象
		while(p != null && p.data != data){
			pp = p;
			if(data > p.data) p = p.right;
			else p = p.left;
		}
		if(p == null) return false;// 没找到
		// 有两个字节点的场景，这里实现比较巧妙，是替换要删除的节点
		if(p.left != null && p.right != null){
			// 查找右子树的最左子节点，替换到要删除节点的位置
			Node minP = p.right;
			Node minPP = p; // minPP 表示minP 的父节点
			while(minP.left != null){
				minPP = minP;
				minP = minP.left;
			}
			p.data = minP.data;// 将值拷贝到原节点
			// 注意，后面相当于将要删除的节点变成minP节点了
			p = minP;
			pp = minPP;
		}
		// 删除节点是叶子节点或者仅有一个子节点
		// 寻找删除节点的child节点，有左右子节点，以左子节点为准
		Node child; // p的子节点
		if(p.left != null) child = p.left;
		else if(p.right != null) child = p.right;
		else child = null;
		// 找到了位置，不管是什么节点，都是按这个来操作。前面都是铺垫
		// 前提找到了pp p child
		if(pp == null){ // 要删除的节点是根节点
			root = child; 
		}else if(pp.left == p){
			pp.left = child;
		}else if(pp.right == p){
			pp.right = child;
		}
		return true;
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
