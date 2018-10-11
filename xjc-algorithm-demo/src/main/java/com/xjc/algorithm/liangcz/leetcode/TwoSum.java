package com.xjc.algorithm.liangcz.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * @author liangcz
 *
 */
public class TwoSum {
	 /**
	  * 暴力法
	  * 时间复杂度O(n^2)
	  * 空间复杂度O(1)
	  * @param nums
	  * @param target
	  * @return
	  */
	 public int[] twoSum(int[] nums, int target) {
        int a,b;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length && j != i; j++) {
				a = nums[i];
				b = nums[j];
				if(i != j && a + b == target){
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
        throw new RuntimeException("无法找到满足条件的值");
    }
	 /**
	  * 方法二：两遍哈希表
	  * 时间复杂度：O(n)
	  * 空间复杂度：O(n)
	  * @param nums
	  * @param target
	  * @return
	  */
	 public int[] twoSum1(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	 /**
	  * 方法三：一遍哈希表
	  * 时间复杂度：O(n) 空间复杂度：O(n)
	  * @param nums
	  * @param target
	  * @return
	  */
	 public int[] twoSum2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
}
