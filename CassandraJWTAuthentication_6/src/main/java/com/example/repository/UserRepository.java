package com.example.repository;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepository extends CassandraRepository<User, Integer>{
	
	@Query("select * from user where username=?1")
	Optional<User> findByUsername(String userName);
	
	Boolean existsByUsername(String username);
	
	//User findByUsername(String username);
}
