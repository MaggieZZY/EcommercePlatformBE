package com.mercury.FinalProjectDemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mercury.FinalProjectDemo.beans.User;
import com.mercury.FinalProjectDemo.daos.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired 
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("user not found!");
		}
		return user;
	}

}
