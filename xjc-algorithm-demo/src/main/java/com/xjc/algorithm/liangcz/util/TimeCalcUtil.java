package com.xjc.algorithm.liangcz.util;
/**
 * 时间计算工具类
 * @author liangcz
 *
 */
public class TimeCalcUtil {
	private static long timeBeinMil = -1l;
	public static void start(){
		timeBeinMil = System.currentTimeMillis();
		System.out.println("---------------begin calc");
	}
	public static void end(){
		if(timeBeinMil == -1l){
			return;
		}
		System.out.println("---------------end calc cost:" + (System.currentTimeMillis() - timeBeinMil) + "(ms)");
		timeBeinMil = -1;
	}
}
