package com.hello_world.service.impl;


import com.hello_world.entity.User;
import com.hello_world.repository.UserJpaRepository;
import com.hello_world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {


    private UserJpaRepository userDao;

    @Autowired
    public UserServiceImp(UserJpaRepository userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> check(String userNsme) {
//todo допилить енкодер
        return Optional.ofNullable(userDao.findByEmail(userNsme));
    }

    @Override
    public void edit(User user,Integer id) {
        userDao.setUserInfoById(user.getEmail(), user.getPassword(), user.getRole(), id);
    }

    @Override
    public void deleteUser(int id) {
        userDao.delete(id);
    }
}
