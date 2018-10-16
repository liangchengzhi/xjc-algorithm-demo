package com.xjc.algorithm.liangcz.geek.lession6_linkedlist_1;
/**
 * 双向链表
 * @author liangcz
 *
 */
public class LinkedList {
	/**
	 * 头节点
	 */
	private Node headNode;
	/**
	 * 尾部节点
	 */
	private Node tailNode;
	public LinkedList(){
		
	}
	/**
	 * 存放数据
	 * @param data
	 */
	public void put(String data){
		Node node = new Node(data);
		if(headNode == null){
			node.setPrev(null);
			node.next = null;
			headNode = node;
			tailNode = node;
		}else{
			tailNode.next = node;
			node.prev = tailNode;
			tailNode = node;
		}
	}
	/**
	 * 根据值来寻找
	 * @param value
	 * @return
	 */
	public Node findByValue(String value){
		Node nowNode = headNode;
		Node findNode = null;
		while(nowNode.next != null){
			if(value.equals(nowNode.data)){
				findNode = nowNode;
				break;
			}
			nowNode = nowNode.next;
		}
		if(value.equals(nowNode.data)){
			findNode = nowNode;
		}
		return findNode;
	}
	/**
	 * 根据index来寻找
	 * @param value
	 * @return
	 */
	public Node findByIndex(int index){
		Node nowNode = headNode;
		Node findNode = null;
		int i = 0;
		while(nowNode.next != null){
			if(index == i){
				findNode = nowNode;
				break;
			}
			nowNode = nowNode.next;
			i++;
		}
		if(index == i){
			findNode = nowNode;
		}
		return findNode;
	}
	/**
	 * 在头部插入
	 * @param value
	 */
	public void insertToHead(Node node){
		node.next = headNode;
		node.prev = null;
		headNode = node;
	}
	/**
	 * 在头部插入
	 * @param value
	 */
	public void insertToTail(Node node){
		insertAfter(tailNode, node);
	}
	/**
	 * 在前面插入
	 * @param value
	 */
	public void insertBefore(Node node,Node newNode){
		if(newNode == null){
			return;
		}
		if(node == headNode){
			insertToHead(newNode);
			return;
		}
		newNode.next = node;
		newNode.prev = node.prev;
		node.prev.next = newNode;
	}
	/**
	 * 在后面插入
	 * @param value
	 */
	public void insertAfter(Node node,Node newNode){
		if(newNode == null){
			return;
		}
		newNode.next = node.next;
		newNode.prev = node;
		node.next = newNode;
		if(!tailNode.equals(node)){
			node.next.prev = newNode;
		}
		tailNode = newNode;
	}
	/**
	 * 删除节点
	 * @param node
	 */
	public void deleteByNode(Node node){
		if(node == null){
			return;
		}
		Node nowNode = headNode;
		while(nowNode.next != null){
			if(node.equals(nowNode)){
				node.prev.next = node.next;
				if(node.equals(tailNode)){
					tailNode = node.prev;
				}else{
					node.next.prev = node.prev;
				}
				break;
			}
			nowNode = nowNode.next;
		}
		if(node.equals(nowNode)){
			node.prev.next = node.next;
			if(node.equals(tailNode)){
				tailNode = node.prev;
			}else{
				node.next.prev = node.prev;
			}
		}
	}
	/**
	 * 打印所有
	 */
	public void printAll(){
		Node nowNode = headNode;
		while(nowNode.next != null){
			System.out.println(nowNode.data);
			nowNode = nowNode.next;
		}
		System.out.println(nowNode.data);
	}
	public class Node{
		/**
		 * 上个节点
		 */
		private Node prev;
		/**
		 * 数据
		 */
		private String data;
		/**
		 * 下个节点
		 */
		private Node next;
		public Node(String data){
			this.data = data;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
	}
	
}
