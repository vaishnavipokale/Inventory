package com.example.InventoryManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.InventoryManagement.entity.Customer;
import com.example.InventoryManagement.entity.Invoice;
import com.example.InventoryManagement.entity.Product;
import com.example.InventoryManagement.exception.ResourceNotFound;
import com.example.InventoryManagement.repository.CustomerRepository;
import com.example.InventoryManagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;
	
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}


	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
		
	}


	@Override
	public Customer getCustomerById(long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}
		else {
          
			throw new ResourceNotFound("Customer","Id",id);
		}
		
	}


	@Override
	public Customer updateCustomer(Customer customer, long id) {
		Customer cus = new Customer();
	 try {
		   cus = customerRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound("Customer","Id",id));
	} catch (ResourceNotFound e) {
		
		e.printStackTrace();
	}
	 cus.setFirstName(customer.getFirstName());
	 cus.setLastName(customer.getLastName());
	 cus.setEmail(customer.getEmail());
	 cus.setContactNo(customer.getContactNo());
	 cus.setAddress(customer.getAddress());
	 cus.setPassword(customer.getPassword());
	 customerRepository.save(cus);
	return cus;
	}
	@Override
	public void deleteCustomer(long id) {

		Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Customer", "Id", id));
		List<Product> products = customer.getProduct();
		List<Invoice> invoices = customer.getInvoice();
		products.clear();
		invoices.clear();
		customer.setProduct(products);
		customer.setInvoice(invoices);
		customerRepository.save(customer);
		customerRepository.deleteById(id);
		
	}
	/*@Override
	public List<User> getUserByFirstName(String firstName) {
		return userRepository.findUserByFirstName(firstName);
				
	}
	@Override
	public List<User> getUserByLastName(String lastName) {
		return userRepository.findByLastName(lastName);
	}
	@Override
	public List<User> getUserByFirstNameAndLastName(String firstName, String lastName) {
		return userRepository.findByFirstNameAndLastName(firstName, lastName);
	}*/


	@Override
	public List<Customer> getCustomerByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Customer> getCustomerByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Customer> getCustomerByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


	

}