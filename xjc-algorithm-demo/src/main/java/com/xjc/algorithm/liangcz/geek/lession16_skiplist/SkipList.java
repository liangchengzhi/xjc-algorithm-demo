package com.xjc.algorithm.liangcz.geek.lession16_skiplist;

import java.util.Random;

import com.xjc.algorithm.liangcz.util.TimeCalcUtil;

/**
 * 跳表的一种实现方法。 跳表中存储的是正整数，并且存储的是不重复的。
 *
 * Author：ZHENG
 */
public class SkipList {

	private static final int MAX_LEVEL = 16;

	private int levelCount = 1;

	private Node head = new Node(); // 带头链表

	private Random r = new Random();
	
	public Node find(int value) {
		Node p = head;
		/* 最最顶层开始找，每一层都要遍历，如果一层中，比找的数小，则在区间内，作为down节点 */
		for (int i = levelCount - 1; i >= 0; --i) {
			while (p.forwards[i] != null && p.forwards[i].data < value) {
				p = p.forwards[i];
			}
		}
		/* 遍历完后，down节点第一个元素是，则是，否则没有该元素 */
		if (p.forwards[0] != null && p.forwards[0].data == value) {
			return p.forwards[0];
		} else {
			return null;
		}
	}

	public void insert(int value) {
		int level = randomLevel();
		Node newNode = new Node();
		newNode.data = value;
		newNode.maxLevel = level;
		Node update[] = new Node[level];
		/* 初始化更新数组，注意，这个update数组是纵向的，会把整个索引全部更新 */
  		for (int i = 0; i < level; ++i) {
			update[i] = head;
		}
  		
		Node p = head;
		/* 找到每个更新点的插入位置，同时把更新点前的forword数组节点，全部向后挪一位 */
		for (int i = level - 1; i >= 0; --i) {
			while (p.forwards[i] != null && p.forwards[i].data < value) {
				p = p.forwards[i];
			}
			update[i] = p;
		}
		/* 找到更新节点的位置，插入新节点 */
    	for (int i = 0; i < level; ++i) {
 			newNode.forwards[i] = update[i].forwards[i];
   			update[i].forwards[i] = newNode;
		}

 		if (levelCount < level)
 			levelCount = level;
	}

	public void delete(int value) {
		Node[] update = new Node[levelCount];
		Node p = head;
		for (int i = levelCount - 1; i >= 0; --i) {
			while (p.forwards[i] != null && p.forwards[i].data < value) {
				p = p.forwards[i];
			}
			update[i] = p;
		}

		if (p.forwards[0] != null && p.forwards[0].data == value) {
			for (int i = levelCount - 1; i >= 0; --i) {
				if (update[i].forwards[i] != null
						&& update[i].forwards[i].data == value) {
					update[i].forwards[i] = update[i].forwards[i].forwards[i];
				}
			}
		}
	}

	private int randomLevel() {
		int level = 1;
		for (int i = 1; i < MAX_LEVEL; ++i) {
			if (r.nextInt() % 2 == 1) {
				level++;
			}
		}

		return level;
	}

	public void printAll() {
		Node p = head;
		while (p.forwards[0] != null) {
			System.out.print(p.forwards[0] + " ");
			p = p.forwards[0];
		}
		System.out.println();
	}

	public class Node {
		private int data = -1;
		private Node forwards[] = new Node[MAX_LEVEL];
		private int maxLevel = 0;

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("{ data: ");
			builder.append(data);
			builder.append("; levels: ");
			builder.append(maxLevel);
			builder.append(" }");
			builder.append("\n");

			return builder.toString();
		}
	}

	public static void main(String[] args) {
		SkipList skipList = new SkipList();
		skipList.insert(5);
		skipList.insert(7);
		skipList.insert(9);
		/*
		int max = 10000;
		TimeCalcUtil.start();
		for (int i = 0; i < max; i++) {
			skipList.insert(i);
		}
		TimeCalcUtil.end();
		// skipList.printAll();
		TimeCalcUtil.start();
		Node node = skipList.find(1000);
		TimeCalcUtil.end();
		System.out.println(node);*/
		
	}

}
