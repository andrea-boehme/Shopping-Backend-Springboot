package com.example.shoppingbackendspringboot.repository;

import com.example.shoppingbackendspringboot.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
