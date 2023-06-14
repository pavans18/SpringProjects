package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Customer;
import com.example.model.User;
import com.example.repository.CustomerRepository;
import com.example.repository.UserRepository;
import com.example.service.CustomerService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private UserRepository repository;

	
	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/savecustomer")
	public String addCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) throws Exception {

		if (bindingResult.hasErrors()) {
			throw new ResourceNotFoundException(bindingResult.toString());
		}

		customerService.saveNewCustomer(customer);
		return "New Customer added Successfully";
	}

	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Integer customerId) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));
		return ResponseEntity.ok().body(customer);
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getCustomer() {
		return customerService.getAllCustomers();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("updateCustomerById/{id}")
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
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("deleteCustomerById/{id}")
	public String deleteCustomerById(@PathVariable(value = "id") Integer id) throws Exception {

		customerService.deleteCustomerById(id);
		return "Customer Deleted Successfully";
	}
	
	
	@PostMapping("auth/addUser")
	public User addNewUser(@RequestBody User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save(user);
	}

}
