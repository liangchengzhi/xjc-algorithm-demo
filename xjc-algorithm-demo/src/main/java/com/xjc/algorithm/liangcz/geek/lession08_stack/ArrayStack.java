package com.xjc.algorithm.liangcz.geek.lession08_stack;
/**
 * 数组栈
 * @author liangcz
 *
 */
public class ArrayStack {
	/**
	 * 数据
	 */
	private String[] data;
	/**
	 * 栈中元素个数
	 */
	private int count;
	/**
	 * 栈大小
	 */
	private int n;
	public ArrayStack(int n){
		data = new String[n];
		this.n = n;
		count = 0;
	}
	/**
	 * 入栈 时间复杂度O(1) 空间复杂度O(1)
	 * @param element
	 * @return
	 */
	public boolean push(String element){
		if(count == n){
			return false;
		}
		data[count++] = element;
		return true;
	}
	/**
	 * 出栈 时间复杂度O(1) 空间复杂度O(1)
	 * @return
	 */
	public String pop(){
		if(count == 0){
			throw new RuntimeException("栈中没有元素");
		}
		return data[--count];
	}
}
