package com.mantuosi.mts.common.utils;

import java.util.Random;
import java.util.UUID;

public class RandomStr {
	public static String getRandomString() {
		String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String getRandomNumber(int z) {
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < z; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String get64UUID() {
		String base = UUID.randomUUID().toString() + UUID.randomUUID().toString();
		return base.replace("-", "");
	}

	public static String get32UUID() {
		String base = UUID.randomUUID().toString();
		return base.replace("-", "");

	}
}
