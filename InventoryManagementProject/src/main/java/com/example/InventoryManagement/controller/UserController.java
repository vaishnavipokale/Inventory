
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
import org.springframework.web.bind.annotation.RestController;

import com.example.InventoryManagement.entity.User;
import com.example.InventoryManagement.service.UserService;
@RestController
@RequestMapping("/api/inventoryuser")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
    @GetMapping
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	@GetMapping("{id}")
	public ResponseEntity<User>getUserById(@PathVariable("id") long id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		
		return new ResponseEntity<User>(userService.updateUser(user, id),HttpStatus.OK);
		
	}
	/*@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
		userService.deleteUser(id);
		return new ResponseEntity<String> ("User Record Is Deleted", HttpStatus.OK);
	}*/
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