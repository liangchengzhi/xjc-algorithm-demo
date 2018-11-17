package com.xjc.algorithm.liangcz.geek.lession11_sort_1;

import java.util.Arrays;

/**
 * 插入排序
 * @author liangcz
 *
 */
public class InsertSort {
	/**
	 * 找到合适的位置插入
	 * @param data
	 */
	public static void sort(int[] data){
		int len = data.length;
		for (int i = 1; i < len; i++) {
			int value = data[i];
			for (int j = 0; j < i; j++) {
				if(value < data[j]){
					int tmp = data[j];
					data[j] = data[i];
					data[i] = tmp;
				}
			}
		}
		
	}
	/**
	 * 最好时间复杂度O(n) 最坏O(n^2)  平均O(n^2)
	 * @param data
	 */
	public static void sort1(int[] data){
		int len = data.length;
		for (int i = 1; i < len; i++) {
			int value = data[i];
			int j = i-1;
			for (; j >=0; --j) {
				if(value < data[j]){
					data[j+1] = data[j]; // 数据移动
				}else{
					break;
				}
			}
			data[j+1] = value; // 插入数据
		}
		
	}
	public static void main(String[] args) {
		int[] data = new int[]{6,2,1,4,3,5};
		sort1(data);
		System.out.println(Arrays.toString(data));
	}
}
