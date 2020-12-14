package com.mercury.FinalProjectDemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mercury.FinalProjectDemo.beans.Profile;
import com.mercury.FinalProjectDemo.beans.User;
import com.mercury.FinalProjectDemo.daos.ProfileDao;
import com.mercury.FinalProjectDemo.daos.UserDao;
import com.mercury.FinalProjectDemo.http.Response;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProfileDao profileDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<User> getAll() {
		return userDao.findAll();
	}
	
	public Response register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(profileDao.findById(2).get());
		user.setProfiles(profiles);
		userDao.save(user);
		return new Response(true, 200, "register success!");
	}

	public User getById(Integer id) {
		return userDao.findById(id).get();
	}
}
