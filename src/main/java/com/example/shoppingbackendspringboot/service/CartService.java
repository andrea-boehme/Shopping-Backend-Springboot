package com.example.shoppingbackendspringboot.service;

import com.example.shoppingbackendspringboot.entity.Cart;
import com.example.shoppingbackendspringboot.entity.Product;
import com.example.shoppingbackendspringboot.entity.User;
import com.example.shoppingbackendspringboot.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Cart getCart(User user) {
        return cartRepository.findCartByUser(user);
    }

    public Cart updateCart(User user, Product product, Integer quantity) {
        Cart cart = cartRepository.findCartByUser(user);

        if (cart.getItems().containsKey(product) && quantity != 0) {            // Situation 2: Produkt ist vorhanden und Menge nicht 1, neue Menge übernehmen
            Integer newQuantity = cart.getItems().get(product);
            newQuantity = quantity;
        } else if (cart.getItems().containsKey(product) && quantity == 0)  {   // Situation 3: Produkt ist vorhanden mit Menge 1
            cart.getItems().remove(product);
        } else {
            cart.getItems().put(product, quantity);                            // Situation 1: Produkt ist nicht vorhanden
        }
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
