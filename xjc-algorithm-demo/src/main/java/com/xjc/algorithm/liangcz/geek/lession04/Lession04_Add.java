package com.xjc.algorithm.liangcz.geek.lession04;

public class Lession04_Add {
	private int len = 10; // 为了编译通过，这里设了一个n的值,n应该是变量
	int[] array = new int[10];
	int i = 0;
	/**
	 * 分析：非循环，复杂度O(1)，每次达到一倍后，if判断里和外都增加一倍的执行次数
	 * [n次O(1),O(n)],扩容
	 * [2n次O(1),O(2n)],扩容
	 * [4n次O(1),O(4n)],扩容
	 * ...
	 * 所以
	 * 最好的时间复杂度O(1)
	 * 最坏的时间复杂度O(n)
	 * 平均时间复杂度O(1)  O(1)*1 + 
	 * 均摊时间复杂度O(1)
	 * 数组扩容，达到一定数量后，数组长度翻一倍
	 * @param elment
	 */
	public void add(int elment){
		if(i >= len){
			int new_array[] = new int[len * 2];
			for (int j = 0; j < new_array.length; j++) {
				new_array[j] = array[j];
			}
			array = new_array;                                
			len = 2 * len;                     
		}
		array[i] = elment;
		++i;
	}
	
	public static void main(String[] args) {
		Lession04_Add clazz = new Lession04_Add();
		while(true){
			clazz.add(10);	
		}
	}
}
