package com.hello_world.service.impl;

import com.hello_world.entity.Orders;
import com.hello_world.entity.Product;
import com.hello_world.entity.User;
import com.hello_world.repository.OrdersJpaRepository;
import com.hello_world.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiseImpl implements OrderService {

    @Autowired
    private OrdersJpaRepository orderDao;

    @Override
    public void createOrder(Orders orders) {
        orderDao.save(orders);
    }

    @Override
    public Optional<Orders> getOrderUser(User user) {
        return Optional.ofNullable(orderDao.getOrdersByUserId(user.getId()));
    }

    @Override
    public List<Product> getBasket(User user) {
        return orderDao.getOrdersByUserId(user.getId()).getBasket().getProductList();
    }

    @Override
    public void confirmOrder(User user) {
        Orders orders = getOrderUser(user).get();
        //orders.setConfirmed(true);
        //  orderDao.confirmOrder(true, user.getId());
    }
}
