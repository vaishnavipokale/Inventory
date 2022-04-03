
package com.example.InventoryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InventoryManagement.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice,Long>{
    
	
}

