package com.hello_world.controller;

import com.hello_world.entity.User;
import com.hello_world.service.BasketService;
import com.hello_world.service.ProductService;
import com.hello_world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @Autowired
    ProductService productService;


    @Autowired
    BasketService basketService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    @RequestMapping("/1231")
    public String index() {

        return "index";
    }

    @RequestMapping(value = "/init",method = RequestMethod.GET)
    public String init() {
        userService.save(new User("vasya", passwordEncoder.encode("12345"),"ROLE_USER"));
        userService.save(new User("user", passwordEncoder.encode("user"),"ROLE_USER"));
        userService.save(new User("admin", passwordEncoder.encode("admin"),"ROLE_ADMIN"));
        userService.save(new User("oleg", passwordEncoder.encode("123"),"asde"));
        return "index";
    }

    @RequestMapping(value = "/asddd", method = RequestMethod.GET)
    public String check() {
    userService.check("oleg");
     userService.deleteUser(2);
     userService.edit(new User("asd","qwe","sdfsa"),3);

    return "index";
    }

    @PostMapping("/hello")
    public String sayHello(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
