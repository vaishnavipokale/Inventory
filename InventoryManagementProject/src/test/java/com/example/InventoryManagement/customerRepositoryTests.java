package com.example.InventoryManagement;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.InventoryManagement.entity.Customer;
import com.example.InventoryManagement.repository.CustomerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class customerRepositoryTests {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	@Rollback(false)

    public void saveCustomerTest() {
    	Customer customer = customerRepository.save(new Customer("john","deo","john@gmail.com","9898989898"));
    	
    		Assertions.assertThat(customer.getId()).isGreaterThan(0);
    	
    }
	
	@Test
	public void getCustomerTest() {
		Customer customer = customerRepository.findById(9L).get();
		Assertions.assertThat(customer.getId()).isEqualTo(9L);

	}
	
	@Test
	public void getCustomerListTest() {
		List<Customer> customers = customerRepository.findAll();
		Assertions.assertThat(customers.size()).isGreaterThan(0);

	}
	
	@Test
	public void updateCustomerTest() {
		Customer customer = customerRepository.findById(9L).get();
		customer.setEmail("deo@gmail.com");
		Customer updated = customerRepository.save(customer); 
		Assertions.assertThat(customer.getEmail()).isEqualTo("deo@gmail.com");

		
	}
	
	@Test
	public void deleteCustomerTest() {
		Customer cust = customerRepository.findById(9L).get();
		customerRepository.delete(cust);
		Customer customer=null;
		Optional<Customer> cust1 = customerRepository.findByEmail("deo@gmail.com");
		if(cust1.isPresent()) {
			customer = cust1.get();
		}
		
		Assertions.assertThat(customer).isNull();
		
	}
}
