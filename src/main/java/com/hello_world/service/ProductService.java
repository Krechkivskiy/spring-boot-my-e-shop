package com.hello_world.service;


import com.hello_world.entity.Product;


import java.util.List;
import java.util.Optional;

public interface ProductService {

    void addProduct(Product product);

    List<Product> getAll();

    void edit(Product product);

    Optional<Product> getById(int id);

    void deleteProduct(Integer id);
}
