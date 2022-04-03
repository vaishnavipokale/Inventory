
package com.example.InventoryManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.InventoryManagement.entity.Admin;
import com.example.InventoryManagement.exception.ResourceNotFound;
import com.example.InventoryManagement.repository.AdminRepository;
import com.example.InventoryManagement.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	private AdminRepository adminRepository;
	
	
	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}


	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}


	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
		
	}


	@Override
	public Admin getAdminById(long id) {
		Optional<Admin> admin = adminRepository.findById(id);
		if(admin.isPresent()) {
			return admin.get();
		}
		else {
          
			throw new ResourceNotFound("User","Id",id);
		}
		
	}


	@Override
	public Admin updateAdmin(Admin admin, long id) {
		Admin adm = new Admin();
	 try {
		   adm = adminRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound("User","Id",id));
	} catch (ResourceNotFound e) {
		
		e.printStackTrace();
	}
	 adm.setFirstName(admin.getFirstName());
	 adm.setLastName(admin.getLastName());
	 adm.setEmail(admin.getEmail());
	 adm.setContactNo(admin.getContactNo());
	 adm.setAddress(admin.getAddress());
	 adminRepository.save(adm);
	return adm;
	}

	@Override
	public void deleteAdmin(long id) {
		adminRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Admin", "Id", id));
		adminRepository.deleteById(id);
		
	}
	

}
