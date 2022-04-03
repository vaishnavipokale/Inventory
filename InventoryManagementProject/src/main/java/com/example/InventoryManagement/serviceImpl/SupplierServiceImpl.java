

package com.example.InventoryManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.InventoryManagement.entity.Supplier;
import com.example.InventoryManagement.exception.ResourceNotFound;
import com.example.InventoryManagement.repository.SupplierRepository;
import com.example.InventoryManagement.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{

	private SupplierRepository supplierRepository;
	
	
	public SupplierServiceImpl(SupplierRepository supplierRepository) {
		super();
		this.supplierRepository = supplierRepository;
	}


	@Override
	public Supplier saveSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}


	@Override
	public List<Supplier> getAllSupplier() {
		return supplierRepository.findAll();
		
	}


	@Override
	public Supplier getSupplierById(long id) {
		Optional<Supplier> supplier = supplierRepository.findById(id);
		if(supplier.isPresent()) {
			return supplier.get();
		}
		else {
          
			throw new ResourceNotFound("Supplier","Id",id);
		}
		
	}


	@Override
	public Supplier updateSupplier(Supplier supplier, long id) {
		Supplier sup = new Supplier();
	 try {
		   sup = supplierRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound("Supplier","Id",id));
	} catch (ResourceNotFound e) {
		
		e.printStackTrace();
	}
	 sup.setFirstName(supplier.getFirstName());
	 sup.setLastName(supplier.getLastName());
	 sup.setEmail(supplier.getEmail());
	 sup.setContactNo(supplier.getContactNo());
	 supplierRepository.save(sup);
	return sup;
	}

	@Override
	public void deleteSupplier(long id) {
		supplierRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Supplier", "Id", id));
		supplierRepository.deleteById(id);
		
	}


	@Override
	public void deleteSupplierById(long id) {
		//this.supplierRepository.deleteById(id);
		supplierRepository.deleteById(id);		//return;
	}


	
	//@Override
	//public Supplier findSupplierById(long id) {
		// TODO Auto-generated method stub
		//return null;
	//}


	

		
	
	

}
