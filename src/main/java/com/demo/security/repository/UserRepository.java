package com.demo.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.security.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public Optional<User> getByUserName(String username);

}
