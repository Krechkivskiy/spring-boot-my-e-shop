package com.hello_world.controller;

import com.hello_world.entity.Product;
import com.hello_world.entity.User;
import com.hello_world.service.BasketService;
import com.hello_world.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class BasketController {

    private ProductService productService;
    private BasketService basketService;

    @Autowired
    public BasketController(ProductService productService, BasketService basketService) {
        this.productService = productService;
        this.basketService = basketService;
    }

    @GetMapping("/add_to_box")
    String addToBox(@RequestParam int id, Model model, @AuthenticationPrincipal User user) {
        Product product = productService.getById(id).get();
        basketService.addProduct(user, product);
        model.addAttribute("box", basketService.getCountOfElements(user));
        model.addAttribute("productDatabase", productService.getAll());
        return "buy_product";
    }

    @GetMapping("/products")
    String allProduct(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("productDatabase", productService.getAll());
        model.addAttribute("box", basketService.getCountOfElements(user));
        return "buy_product";
    }
}
