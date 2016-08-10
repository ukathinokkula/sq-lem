package com.lem.service.manager.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lem.service.dao.UserDAO;
import com.lem.service.manager.UserManager;
import com.lem.service.model.User;

@Service
public class UserManagerImpl implements UserManager {

	@Autowired
	protected UserDAO userDao;

	public List<User> loadUserDetails() {
		List<User> userList = userDao.loadUserDetails();
		return userList;
	}

	@Override
	public boolean verifyUsername(String username) {
		return userDao.verifyUsername(username);
	}

	@Override
	public boolean savePassword(User user) {
		user.setPassword(new Md5PasswordEncoder().encodePassword(
				user.getPassword(), null));
		return userDao.savePassword(user);
	}

	@Override
	public void registerUser(User user) {
		try {
			user.setCreatedBy("Default User");
			user.setRoleName("member");
			user.setPassword(new Md5PasswordEncoder().encodePassword(
					user.getPassword(), null));
			userDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			// return;
		}
	}

	@Override
	public User findUserByName(String userName) {
		User user = userDao.findByName(userName);
		return user;
	}


	@Override
	public void updateLastLoginDateByName(String userName) {
		userDao.updateLastLoginDateByName(userName);

	}

	@Override
	public void updateUser(User user) {
		try {
			// user.setPassword(new
			// Md5PasswordEncoder().encodePassword(user.getPassword(),null));
			userDao.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			// return;
		}
	}

	@Override
	public List<User> loadMebersBySearchCriteria(String userName,
			Date fromDate, Date toDate) {
		return userDao.loadMebersBySearchCriteria(userName, fromDate, toDate);
	}

}
