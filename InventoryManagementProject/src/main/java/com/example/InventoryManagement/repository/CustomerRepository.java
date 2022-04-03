package com.example.InventoryManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.InventoryManagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

	List<Customer> findCustomerByFirstName(String firstName);
	@Query("select e from Customer e where e.firstName=:name")
	List<Customer>findCustomerByfirstName(@Param("name") String firstName);
	
	
	void deleteCustomerById(long id);
	Optional<Customer> findByEmail(String string);

	//List<User> findByLastName(String lastName);

	//List<User> findByFirstNameAndLastName(String firstName, String lastName);
	//@Query("select u from User where id IN(:ids)")
    //List<User>findUserByIds(@Param("ids")List<Long> idList);	

}