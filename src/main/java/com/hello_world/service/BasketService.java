package com.hello_world.service;




import com.hello_world.entity.Basket;
import com.hello_world.entity.Product;
import com.hello_world.entity.User;

import java.util.Optional;

public interface BasketService {

    void addProduct(User user, Product product);

    long getCountOfElements(User user);

    void createBasket(User user);

    public Optional<Basket> getBasketByUser(User user);

}
