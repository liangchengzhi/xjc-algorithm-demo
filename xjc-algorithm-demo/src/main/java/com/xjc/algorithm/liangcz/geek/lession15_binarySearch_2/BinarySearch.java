package com.xjc.algorithm.liangcz.geek.lession15_binarySearch_2;
/**
 * 二分查找法
 * @author liangcz
 *
 */
public class BinarySearch {
	/**
	 * 二分查找数据，查找第一个出现等于给定值的数据
	 * @param data 一个排好序的数组
	 * @param n
	 * @param value
	 * @return
	 */
	public static int bsearch_first(int[] data,int n,int value){
		int low  = 0;
		int mid = 0;
		int hign = n - 1;
		while(low <= hign){
			mid = low +  ((hign - low) >> 1);
			if(data[mid] >= value){
				hign = mid -1;
			}else{ 
				low = mid + 1;
			}
		}
		if(low < n && data[low] == value){
			return low;
		}else{
			return -1;
		} 
	}
	/**
	 * 二分查找数据，查找最后一个出现等于给定值的数据
	 * @param data 一个排好序的数组
	 * @param n
	 * @param value
	 * @return
	 */
	public static int bsearch_last(int[] data,int n,int value){
		int low  = 0;
		int mid = 0;
		int hign = n - 1;
		while(low <= hign){
			mid = low +  ((hign - low) >> 1);
			if(data[mid] > value){
				hign = mid -1;
			}else{ 
				low = mid + 1;
			}
		}
		if(hign >= 0 && data[hign] == value){
			return hign;
		}else{
			return -1;
		} 
	}
	/**
	 * 二分查找数据，查找第一个出现大于等于给定值的数据
	 * @param data 一个排好序的数组
	 * @param n
	 * @param value
	 * @return
	 */
	public static int bsearch_first_bigOrEqualsThan(int[] data,int n,int value){
		int low  = 0;
		int mid = 0;
		int hign = n - 1;
		while(low <= hign){
			mid = low +  ((hign - low) >> 1);
			if(data[mid] >= value){
				hign = mid -1;
			}else{ 
				low = mid + 1;
			}
		}
		if(low < n && data[low] >= value){
			return low;
		}else{
			return -1;
		} 
	}
	/**
	 * 二分查找数据，查找最后一个出现小于等于给定值的数据
	 * @param data 一个排好序的数组
	 * @param n
	 * @param value
	 * @return
	 */
	public static int bsearch_last_lessOrEqualsThan(int[] data,int n,int value){
		int low  = 0;
		int mid = 0;
		int hign = n - 1;
		while(low <= hign){
			mid = low +  ((hign - low) >> 1);
			if(data[mid] > value){
				hign = mid -1;
			}else{ 
				low = mid + 1;
			}
		}
		if(hign >= 0 && data[hign] <= value){
			return hign;
		}else{
			return -1;
		} 
	}
	public static void main(String[] args) {
		int[] data = {0,1,2,7,10,11,56,56,56,56,89,100,120,1024};
		int value = 56;
		int index = -1;
		// int index = bsearch_first(data,  data.length, value);
		// System.out.println(index);
		// index = bsearch_last(data,  data.length, value);
		// System.out.println(index);
		// index = bsearch_first_bigOrEqualsThan(data,  data.length, value);
		// System.out.println(index);
		
		index = bsearch_last_lessOrEqualsThan(data,  data.length, value);
		System.out.println(index);
		
	}

}
