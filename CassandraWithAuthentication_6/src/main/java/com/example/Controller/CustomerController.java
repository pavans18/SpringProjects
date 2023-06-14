package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.dto.AuthRequest;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Customer;
import com.example.model.User;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import com.example.service.JwtService;
import com.example.service.UserService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

	private User user;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserService userService;

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("customer/savecustomer")
	public String addCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) throws Exception {

		if (bindingResult.hasErrors()) {
			throw new ResourceNotFoundException(bindingResult.toString());
		}

		customerService.saveNewCustomer(customer);
		return "New Customer added Successfully";
	}

	@GetMapping("customer/getCustomerById/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Integer customerId) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));
		return ResponseEntity.ok().body(customer);
	}

	@GetMapping("customer/getAllCustomers")
	public List<Customer> getCustomer() {

		return customerService.getAllCustomers();
	}

	@PutMapping("updateCustomerById/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails)
			throws Exception {

		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));

		customer.setName(customerDetails.getName());
		customer.setEmail(customerDetails.getEmail());
		customer.setGender(customerDetails.getGender());
		customer.setNationality(customerDetails.getNationality());

		final Customer updatedCustomer = customerService.updateCustomer(customer, id);
		return ResponseEntity.ok(updatedCustomer);

	}

	@DeleteMapping("deleteCustomerById/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteCustomerById(@PathVariable(value = "id") Integer id) throws Exception {

		customerService.deleteCustomerById(id);
		return "Customer Deleted Successfully";
	}

//	@PostMapping("/authenticate")
//	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//		if (authentication.isAuthenticated()) {
//			return jwtService.generateToken(authRequest.getUsername());
//		} else {
//			throw new UsernameNotFoundException("invalid user request !");
//		}
//
//	}
//
//	@PostMapping("auth/addUser")
//	public String addNewUser(@RequestBody User user) {
//		return userService.addUser(user);
//	}

}
