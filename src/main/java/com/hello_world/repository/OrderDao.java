package com.hello_world.repository;

import com.hello_world.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderDao extends JpaRepository<Orders, Integer> {

    Orders getOrdersByUserId(Integer userId);

    @Modifying
    @Transactional
    @Query(value = "update orders  set confirmed=?1 where id= ?2",nativeQuery = true)
    void confirmOrder(String isConfirmed, int orderId);
}
