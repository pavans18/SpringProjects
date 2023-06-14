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
public class Customer {
	
	@PrimaryKey
	private int id;
	
	@NotEmpty(message = "Customer name is not entered, Enter customer name")
	private String name;
	
	@NotEmpty(message = "Customer email is not entered, Enter customer name")
	private String email;
	
	@NotEmpty(message = "Customer gender is not entered, Enter customer gender")
	private String gender;
	
	@NotEmpty(message = "customer nationality is not entered, Enter customer nationality")
	private String nationality;

}
