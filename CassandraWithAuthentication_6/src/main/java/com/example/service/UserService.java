package com.example.service;

import java.util.List;

import com.example.model.User;



public interface UserService {
	
	public List<User> getAllusers();

	public User getUserByuserName(String name);
	
	public String addUser(User user);

}