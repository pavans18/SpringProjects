package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer saveNewCustomer(Customer customer) {

		int id = getNextIdForCustomer();
		customer.setId(id);
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(int id) {

		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("customer with id: " + id + " Not present"));

		customerRepository.delete(customer);

	}

	@Override
	public Customer updateCustomer(Customer customer, int id) throws Exception {

		Customer customerExisting = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("customer with id: " + id + " Not present"));

		customer.setId(id);

		return customerRepository.save(customer);
	}

	@Override
	public int getNextIdForCustomer() {

		int maxId = customerRepository.findMaxCustomrId();

		if (maxId == 0) {
			maxId = 1;
		} else {
			maxId = maxId + 1;
		}
		return maxId;
	}

}
