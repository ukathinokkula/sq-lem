package com.lem.service.dao;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lem.service.model.User;

public interface UserDAO {

	public User findByName(String username) throws UsernameNotFoundException;

	public void addUser(User user);

	public void updateLastLoginDateByName(String userName);

	public void updateUser(User user);

	public boolean verifyUsername(String username);

	public boolean savePassword(User user);

	public List<User> loadUserDetails();

	public List<User> loadMebersBySearchCriteria(String userName,
			Date fromDate, Date toDate);
}
