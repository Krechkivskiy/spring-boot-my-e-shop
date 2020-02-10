package com.hello_world.repository;

import com.hello_world.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductDao extends JpaRepository<Product, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update product  set name= ?1,description=?2,price=?3 where id=?4",nativeQuery = true)
    void updateProduct(String name, String description, Double price, int id);
}
