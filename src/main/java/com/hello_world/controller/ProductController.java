package com.hello_world.controller;


import com.hello_world.entity.Product;
import com.hello_world.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/admin/addProduct")
    String addProd(Model model) {
        model.addAttribute("productDatabase", productService.getAll());
        return "product";
    }

    @PostMapping("/admin/addProduct")
    String products(@ModelAttribute Product product, Model model) {
        productService.addProduct(product);
        model.addAttribute("productDatabase", productService.getAll());
        return "product";
    }

    @GetMapping("/admin/edit_product")
    String editProduc(@RequestParam("id") int id, Model model) {
        model.addAttribute("id", id);
        return "page_to_change_product";
    }

    @PutMapping("/admin/edit_product")
    String editProduct(@ModelAttribute("product") Product product, Model model) {
        productService.edit(product);
        model.addAttribute("productDatabase", productService.getAll());
        return "product";
    }

    @DeleteMapping("/admin/delete_product")
    String deleteProduct(@RequestParam("id") int id, Model model) {
        productService.deleteProduct(id);
        model.addAttribute("productDatabase", productService.getAll());
        return "product";
    }
}
