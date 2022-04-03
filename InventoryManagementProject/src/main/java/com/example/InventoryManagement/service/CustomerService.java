package com.example.InventoryManagement.service;

import java.util.List;

import com.example.InventoryManagement.entity.Customer;

public interface CustomerService {
	
	Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer getCustomerById(long id);
	Customer updateCustomer(Customer customer, long id);
	void deleteCustomer(long id);
	List<Customer> getCustomerByFirstName(String firstName);
	List<Customer> getCustomerByLastName(String lastName);
	List<Customer> getCustomerByFirstNameAndLastName(String firstName, String lastName);
}