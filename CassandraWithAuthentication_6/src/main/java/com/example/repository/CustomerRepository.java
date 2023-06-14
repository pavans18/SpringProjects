package com.example.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

@Repository
public interface CustomerRepository extends CassandraRepository<Customer, Integer> {

	@Query("select max(id) from customer")
	public int findMaxCustomrId();

}
