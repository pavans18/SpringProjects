package com.example.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public interface ProductRepository extends CassandraRepository<Product, Integer> {

	@Query("select max(id) from product")
	public int findMaxProductId();

}
