package com.example.model;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@PrimaryKey
	private int id;

	@NotEmpty(message = "User name is not entered, Enter user name")
	private String username;

	@NotEmpty(message = " Password is not entered, Enter Password")
	private String password;

	@NotEmpty(message = " role is not entered, Enter role name")
	private String roles;

}
