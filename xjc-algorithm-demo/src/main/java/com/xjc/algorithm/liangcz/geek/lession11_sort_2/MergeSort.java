package com.xjc.algorithm.liangcz.geek.lession11_sort_2;

import java.util.Arrays;

/**
 * 归并排序
 * @author liangcz
 *
 */
public class MergeSort {
	/**
	 * 归并拍下一
	 * merge_sort(p...r) = merge(merge_sort(p...q),merge_sort(q+1...r))
	 * 终止条件：p>=r
	 * 时间复杂度O(n)
	 * @param data
	 * @param n
	 */
	public static void sort(int[] data,int n){
		mergeSort(data, 0, n-1);
	}
	public static void mergeSort(int[] data,int p,int r){
		if(p >= r){
			return;
		}
		int q = (p + r) / 2; // 区p和r的中间位置q
		// 分治递归
		mergeSort(data, p, q);
		mergeSort(data, q + 1, r);
		// 合并
		merge(data, p, q, r);
	}
	/**
	 * 合并
	 * @param data 数组
	 * @param p 开始
	 * @param q 中间
	 * @param r 尾巴
	 */
	public static void merge(int[] data,int p,int q,int r){
		int i = p; 
		int j = q + 1;
		int k = 0;
		int[] tmp = new int[r-p+1];
		while(i <= q && j <= r){
			if(data[i] <= data[j]){
				tmp[k++] = data[i++];
			}else{
				tmp[k++] = data[j++];
			}
		}
		// 对有剩余数据的数组进行复制
		int start = i;
		int end = q;
		if(j <= r){
			start = j;
			end = r;
		}
		// 对剩余数组拷贝
		while(start <= end){
			tmp[k++] = data[start++];
		}
		// 将tmp 拷贝回原数组
		for (int l = 0; l < r-p+1; l++) {
			data[p + l] = tmp[l];
		}
		System.out.println(Arrays.toString(data));
		System.out.println("--------------");
	}
	public static void main(String[] args) {
		int[] data = new int[]{6,2,1,4,3,5,9,7,8,10,-1,87};
		sort(data,data.length);
		System.out.println(Arrays.toString(data));
	}
}
