package com.demo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.security.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
