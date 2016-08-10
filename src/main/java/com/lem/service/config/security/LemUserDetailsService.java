package com.lem.service.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.lem.service.dao.UserDAO;
import com.lem.service.model.User;

@Component
public class LemUserDetailsService implements UserDetailsService{

	@Autowired
	protected UserDAO loginDAOInterface;
	
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = loginDAOInterface.findByName(username);
	   if(user == null){
		   throw new UsernameNotFoundException("UserName "+username+" not found"); 
	   }
		return new SecurityUser(user);
	}

}
