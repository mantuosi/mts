package com.mantuosi.mts.service.user;

import com.mantuosi.mts.core.bean.user.User;

public interface UserService {

	User selectByPrimaryKey(Integer id);

	void insertUser(User user);

	boolean isLogin(String ipaddr, String csessionid);

	String getLoginAdmin(String ipaddr, String csessionid);

	void loginToRedis(String ipaddr, String username, String csessionid);

	void logoutFromRedis(String ipaddr, String csessionid);

	User selectByUsername(String username);
}
