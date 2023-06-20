package com.example.shoppingbackendspringboot.service;

import com.example.shoppingbackendspringboot.entity.Cart;
import com.example.shoppingbackendspringboot.entity.Product;
import com.example.shoppingbackendspringboot.entity.ProductQuantity;
import com.example.shoppingbackendspringboot.entity.User;
import com.example.shoppingbackendspringboot.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Cart getCart(User user) {
        return cartRepository.findCartByUser(user).orElse(null);
    }

    public Cart updateCart(User user, Product product, Integer quantity) {
        Cart cart = cartRepository.findCartByUser(user).orElse(new Cart(null, user, new ArrayList<>()));

//        if (cart.getItems().contains(product) && quantity != 0) {            // Situation 2: Produkt ist vorhanden und Menge nicht 1, neue Menge übernehmen
//            Integer newQuantity = cart.getItems().get(product);
//            newQuantity = quantity;
//        } else if (cart.getItems().contains(product) && quantity == 0)  {   // Situation 3: Produkt ist vorhanden mit Menge 1
//            cart.getItems().remove(product);
//        } else {
            cart.getItems().add(new ProductQuantity(null, product, quantity));                            // Situation 1: Produkt ist nicht vorhanden
//        }
         return cartRepository.save(cart);
    }
//
//    public Cart addCart(User user, Product product, Integer quantity) {
//        Cart cart = cartRepository.findCartByUser(user);
//        if (cart.getItems().containsKey(product)) {
//            Integer newQuantity = cart.getItems().get(product);
//            newQuantity += quantity;
//        } else {
//            cart.getItems().put(product, quantity);
//        }
//        return cartRepository.save(cart);
//    }

//    public Cart removeCart(User user, Product product, Integer quantity) {
//        Cart cart = cartRepository.findCartByUser(user);
//        if (cart.getItems().containsKey(product)) {
//            Integer newQuantity = cart.getItems().get(product);
//            newQuantity -= quantity;
//        }
//        return cartRepository.save(cart);
//    }


}
