package com.hello_world.service.impl;

import com.hello_world.entity.Product;
import com.hello_world.repository.ProductJpaRepository;
import com.hello_world.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductJpaRepository productDao;

    @Override
    public void addProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public void edit(Product product) {
        productDao.updateProduct(product.getName(), product.getDescription(),
                product.getPrice(), product.getId());
    }

    @Override
    public Optional<Product> getById(int id) {
        return Optional.ofNullable(productDao.findOne(id));
    }

    @Override
    public void deleteProduct(Integer id) {
        productDao.delete(id);
    }
}
