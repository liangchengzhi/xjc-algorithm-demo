package com.xjc.algorithm.liangcz.geek.lession6_linkedlist_1;

import org.junit.Test;

/**
 * 双向链表测试
 * @author liangcz
 *
 */
public class LinkedListTest {
	@Test
	public void test_create_LinkedList(){
		LinkedList linkedList = new LinkedList();
		linkedList.put("我是一");
		linkedList.put("我是二");
		linkedList.put("我是三");
		linkedList.printAll();
	}
	@Test
	public void test_insertToHead(){
		LinkedList linkedList = new LinkedList();
		linkedList.put("我是一");
		linkedList.put("我是二");
		linkedList.put("我是三");
		linkedList.insertToHead(linkedList.new Node("我是零"));
		linkedList.printAll();
	}
	@Test
	public void test_insertToTail(){
		LinkedList linkedList = new LinkedList();
		linkedList.put("我是一");
		linkedList.put("我是二");
		linkedList.put("我是三");
		linkedList.insertToTail(linkedList.new Node("我是四"));
		linkedList.printAll();
	}
	@Test
	public void test_deleteByNode(){
		LinkedList linkedList = new LinkedList();
		linkedList.put("我是一");
		linkedList.put("我是二");
		linkedList.put("我是三");
		linkedList.deleteByNode(linkedList.findByValue("我是三"));
		linkedList.printAll();
	}
	@Test
	public void test_insertBefore(){
		LinkedList linkedList = new LinkedList();
		linkedList.put("我是一");
		linkedList.put("我是二");
		linkedList.put("我是三");
		linkedList.insertBefore(linkedList.findByValue("我是二"), linkedList.new Node("我是一点五"));
		linkedList.printAll();
	}
	@Test
	public void test_insertAfter(){
		LinkedList linkedList = new LinkedList();
		linkedList.put("我是一");
		linkedList.put("我是二");
		linkedList.put("我是三");
		linkedList.insertAfter(linkedList.findByValue("我是二"), linkedList.new Node("我是二点五"));
		linkedList.printAll();
	}
}
