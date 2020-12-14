package com.mercury.FinalProjectDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mercury.FinalProjectDemo.beans.Order;
import com.mercury.FinalProjectDemo.beans.User;
import com.mercury.FinalProjectDemo.beans.UserInfo;
import com.mercury.FinalProjectDemo.daos.UserDao;
import com.mercury.FinalProjectDemo.daos.UserInfoDao;
import com.mercury.FinalProjectDemo.http.Response;
import com.mercury.FinalProjectDemo.http.UserInfoResponse;

@Service
public class UserInfoService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserInfoDao userInfoDao;
	
	public List<UserInfo> getAll() {
		return userInfoDao.findAll();
	}
	
	public Response addUserInfo(UserInfo userInfo) {
		userInfoDao.save(userInfo);
		return new Response(true);
	}
	
	public Response updateUserInfo(UserInfo userInfo) {
		try {
			UserInfo ud = userInfoDao.findById(userInfo.getId()).get();
			userInfo.setId(ud.getId());
			userInfoDao.save(userInfo);
			return new Response(true,200,"successfully get user info", userInfo);
		} catch (Exception e) {
			return new Response(false,200,"");
		}
		
	}

	public UserInfo getUserDetailById(int userId) {
		return userInfoDao.findUserInfoByUserId(userId);
	}

}
