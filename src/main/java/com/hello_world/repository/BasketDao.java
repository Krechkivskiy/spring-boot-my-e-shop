package com.hello_world.repository;

import com.hello_world.entity.Basket;
import com.hello_world.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BasketDao extends JpaRepository<Basket,Integer> {

    Basket findByUserId(int IdUser);

    @Modifying
    @Transactional
    @Query(value = "insert into product_basket (basket_id,product_id) values (?1,?2)"+
            "set productList= ?1 where id = ?2",nativeQuery = true)
    void setBasketInfoById(int productId, Integer basketId);
}
