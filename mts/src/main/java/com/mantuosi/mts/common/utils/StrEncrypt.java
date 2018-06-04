package com.mantuosi.mts.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class StrEncrypt {
	// 加密
	public static String encodePassowrd(String password) {
		// 加盐,加前后缀，分割中间也能加
		password = "ASD" + password.substring(0, 3) + "19931108" + password.substring(3) + 2018;

		// jdk md5
		String algorithm = "MD5";
		char[] encodeHex = null;
		try {
			MessageDigest instance = MessageDigest.getInstance(algorithm);
			// MD5之后密文
			byte[] digest = instance.digest(password.getBytes());
			// 十六进制加密
			encodeHex = Hex.encodeHex(digest);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回时 再加个前缀PSWIsAJoke
		return "Psw_" + new String(encodeHex);
	}

	// 加密
	public static String encodeUsername(String username) {
		// 加盐,加前后缀，分割中间也能加
		username = "ASD" + username.substring(0, 3) + "19931108" + username.substring(3) + 2018;

		// jdk md5
		String algorithm = "MD5";
		char[] encodeHex = null;
		try {
			MessageDigest instance = MessageDigest.getInstance(algorithm);
			// MD5之后密文
			byte[] digest = instance.digest(username.getBytes());
			// 十六进制加密
			encodeHex = Hex.encodeHex(digest);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回时 再加个前缀PSWIsAJoke
		return "User_" + new String(encodeHex);
	}

}
