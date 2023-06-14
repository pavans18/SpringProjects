package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserInfoRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserInfoRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> getAllusers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserByuserName(String name) {
			return userRepository.findByUsername(name).get();

	}

	@Override
	public String addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "User Added Successfully";
	}
	
	
}
