package com.xjc.algorithm.liangcz.geek.lession9_queue;
/**
 * 循环队列
 * 循环队列避免出列和入列对数据的搬运
 * 要注意数据满和数据为空的判断
 * 为了区分数据满和数据空，增加了一个位置的空
 * @author liangcz
 *
 */
public class CircularQueue {
	/**
	 * 数据
	 */
	private String items[];
	private int n = 0;
	/**
	 * 队头下标
	 */
	private int head = 0;
	/**
	 * 队尾下标
	 */
	private int tail = 0;
	public CircularQueue(int capcity){
		items = new String[capcity];
		n = capcity;
	}
	/**
	 * 入列
	 * @param item
	 * @return
	 */
	public boolean enqueue(String item){
		if((tail + 1) % n == head){ // 队列已满了
			return false;
		}
		items[tail] = item;
		tail = (tail + 1) % n;
		return true;
	}
	/**
	 * 出列
	 * @param item
	 * @return
	 */
	public String dequeue(){
		if(head == tail){ // 队列为空
			return null;
		}
		String ret = items[head];
		head = (head + 1) % n;
		return ret;
	}
	
	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(5);
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		queue.enqueue("e");
		queue.enqueue("f");
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
