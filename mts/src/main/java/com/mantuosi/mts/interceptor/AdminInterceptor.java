package com.mantuosi.mts.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mantuosi.mts.common.utils.RequestUtils;
import com.mantuosi.mts.service.user.UserService;

public class AdminInterceptor implements HandlerInterceptor {

	@Autowired
	private UserService userService;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String ipaddr = RequestUtils.getIpAddrFinal(request);
		String csessionid = RequestUtils.getCSESSIONID(request, response);
		boolean islogin = userService.isLogin(ipaddr, csessionid);
		if (islogin == true) {
			return true;
		} else {
			response.sendRedirect("/login");
			return false;
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
}
