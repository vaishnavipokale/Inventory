

package com.example.InventoryManagement.service;

import java.util.List;

import com.example.InventoryManagement.entity.Product;

public interface ProductService {
	
	Product saveProduct(Product product);
	List<Product> getAllProduct();
	Product getProductById(long id);
	Product updateProduct(Product product, long id);
	//void deleteProduct(long id);
	void deleteProductById(long id);
	
	
}
