package com.xjc.algorithm.liangcz.geek.lession11_sort_1;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author liangcz
 *
 */
public class BubbleSort {
	/**
	 * 时间复杂度: O(n^2) 空间复杂度O(1)
	 * 排序
	 * @param data
	 */
	public static void sort(int[] data){
		int len = data.length;
		for (int i = len; i > 0; i--) {
			boolean swap = false; // 该标志，使如果数组有序则不再遍历
			for (int j = 0; j < i-1; j++) {
				if(data[j] > data[j+1]){
					int tmp = data[j+1];
					data[j+1] = data[j];
					data[j] = tmp;
					swap = true;
				}
			}
			if(swap == false){break;}
		}
	}
	public static void main(String[] args) {
		int[] data = new int[]{6,2,1,4,3,5};
		sort(data);
		System.out.println(Arrays.toString(data));
	}
	
}
