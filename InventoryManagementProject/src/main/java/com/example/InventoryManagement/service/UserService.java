package com.example.InventoryManagement.service;

import java.util.List;
import java.util.Optional;

import com.example.InventoryManagement.entity.User;

public interface UserService {
   public Optional<User> findUserByUserName(String userName);

User saveUser(User user);

List<User> getAllUser();

User getUserById(long id);

User updateUser(User user, long id);

//public void deleteUser(long id);


   
}
