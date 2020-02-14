package com.hello_world.controller;


import com.hello_world.entity.User;
import com.hello_world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/admin/users")
    String getm(Model model) {
        model.addAttribute("userDatabase", userService.getAllUsers());
        return "page_to_save";
    }

    @GetMapping("/admin/register")
    String register(Model model) {
        return "registration";
    }

    @PostMapping("/admin/register")
    String registerUser(@ModelAttribute("user") User user, Model model) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        model.addAttribute("userDatabase", userService.getAllUsers());
        return "page_to_save";
    }

    @DeleteMapping("/admin/remove")
    String removeUser(@RequestParam("id") int id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("userDatabase", userService.getAllUsers());
        return "page_to_save";
    }

    @PutMapping("/admin/edit")
    String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("id", id);
        return "page_to_change_user";
    }

    @PutMapping("/admin/edit")
    String saveNewUserData(@ModelAttribute("user") User user, Model model) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.edit(user, user.getId());
        model.addAttribute("userDatabase", userService.getAllUsers());
        return "page_to_save";
    }
}
