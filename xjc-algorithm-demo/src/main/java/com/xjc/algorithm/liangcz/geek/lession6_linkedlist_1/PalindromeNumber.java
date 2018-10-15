package com.xjc.algorithm.liangcz.geek.lession6_linkedlist_1;

public class PalindromeNumber {
	/**
	 * 判断是否是回文串  时间复杂度O(log n)
	 * @param inNum
	 * @return
	 */
	public static boolean isPalindromeNumber(int inNum){
		if(inNum < 0){
			return false;
		}
		if(inNum >= 0 && inNum < 10){
			return true;
		}
		int chuNum = inNum / 10;
		int yuNum = inNum % 10;
		int reverseNum = yuNum; // 反转串
		while(chuNum > 0){
			reverseNum = reverseNum * 10 + chuNum % 10;
			chuNum = chuNum / 10;
			yuNum = chuNum % 10;
		}
		System.out.println("reverseNum:" + reverseNum);
		return reverseNum == inNum ? true : false;
	}
	
	
	public static void main(String[] args) {
		System.out.println(isPalindromeNumber(121));
		System.out.println(isPalindromeNumber(10032));
		System.out.println(isPalindromeNumber(51215));
		System.out.println(isPalindromeNumber(23244232));
	}
}
