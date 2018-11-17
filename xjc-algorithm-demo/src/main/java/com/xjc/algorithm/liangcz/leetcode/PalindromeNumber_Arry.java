package com.xjc.algorithm.liangcz.leetcode;


/**
 * 回文字符串
 * @author liangcz
 * @Date   2018年10月11日 上午10:14:39
 * @version 1.0
 */
public class PalindromeNumber_Arry {
	/**
	 * 判断是否是回文字符串
	 * @author liangcz
	 * @date   2018年10月11日 上午10:41:25
	 * @return boolean
	 */
	public static boolean isPalindrome(int x){
		return isPalindrome(String.valueOf(x));
	}
	/**
	 * 数组实现是否是回文字符串
	 * 时间复杂度 O(n)
	 * 空间复杂度 O(1)
	 * @author liangcz
	 * @date   2018年10月11日 上午10:40:46
	 * @return boolean
	 */
	public static boolean isPalindrome(String str){
		if(str == null){
			return false;
		}
		char[] chAry = str.toCharArray();
		if(chAry.length < 2){
			return true;
		}
		int mid = chAry.length / 2;
		for (int i = 0; i < mid; i++) {
			if(chAry[i] != chAry[chAry.length -1 - i]){
				return false;
			}
		}
		// 偶数多比较一次
		if(chAry.length % 2 == 0 && chAry[mid-1] != chAry[mid]){
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome(1221));
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome("上海自来水来自海上"));
	}
}
