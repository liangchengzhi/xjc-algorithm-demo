package com.xjc.algorithm.liangcz.geek.lession14_binarySearch;
/**
 * 二分查找法
 * @author liangcz
 *
 */
public class BinarySearch {
	/**
	 * 二分查找数据 
	 * @param data 一个排好序的数组
	 * @param n
	 * @param value
	 * @return
	 */
	public static int saerch(int[] data,int n,int value){
		int begin  = 0;
		int mid = 0;
		int end = n - 1;
		
		while(begin <= end){
			mid = (begin + end) / 2;
			if(data[mid] == value){
				return mid;
			}else if(data[mid] < value){
				begin = mid + 1;
			}else if(data[mid] > value){
				end = mid -1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] data = {0,1,2,7,10,11,56,89,100,120,1024};
		int value = 9;
		int index = saerch(data,  data.length, value);
		System.out.println(index);
	}

}
