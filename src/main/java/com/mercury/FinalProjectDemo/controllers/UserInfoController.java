package com.mercury.FinalProjectDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.FinalProjectDemo.beans.Order;
import com.mercury.FinalProjectDemo.beans.UserInfo;
import com.mercury.FinalProjectDemo.http.Response;
import com.mercury.FinalProjectDemo.services.UserInfoService;

@RestController
@RequestMapping("/user-details")
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;
	
	@GetMapping
	public List<UserInfo> getAll() {
		return userInfoService.getAll();
	}
	
	@GetMapping("/{userId}")
	public UserInfo getUserDetailById(@PathVariable int userId) {
		return userInfoService.getUserDetailById(userId);
	}

	@PostMapping
	public Response postUserDetails(@RequestBody UserInfo userInfo, Authentication authentication) {
		return userInfoService.addUserInfo(userInfo);
	}
	
	@PutMapping
	public Response putUserInfos(@RequestBody UserInfo userInfo) {
		return userInfoService.updateUserInfo(userInfo);
	}
	
}
