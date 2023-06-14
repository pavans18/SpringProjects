package com.example.model;

import java.util.Set;

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

	
	private Long id;

	@NotEmpty(message = "User name is not entered, Enter user name")
	@PrimaryKey
	private String username;

	@NotEmpty(message = " Password is not entered, Enter Password")
	private String password;

	@NotEmpty(message = " role is not entered, Enter role name")
	private String roles;

}
