package com.demo.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.security.entity.User;
import com.demo.security.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userRepo.findAll();
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		System.out.println(user.toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
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
