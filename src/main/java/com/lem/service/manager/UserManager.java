package com.lem.service.manager;

import java.util.Date;
import java.util.List;

import com.lem.service.model.User;

public interface UserManager {

	public List<User> loadUserDetails();

	public boolean verifyUsername(String username);

	public boolean savePassword(User user);

	public void registerUser(User user);

	public User findUserByName(String userName);

	public void updateLastLoginDateByName(String userName);

	public void updateUser(User user);

	public List<User> loadMebersBySearchCriteria(String userName,
			Date fromDate, Date toDate);

}
