package com.hello_world.service;

import com.hello_world.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

   void save(User user);

   List<User> getAllUsers();

   Optional<User> check(String userNаme);

   void edit(User user,Integer id);

   void deleteUser(int id);
}
