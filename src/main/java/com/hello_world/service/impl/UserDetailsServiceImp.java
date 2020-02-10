package com.hello_world.service.impl;



import com.hello_world.entity.User;
import com.hello_world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private  UserService userService;
    private  BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsServiceImp(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDetailsServiceImp() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userbyUername = findUserbyUername(username);
        if (userbyUername != null) {
            return userbyUername;
        } else {
            throw new UsernameNotFoundException("user not found");
        }

    }

    private User findUserbyUername(String username) {
        Optional<User> user = userService.check(username);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }
}
