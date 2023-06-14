package com.example.shoppingbackendspringboot.repository;

import com.example.shoppingbackendspringboot.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
