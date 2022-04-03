package com.example.InventoryManagement.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.InventoryManagement.entity.Customer;
import com.example.InventoryManagement.service.CustomerService;
@RestController
@RequestMapping("/api/inventorycustomer")
public class CustomerController {
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
	}
	
    @GetMapping
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomer();
	}
	@GetMapping("{id}")
	public ResponseEntity<Customer>getCustomerById(@PathVariable("id") long id) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){
		
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id),HttpStatus.OK);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<String> ("Customer Record Is Deleted", HttpStatus.OK);
	}
	/*@GetMapping("/userByFirstName/{firstName}")
	public List<User> getUserByFirstName(@PathVariable("firstName") String firstName){
		return userService.getUserByFirstName(firstName);
	}
	@GetMapping("/userByLastName/{lastName}")
	public List<User> getUserByLastName(@PathVariable("lastName") String lastName){
		return userService.getUserByLastName(lastName);
	}
	
	
	@GetMapping("/userByFirstNameAndLastName")//using by JPQL
	public List<User> getUserByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
		return userService.getUserByFirstNameAndLastName(firstName, lastName);
	}*/
	
	
}