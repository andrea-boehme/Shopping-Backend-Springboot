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

import static com.example.shoppingbackendspringboot.enumeration.Availability.*;
import static com.example.shoppingbackendspringboot.enumeration.Category.*;

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
        Address addressOne = new Address(null, "Germany", "82284", "München", "Alemannstrasse");
        addressRepository.save(addressOne);
        Address addressTwo = new Address(null, "Austria", "12569", "Salzburg", "Probusgasse");
        addressRepository.save(addressTwo);
        Address addressThree = new Address(null, "Italy", "584948", "Rome", "Via del Corso");
        addressRepository.save(addressThree);

        final User userOne = new User(null, "astein@gmail.com", "Anna", "Stein", "steiny", addressOne);
        userRepository.save(userOne);
        final User userTwo = new User(null, "ewilly@gmail.com", "Emma", "Willy", "Emmy", addressTwo);
        userRepository.save(userTwo);
        final User userThree = new User(null, "fbenno@gmail.com", "Fritz", "Benno", "Fbenno", addressThree);
        userRepository.save(userThree);

        Product productOne = new Product(null, "Phone", "iPhone Model X", 100F, ELECTRONICS, AVAILABLE);
        productRepository.save(productOne);
        Product productTwo = new Product(null, "Hello Kitty", "Story of a cat for children", 50F, BOOKS, OUT_OF_STOCK);
        productRepository.save(productTwo);
        Product productThree = new Product(null, "Dress", "Dress for women size M", 80F, CLOTHING, LIMITED_STOCK);
        productRepository.save(productThree);


    }
}
