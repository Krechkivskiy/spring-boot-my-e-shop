package com.hello_world.repository;

import com.hello_world.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeDao extends JpaRepository<Code, Integer> {

    int findCodeByOrdersId(int orderId);
}
