package com.xjc.algorithm.liangcz.geek.lession11_sort_2;

import java.util.Arrays;

/**
 * 快排
 * @author liangcz
 *
 */
public class QuickSort {
	/**
	 * 快排
	 * quickSort(p...r) = quickSort(p...q-1) + quickSort(q+1...r)
	 * 终止条件：p>=r
	 * 时间复杂度O(nlogn)
	 * @param data
	 * @param n
	 */
	public static void sort(int[] data,int n){
		quickSort(data, 0, n-1);
	}
	public static void quickSort(int[] data,int p,int r){
		if(p >= r){
			return;
		}
		// 合并
		int q = partition(data, p,r);
		// 分治递归
		quickSort(data, p, q - 1);
		quickSort(data, q + 1, r);
		
	}
	/**
	 * 分区排序
	 * @param data 数组
	 * @param p 开始值
	 * @param r 最大值
	 * @return 分区中间坐标位置
	 */
	public static int partition(int[] data,int p,int r){
		int pivot = data[r];
		int i = p;
		for (int j = p;  j< r; j++) {
			if(data[j] < data[r]){
				int tmp = data[j];
				data[j] = data[i];
				data[i] = tmp;
				i++;
			}
		}
		data[r] = data[i];
		data[i] = pivot;
		return i;
	}
	public static void main(String[] args) {
		int[] data = new int[]{6,2,1,4,3,5,9,7,8,10,-1,87};
		sort(data,data.length);
		System.out.println(Arrays.toString(data));
	}
}
