package com.example.InventoryManagement.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InventoryManagement.entity.Product;
import com.example.InventoryManagement.service.ProductService;
@RestController
@RequestMapping("/api/inventoryproduct")
public class ProductController {
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.saveProduct(product),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();
	}
	@GetMapping("{id}")
	public ResponseEntity<Product>getProductById(@PathVariable("id") long id) {
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product){
		
		return new ResponseEntity<Product>(productService.updateProduct(product, id),HttpStatus.OK);
		
	}
	
}
