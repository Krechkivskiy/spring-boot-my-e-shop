package com.hello_world.service.impl;

import com.hello_world.entity.Basket;
import com.hello_world.entity.Product;
import com.hello_world.entity.User;
import com.hello_world.repository.BasketJpaRepository;
import com.hello_world.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BasketServiseImpl implements BasketService {
    @Autowired
    private BasketJpaRepository basketDao;

    @Override
    public void addProduct(User user, Product product) {
        Basket byUserId = basketDao.findByUserId(user.getId());
        if (byUserId == null) {
            ArrayList<Product> products = new ArrayList<>();
            products.add(product);
            basketDao.save(new Basket(user, products));
            Basket byUserId1 = basketDao.findByUserId(user.getId());
            basketDao.setBasketInfoById(byUserId1.getId(),product.getId());
        } else {
            basketDao.setBasketInfoById(byUserId.getId(),product.getId());
        }
    }

    @Override
    public long getCountOfElements(User user) {
        Basket byUserId = basketDao.findByUserId(user.getId());
        if (byUserId == null) {
            return 0;
        }
        return byUserId.getProductList().size();
    }

    @Override
    public void createBasket(User user) {
        basketDao.save(new Basket(user, Collections.emptyList()));
    }

    @Override
    public Optional<Basket> getBasketByUser(User user) {
        return Optional.ofNullable(basketDao.findByUserId(user.getId()));
    }
}
