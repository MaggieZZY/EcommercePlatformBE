package com.mercury.FinalProjectDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.FinalProjectDemo.beans.User;
import com.mercury.FinalProjectDemo.services.UserService;
import com.mercury.FinalProjectDemo.http.Response;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/id/{id}")
	public User getById(Integer id) {
		return userService.getById(id);
	}
	
	@PreAuthorize("permitAll()")
	@PostMapping
	public Response addUser(@RequestBody User user) {
		return userService.register(user);
	}
	
	
}
