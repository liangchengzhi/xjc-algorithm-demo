package com.xjc.algorithm.liangcz.geek.lession16_skiplist;

import java.util.Arrays;
import java.util.Random;

/**
 * 跳表，小鸡翅实现类
 * @author liangcz
 *
 */
public class SkipListForXJC {
	public static final int MAX_LEVEL = 16; // 索引最高级
	private Node head = new Node(); // 头节点
	Random ran = new Random();
	private int nowLevel = 0; // 当前使用最大索引级别
	/**
	 * 查找节点
	 * @param value
	 * @return
	 */
	public Node find(int value){
		Node p = head;
		// 从最高级往下找，找到最适合的层级
		for (int i = nowLevel-1; i >= 0; i--) {
			while(p.forwards[i] != null && p.forwards[i].data < value){
				p = p.forwards[i];
			}
		}
		if(p.forwards[0] != null && p.forwards[0].data == value){
			return p.forwards[0];
		}
		return null;
	}
	/**
	 * 插入节点
	 * @param value
	 */
	public void insert(int value){
		Node newNode = new Node();
		int maxLevel = getRandomLevel();
		newNode.setData(value);
		newNode.setMaxLevel(maxLevel);
		
		Node p = head;
		Node[] updates = new Node[maxLevel];
		// 初始化更新节点
		for (int i = 0; i < updates.length; i++) {
			updates[i] = head;
		}
		// 找到每一层的插入点
		for (int i = maxLevel-1; i >= 0; i--) {
			while(p.forwards[i] != null && p.forwards[i].data < value){
				p = p.forwards[i];
			}
			updates[i] = p;
		}
		// 插入节点
		for (int i = 0; i < maxLevel; i++) {
			newNode.forwards[i] = updates[i].forwards[i];
			updates[i].forwards[i] = newNode;
		}
		if(nowLevel < maxLevel){
			nowLevel = maxLevel;
		}
	}
	/**
	 * 顺序打印所有节点
	 */
	public void printAll(){
		Node p = head;
		while(p.forwards[0] != null){
			System.out.println(p.forwards[0]);
			p = p.forwards[0];
		}
	}
	/**
	 * 获取随机层级
	 * @return
	 */
	public int getRandomLevel(){
		int level = 0;
		for (int i = 0; i < MAX_LEVEL; i++) {
			if(ran.nextInt() % 2 == 0){
				level++;
			}
		}
		return level;
	}
	
	
	
	class Node{
		/**
		 * 存放数据
		 */
		private int data = -1;
		/**
		 * 索引节点
		 */
		private Node[] forwards = new Node[MAX_LEVEL];
		/**
		 * 该索引链表的最高层级
		 */
		private int maxLevel = 0;
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node[] getForwards() {
			return forwards;
		}
		public void setForwards(Node[] forwards) {
			this.forwards = forwards;
		}
		public int getMaxLevel() {
			return maxLevel;
		}
		public void setMaxLevel(int maxLevel) {
			this.maxLevel = maxLevel;
		}
		@Override
		public String toString() {
			return "Node [data=" + data  + ", maxLevel=" + maxLevel
					+ "]";
		}
		
	}
	public static void main(String[] args) {
		SkipListForXJC skipList = new SkipListForXJC();
		int n = 100;
		for (int i = 0; i < n; i++) {
			skipList.insert(i);
		}
		skipList.printAll();
		Node node = skipList.find(100);
		System.out.println(node);
	}
}
