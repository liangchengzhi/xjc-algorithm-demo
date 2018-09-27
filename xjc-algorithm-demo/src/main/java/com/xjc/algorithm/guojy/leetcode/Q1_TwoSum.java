package com.xjc.algorithm.guojy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * @author  Administrator
 * @createDate 2018年9月27日 下午8:38:22
 * 
 */
public class Q1_TwoSum {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }
    
    /**
     * 方法一：暴力法
     * 遍历每个元素 xx，并查找是否存在一个值与 target - xtarget−x 相等的目标元素。
     *  时间复杂度O(n*n)
     *  空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    // a = { i, j };
                    a[0] = i;
                    a[1] = j;
                    return a;
                } else {
                    continue;
                }
            }
        }
	return null;
    }
    
    /**
     * 方法二：两遍哈希表
     * 牺牲空间换取时间
     *  时间复杂度O(n)
     *  空间复杂度O(n)
     * 
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
     * 一遍哈希表
     * 在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
     * 如果它存在，那我们已经找到了对应解，并立即将其返回。
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
