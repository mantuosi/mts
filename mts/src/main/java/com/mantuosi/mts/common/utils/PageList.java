package com.mantuosi.mts.common.utils;

import java.util.ArrayList;
import java.util.List;

public class PageList {

	public static List<Integer> listTotalPage(Integer a) {
		List<Integer> li = new ArrayList<Integer>();
		for (int i = 0; i < a; i++) {
			li.add(i + 1);
		}
		return li;
	}
}
