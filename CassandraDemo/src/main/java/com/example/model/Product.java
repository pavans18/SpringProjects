package com.example.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@PrimaryKey
	private int id;
	
	@NotEmpty(message = "Product name is empty, Enter Product name")
	private String name;
	
	@NotNull
	private int price;
	
	@NotEmpty(message = "Product description is empty, Enter Product Description")
	private String description;

}
