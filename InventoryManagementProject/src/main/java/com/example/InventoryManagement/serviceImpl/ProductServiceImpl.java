

package com.example.InventoryManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.InventoryManagement.entity.Product;
import com.example.InventoryManagement.exception.ResourceNotFound;
import com.example.InventoryManagement.repository.ProductRepository;
import com.example.InventoryManagement.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}


	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}


	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
		
	}


	@Override
	public Product getProductById(long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		else {
          
			throw new ResourceNotFound("Product","Id",id);
		}
		
	}


	@Override
	public Product updateProduct(Product product, long id) {
		Product pro = new Product();
	 try {
		   pro = productRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound("Product","Id",id));
	} catch (ResourceNotFound e) {
		
		e.printStackTrace();
	}
	 pro.setProductName(product.getProductName());
	 pro.setProductCategory(product.getProductCategory());
	 pro.setProductPrice(product.getProductPrice());
	 pro.setProductDesc(product.getProductDesc());
	
	 productRepository.save(pro);
	return pro;
	}


	
	@Override
	public void deleteProductById(long id) {
		productRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Product", "Id", id));
		productRepository.deleteById(id);
		
	}	

}
