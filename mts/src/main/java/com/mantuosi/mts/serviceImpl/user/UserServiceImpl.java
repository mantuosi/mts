package com.mantuosi.mts.serviceImpl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantuosi.mts.core.bean.user.User;
import com.mantuosi.mts.core.dao.user.UserDao;
import com.mantuosi.mts.service.user.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User selectByPrimaryKey(Integer id) {

		return userDao.selectByPrimaryKey(id);
	}

	public void insertUser(User user) {

		userDao.insertSelective(user);
	}
}
