package com.demo.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.security.entity.User;
import com.demo.security.repository.UserRepository;

public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userRepo.findAll();
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(User user)
	{
		User u = userRepo.save(user);
		if(u!=null)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(u);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
		}
	}
}
