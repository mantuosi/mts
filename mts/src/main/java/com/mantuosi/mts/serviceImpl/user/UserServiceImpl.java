package com.mantuosi.mts.serviceImpl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public User selectByUsername(String username) {
		UserQuery userQuery = new UserQuery();
		Criteria criteria = userQuery.createCriteria();
		StringBuilder params = new StringBuilder();
		criteria.andUsernameEqualTo(username);
		params.append("username=").append(username);
		List<User> user = userDao.selectByExample(userQuery);
		if (null != user && user.size() > 0) {
			return user.get(0);
		}
		return null;
	}

	public void loginToRedis(String ipaddr, String username, String csessionid) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String key = "mtsBlogAdmin_" + ipaddr + "_" + csessionid;
			jedis.set(key, username);
			jedis.expire(key, 60 * exp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public void logoutFromRedis(String ipaddr, String csessionid) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String key = "mtsBlogAdmin_" + ipaddr + "_" + csessionid;
			jedis.del(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public boolean isLogin(String ipaddr, String csessionid) {
		Jedis jedis = null;
		boolean mts = false;
		try {
			jedis = pool.getResource();
			String key = "mtsBlogAdmin_" + ipaddr + "_" + csessionid;
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

	public String getLoginAdmin(String ipaddr, String csessionid) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String key = "mtsBlogAdmin_" + ipaddr + "_" + csessionid;
			return jedis.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return null;

	}
}
