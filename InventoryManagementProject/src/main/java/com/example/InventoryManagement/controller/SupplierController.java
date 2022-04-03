package com.example.InventoryManagement.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InventoryManagement.entity.Supplier;
import com.example.InventoryManagement.service.SupplierService;
@RestController
//@Controller
@RequestMapping("/api/inventorysupplier")
public class SupplierController {
	private SupplierService supplierService;

	public SupplierController(SupplierService supplierService) {
		super();
		this.supplierService = supplierService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier) {
		return new ResponseEntity<Supplier>(supplierService.saveSupplier(supplier),HttpStatus.CREATED);
	}
	

	@GetMapping("get/all")
	public List<Supplier> getAllSupplier()
	{
		return supplierService.getAllSupplier();
	}
	@GetMapping("{id}")
	public ResponseEntity<Supplier>getSupplierById(@PathVariable("id") long id) {
		return new ResponseEntity<Supplier>(supplierService.getSupplierById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable("id") long id, @RequestBody Supplier supplier){
		
		return new ResponseEntity<Supplier>(supplierService.updateSupplier(supplier, id),HttpStatus.OK);
		
	}
	/*@GetMapping("/supplierByFirstName/{firstName}")
	public List<Supplier> getSupplierByFirstName(@PathVariable("firstName") String firstName){
		return supplierService.getSupplierByFirstName(firstName);
	}
	*/
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteSupplier(@PathVariable("id") long id){
		supplierService.deleteSupplier(id);
		return new ResponseEntity<String> ("Supplier Record Is Deleted", HttpStatus.OK);
	}
	/*@GetMapping("/")
	String index()
	{
return "index";		
	}*/
}
