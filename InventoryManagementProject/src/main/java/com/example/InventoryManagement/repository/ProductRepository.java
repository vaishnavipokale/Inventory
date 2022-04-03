




package com.example.InventoryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InventoryManagement.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
