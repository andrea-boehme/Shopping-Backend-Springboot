package com.example.shoppingbackendspringboot.repository;

import com.example.shoppingbackendspringboot.entity.Order;
import org.springframework.data.repository.CrudRepository;
import com.example.shoppingbackendspringboot.entity.User;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAllByUser(User user);

}
