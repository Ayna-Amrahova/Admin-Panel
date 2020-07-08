package com.example.demo.repository;

import com.example.demo.entity.User;

public interface UserDao {
	
	public User findByName(String theUserName);

}
