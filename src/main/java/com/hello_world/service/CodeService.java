package com.hello_world.service;


import com.hello_world.entity.Code;
import com.hello_world.entity.Orders;

public interface CodeService {

    void add(Code code);

    int getCode(Orders orders);
}
