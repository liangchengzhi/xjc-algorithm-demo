package com.xjc.algorithm.liangcz.geek.lession11_sort_1;

import java.util.Arrays;

/**
 * 选择排序
 * @author liangcz
 *
 */
public class SelectSort {
	/**
	 * 排序
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
	
	public static void main(String[] args) {
		int[] data = new int[]{6,2,1,4,3,5};
		sort(data);
		System.out.println(Arrays.toString(data));
	}
}
