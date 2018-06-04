package com.mantuosi.mts.serviceImpl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantuosi.mts.common.utils.StrEncrypt;
import com.mantuosi.mts.core.bean.user.User;
import com.mantuosi.mts.core.bean.user.UserQuery;
import com.mantuosi.mts.core.bean.user.UserQuery.Criteria;
import com.mantuosi.mts.core.dao.user.UserDao;
import com.mantuosi.mts.service.user.UserService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private JedisPool pool;
	private Integer exp = 30;

	public User selectByPrimaryKey(Integer id) {
		return userDao.selectByPrimaryKey(id);
	}

	public void insertUser(User user) {
		userDao.insertSelective(user);
	}

	public boolean loginToRedis(String ipaddr, String username, String userpwd) {
		String psw = StrEncrypt.encodePassowrd(userpwd);
		UserQuery userQuery = new UserQuery();
		Criteria criteria = userQuery.createCriteria();
		StringBuilder params = new StringBuilder();
		criteria.andUsernameEqualTo(username);
		params.append("username=").append(username);
		params.append("psw=").append(psw);
		criteria.andPswEqualTo(psw);
		List<User> user = userDao.selectByExample(userQuery);
		if (user.size() < 1) {
			return false;
		} else {
			Jedis jedis = null;
			try {
				jedis = pool.getResource();
				String key = "mtsBlogAdmin_" + ipaddr;
				jedis.set(key, "1");
				jedis.expire(key, 60 * exp);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (jedis != null) {
					jedis.close();
				}
			}
		}
		return false;
	}

	public void logoutFromRedis(String ipaddr) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String key = "mtsBlogAdmin_" + ipaddr;
			jedis.del(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public boolean isLogin(String ipaddr) {
		Jedis jedis = null;
		boolean mts = false;
		try {
			jedis = pool.getResource();
			String key = "mtsBlogAdmin_" + ipaddr;
			mts = jedis.exists(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return mts;
	}
}
