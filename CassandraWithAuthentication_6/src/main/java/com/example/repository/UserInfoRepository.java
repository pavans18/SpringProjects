package com.example.repository;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.model.User;

public interface UserInfoRepository extends CassandraRepository<User, Integer>{
	
	Optional<User> findByUsername(String userName);
	
	//User findByUsername(String username);
}
