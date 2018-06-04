package com.mantuosi.mts.serviceImpl.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantuosi.mts.core.bean.users.Users;
import com.mantuosi.mts.core.dao.users.UsersDao;
import com.mantuosi.mts.service.users.UsersService;

@Service("UsersService")
public class UsersImpl implements UsersService {
	@Autowired
	private UsersDao usersDao;

	public Users selectUsersById(String uid) {
		return usersDao.selectByPrimaryKey(uid);
	}
}
