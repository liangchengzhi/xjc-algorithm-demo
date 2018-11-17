package com.xjc.algorithm.liangcz.geek.lession05_array;
/**
 *
 * @author liangcz
 * @Date   2018年10月10日 上午10:28:25
 * @version 1.0
 */
public class Array {
	/**
	 * 数据
	 */
	private int[] data;
	/**
	 * 数组长度
	 */
	private int n; 
	/**
	 * 数组元素的个数
	 */
	private int count;
	/**
	 * 初始化数组
	 * @param capacity
	 */
	public Array(int capacity){
		this.n = capacity;
		this.data = new int[]{0,1,2,3,4,5};
		this.count = capacity;
	}
	/**
	 * 根据索引，查找元素并返回
	 * @author liangcz
	 * @date   2018年10月10日 上午10:42:56
	 * @return int
	 */
	public int find(int index){
		if(index < 0 || index >= count){
			throw new RuntimeException("数组下标不合法");
		}
		return data[index];
	}
	/**
	 * 删除索引元素
	 * 平均时间复杂度O(n),最小时间复杂度O(1),最大O(n)
	 * @author liangcz
	 * @date   2018年10月10日 上午10:43:45
	 * @return boolean
	 */
	public boolean delete(int index){
		if(index < 0 || index >= count){
			throw new RuntimeException("数组下标不合法");
		}
		// 删除的位置开始，向前挪动一位
		for (int i = index+1; i < count; i++) {
			data[i] = data[i+1];
		}
		
		// 搬运数组 ，这段代码可以不要
		/*int[] new_arry = new int[count -1];
		for (int i = 0; i < new_arry.length; i++) {
			new_arry[i] = data[i];
		}
		data = new_arry;*/
		return true;
	}
	/**
	 * 插入元素
	 * 时间复杂度(O(n))
	 * @author liangcz
	 * @date   2018年10月10日 上午10:50:23
	 * @return boolean
	 */
	public boolean insert(int index,int v){
		if(index < 0 || index >= count){
			throw new RuntimeException("数组下标不合法");
		}
		int[] newArry = new int[count + 1];
		for (int i = 0; i < index-1; i++) {
			newArry[i] = data[i];
		}
		newArry[index] = v;
		for (int i = index; i < count; i++) {
			newArry[i+1] = data[i];
		}
		data = newArry;
		count = newArry.length;
		return true;
	}
	/**
	 * 遍历
	 * @author liangcz
	 * @date   2018年10月10日 上午10:58:11
	 * @return void
	 */
	public void listAll(){
		for (int i = 0; i < count; i++) {
			System.out.println(data[i]);
		}
	}
}
