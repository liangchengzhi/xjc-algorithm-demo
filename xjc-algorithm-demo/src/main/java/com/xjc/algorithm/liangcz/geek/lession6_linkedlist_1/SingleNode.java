package com.xjc.algorithm.liangcz.geek.lession6_linkedlist_1;
/**
 * 单向链表
 * @author liangcz
 *
 */
public class SingleNode {
	/**
	 * 下一个链表
	 */
	private SingleNode next;
	/**
	 *  链表数据
	 */
	private String data;
	public SingleNode putData(String data){
		this.data = data;
		next = new SingleNode();
		return next;
	}
	/**
	 * 遍历
	 * @param singleNode
	 */
	public void walk(){
		SingleNode nowNode = this;
		while(nowNode.next != null){
			System.out.println(nowNode.data);
			nowNode = nowNode.next;
		}
	}
	/**
	 * 寻找
	 * @param data
	 * @return
	 */
	public SingleNode find(String data){
		SingleNode nowNode = this;
		while(nowNode.next != null){
			// System.out.println(nowNode.data);
			if(data.equals(nowNode.data)){
				return nowNode;
			}
			nowNode = nowNode.next;
		}
		throw new RuntimeException("找不到指定节点");
	}
	/**
	 * 插入  时间复杂度 O(n)
	 * @param data
	 * @return
	 */
	public void insert(String oldData,String insertData){
		/*SingleNode findNode = find(oldData);
		SingleNode newNode = new SingleNode();
		newNode.data = insertData;
		newNode.next = findNode.next;
		findNode.next = newNode;
		*/
		SingleNode nowNode = this;
		while(this.next != null){
			if(oldData.equals(nowNode.next.data)){
				SingleNode newNode = new SingleNode();
				newNode.data = insertData;
				newNode.next = nowNode.next;
				nowNode.next = newNode;
				break;
			}
			throw new RuntimeException("找不到指定节点");
		}
	}
	/**
	 * 删除 时间复杂度 O(n)
	 * @param data
	 * @return
	 */
	public void delete(String oldData){
		SingleNode nowNode = this;
		while(nowNode.next != null){
			if(oldData.equals(nowNode.next.data)){
				nowNode.next = nowNode.next.next;
				return;
			}
			nowNode = nowNode.next;
		}
		throw new RuntimeException("找不到指定节点");
	}
	public static void main(String[] args) {
		SingleNode singleNode = new SingleNode();
		singleNode.putData("我是一").putData("我是二").putData("我是三");
	/*	singleNode.putData("我是二");
		singleNode.putData("我是三");*/
		// singleNode.walk();
		// singleNode.find("我是二");
		singleNode.insert("我是二","我是一点五");
		// singleNode.walk();
		singleNode.delete("我是一点五");
		singleNode.walk();
	}
}
