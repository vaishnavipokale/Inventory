

package com.example.InventoryManagement.service;

import java.util.List;

import com.example.InventoryManagement.entity.Admin;

public interface AdminService {
	
	Admin saveAdmin(Admin admin);
	List<Admin> getAllAdmin();
	Admin getAdminById(long id);
	Admin updateAdmin(Admin admin, long id);
	void deleteAdmin(long id);
}
