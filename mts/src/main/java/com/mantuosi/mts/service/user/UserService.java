package com.mantuosi.mts.service.user;

import com.mantuosi.mts.core.bean.user.User;

public interface UserService {

	User selectByPrimaryKey(Integer id);

	void insertUser(User user);

	boolean isLogin(String ipaddr);

	boolean loginToRedis(String ipaddr, String username, String userpwd);

	void logoutFromRedis(String ipaddr);
}
