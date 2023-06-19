package com.example.shoppingbackendspringboot.repository;

import com.example.shoppingbackendspringboot.entity.Cart;
import com.example.shoppingbackendspringboot.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Long> {
    Cart findCartByUser(User user);
}
