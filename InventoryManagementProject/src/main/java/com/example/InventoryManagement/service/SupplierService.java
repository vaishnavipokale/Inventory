

package com.example.InventoryManagement.service;

import java.util.List;

import com.example.InventoryManagement.entity.Supplier;

public interface SupplierService {
	
	Supplier saveSupplier(Supplier supplier);
	List<Supplier> getAllSupplier();
	Supplier getSupplierById(long id);
	Supplier updateSupplier(Supplier supplier, long id);
	//List<Supplier> getSupplierByFirstName(String firstName);
	//void deleteSupplier(long id);
	//Supplier deleteSupplierById(long id);
	void deleteSupplier(long id);
	void deleteSupplierById(long id);
	//void delete(Long id);
	//Supplier findSupplierById(long id);
	
}
