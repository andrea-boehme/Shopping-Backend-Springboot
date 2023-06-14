package com.example.shoppingbackendspringboot.database;

import com.example.shoppingbackendspringboot.entity.Address;
import com.example.shoppingbackendspringboot.entity.Cart;
import com.example.shoppingbackendspringboot.entity.Order;
import com.example.shoppingbackendspringboot.entity.Product;
import com.example.shoppingbackendspringboot.entity.User;
import com.example.shoppingbackendspringboot.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class DatabasePopulator implements CommandLineRunner {
    @Autowired
    private final AddressRepository addressRepository;
    @Autowired
    private final CartRepository cartRepository;

    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final UserRepository userRepository;

    //@Autowired
    //private final CartService cartService;

    //@Autowired
    //private final UserService userService;


    @Override
    public void run(String... args) throws Exception {
        Address address = new Address(null, "Germany", "82284", "München", "Alemannstrasse");
        addressRepository.save(address);

        final User user = new User(null, "astein@gmail.com", "Anna", "Stein", "password", address);
        userRepository.save(user);
    }
}
