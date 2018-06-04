package com.mantuosi.mts.common.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomNum {
	public static Integer[] randomArray(Integer min, Integer max, Integer n) {
		Integer len = max - min + 1;

		if (max < min || n > len) {
			return null;
		}

		// 初始化给定范围的待选数组
		Integer[] source = new Integer[len];
		for (Integer i = min; i < min + len; i++) {
			source[i - min] = i;
		}

		Integer[] result = new Integer[n];
		Random rd = new Random();
		Integer index = 0;
		for (Integer i = 0; i < result.length; i++) {
			// 待选数组0到(len-2)随机一个下标
			index = Math.abs(rd.nextInt() % len--);
			// 将随机到的数放入结果集
			result[i] = source[index];
			// 将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
			source[index] = source[len];
		}
		return result;
	}

	public static Integer[] concat(Integer[] a, Integer[] b) {
		Integer[] c = new Integer[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}

	public static Integer[] randomArray(Integer[] xh) {
		List<Integer> list = Arrays.asList(xh);
		Collections.shuffle(list);
		xh = (Integer[]) list.toArray(new Integer[list.size()]);
		return xh;
	}
}
