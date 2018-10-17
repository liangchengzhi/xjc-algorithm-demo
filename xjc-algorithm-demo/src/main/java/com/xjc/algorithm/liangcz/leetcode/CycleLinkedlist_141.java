package com.xjc.algorithm.liangcz.leetcode;

import java.util.HashSet;

/**
 * 有环链表，链表中存在两个一样的链表，指针相等
 * 有环链表判断
 * @author liangcz
 *
 */
public class CycleLinkedlist_141 {
	/**
	 * 判断链表是否有环
	 * 时间复杂度 O(n) 空间复杂度O(n)
	 * 哈希法
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        HashSet<ListNode> set = new HashSet<ListNode>();
		while(head != null){
			if(set.contains(head)){
				return true;
			}
	        set.add(head);
			head = head.next;
		}
		return false;
    }
	/**
	 * 判断链表是否有环
	 * 快慢指针法
	 * 时间复杂度 	O(n) 空间复杂度O(1)
	 * @param head
	 * @return
	 */
	public static boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(slow != fast){
        	if(fast == null || fast.next == null){
        		return false;
        	}
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return true;
    }

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
		public String toString(){
			return String.valueOf(val);
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		head.next = node1;
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = node2;
		ListNode node4 = new ListNode(-1);
		node3.next = node4;
		node4.next = head;
		long begin = System.currentTimeMillis();
		boolean result = hasCycle1(head);
		System.out.println("花时间：" + (System.currentTimeMillis() - begin));
		System.out.println(result);
	}
}
