package com.xjc.algorithm.liangcz.leetcode;


/**
 * 链表反转
 * @author liangcz
 *
 */
public class ReverseList_206 {
	 /**
		 * 链表反转
		 * @param head
		 * @return
		 */
		public ListNode reverseList(ListNode head) {
			if(head == null){
				return null;
			}
			int nodeLen = 1;
			ListNode nowNode = head;
			while(nowNode.next != null){
				nodeLen++;
				nowNode = nowNode.next;
			}
			int[] arry = new int[nodeLen];
			nowNode = head;
			int i = 0;
			while(nowNode.next != null){
				arry[i++] = nowNode.val;
				nowNode = nowNode.next;
			}
	        arry[i] = nowNode.val;
			ListNode listNode = new ListNode(arry[nodeLen-1]);
			ListNode newNowNode = listNode;
			for (int j = nodeLen-2; j >= 0; j--) {
				ListNode tmpNode = new ListNode(arry[j]); 
				newNowNode.next = tmpNode;
				newNowNode = tmpNode;
			}
			return listNode;
		}
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
}
