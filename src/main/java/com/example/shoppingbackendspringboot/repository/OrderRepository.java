package com.example.shoppingbackendspringboot.repository;

import com.example.shoppingbackendspringboot.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAllByUser(User user);

}
