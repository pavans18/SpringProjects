package com.example.service;

import java.util.List;

import com.example.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();

	public Customer saveNewCustomer(Customer product);

	public void deleteCustomerById(int id) throws Exception;

	public Customer updateCustomer(Customer product, int id) throws Exception;

	public int getNextIdForCustomer();

}
