package com.hello_world.controller;

import com.hello_world.entity.User;
import com.hello_world.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InitController {
    @Autowired
    private UserService userService;

    @GetMapping("/initial")
    String init() {
        userService.save(new User("admin", "admin", "ROLE_ADMIN"));
        userService.save(new User("user", "user", "ROLE_USER"));
        return "index";
    }
    @GetMapping("/accessDefine")
    public String access(@AuthenticationPrincipal User user, Model model) {
        if (user == null) {
            return "index";
        } else if (user.getRole().equals("ROLE_ADMIN")) {
            return "redirect:/admin/users";
        } else if (user.getRole().equals("ROLE_USER")) {
            return "redirect:/user/products";
        }
        return "index";
    }

    @GetMapping("/")
    public String userForm() {
        return "index";
    }
}
