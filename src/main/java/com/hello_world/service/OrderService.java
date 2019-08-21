package com.hello_world.service;


import com.hello_world.entity.Orders;
import com.hello_world.entity.Product;
import com.hello_world.entity.User;


import java.util.List;
import java.util.Optional;

public interface OrderService {

    void createOrder(Orders orders);

    public Optional<Orders> getOrderUser(User user);

    List<Product> getBasket(User user);

    void confirmOrder(User user);
}
