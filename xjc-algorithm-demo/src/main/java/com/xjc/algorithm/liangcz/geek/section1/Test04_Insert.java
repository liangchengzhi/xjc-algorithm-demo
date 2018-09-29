package com.xjc.algorithm.liangcz.geek.section1;

public class Test04_Insert {
	int countExecuteLine = 0;
	private int n = 10; // 为了编译通过，这里设了一个n的值,n应该是变量
	int[] array = new int[n];
	int count = 0;
	/**
	 * 插入
	 * 达到n次后循环一次，否则直接赋值
	 * 最好时间复杂度：O(1)
	 * 最坏时间复杂度:O(n)
	 * 平均时间复杂度:O(1)
	 * 均摊时间复杂度:O(1)
	 * @param val
	 */
	public void insert(int val){
		System.out.println(count + "|" + array.length);
		if(count == array.length){
			int sum = 0;
			for (int i = 0; i < array.length; i++) {
				sum = sum + array[i];
				if(i == array.length - 1){
					System.out.println("执行" + count + "次循环");
				}
			}
			array[0] = sum;
			count = 1;
		}
		array[count] = val;
		++count;
	}
	
	public static void main(String[] args) {
		Test04_Insert insertClass = new Test04_Insert();
		while(true){
			insertClass.insert(10);	
		}
	}
}
