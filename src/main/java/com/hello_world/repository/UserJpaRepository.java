package com.hello_world.repository;


import com.hello_world.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "update users  set email = ?1, password = ?2, role=?3 where id = ?4",
            nativeQuery = true
    )
    void setUserInfoById(String email, String password, String role, Integer userId);
}
