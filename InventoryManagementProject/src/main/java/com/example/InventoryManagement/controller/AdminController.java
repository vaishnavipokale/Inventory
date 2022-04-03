
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

import com.example.InventoryManagement.entity.Admin;
import com.example.InventoryManagement.service.AdminService;
@RestController
@RequestMapping("/api/inventoryadmin")
public class AdminController {
	private AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@PostMapping
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Admin> getAllAdmin()
	{
		return adminService.getAllAdmin();
	}
	@GetMapping("{id}")
	public ResponseEntity<Admin>getAdminById(@PathVariable("id") long id) {
		return new ResponseEntity<Admin>(adminService.getAdminById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") long id, @RequestBody Admin admin){
		
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, id),HttpStatus.OK);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("id") long id){
		adminService.deleteAdmin(id);
		return new ResponseEntity<String> ("admin Record Is Deleted", HttpStatus.OK);
	}
	
}
