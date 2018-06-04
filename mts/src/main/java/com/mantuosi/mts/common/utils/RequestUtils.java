package com.mantuosi.mts.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestUtils {

	public static String getIpAddrFinal(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	public static String getCSESSIONID(HttpServletRequest request, HttpServletResponse response) {
		// 1：获取Cookie
		Cookie[] cookies = request.getCookies();

		// jsession
		// 购物车
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				// 2;从Cookie中获取CSESSIONID
				if (cookie.getName().equals("CSESSIONID")) {
					// 3;如果有 直接使用
					return cookie.getValue();
				}
			}
		}
		// 4;判断如果 没有 创建一个CSESSIONID 保存CSESSIONID到Cookie中 保存COokie写回浏览器
		String csessionid = UUID.randomUUID().toString().replaceAll("-", "");
		// Cookie
		Cookie cookie = new Cookie("CSESSIONID", csessionid);
		// 设置路径
		cookie.setPath("/");
		// 设置Cookie的存活时间 立即消失 0 关闭浏览器 消失-1 到时间再消失>0 前提：没有清理Cookie
		cookie.setMaxAge(-1);
		response.addCookie(cookie);

		return csessionid;
	}
}
