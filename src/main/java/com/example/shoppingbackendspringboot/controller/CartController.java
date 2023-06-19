package com.example.shoppingbackendspringboot.controller;

import com.example.shoppingbackendspringboot.dto.CartUpdateDTO;
import com.example.shoppingbackendspringboot.entity.Cart;
import com.example.shoppingbackendspringboot.entity.Product;
import com.example.shoppingbackendspringboot.entity.User;
import com.example.shoppingbackendspringboot.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    @PreAuthorize("hasRole('READ Cart')")
    public Cart getCart(@AuthenticationPrincipal User user) {
        return this.cartService.getCart(user);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('UPDATE Cart')")
    public Cart updateCart(@AuthenticationPrincipal User user, @RequestBody CartUpdateDTO cartUpdateDTO)  {
        return this.cartService.updateCart(user, cartUpdateDTO.getProduct(), cartUpdateDTO.getQuantity());
    }

//    @PutMapping("/add")
//    @PreAuthorize("hasRole('ADD Cart')")
//    public Cart addCart(@AuthenticationPrincipal User user, CartUpdateDTO cartUpdateDTO) {
//        return null;
//    }
//
//    @PutMapping("/remove")
//    @PreAuthorize("hasRole('REMOVE Cart')")
//    public Cart removeCart(@AuthenticationPrincipal User user, CartUpdateDTO cartUpdateDTO) {
//        return null;
//
//    }
}