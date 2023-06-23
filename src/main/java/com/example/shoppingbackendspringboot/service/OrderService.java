package com.example.shoppingbackendspringboot.service;

import com.example.shoppingbackendspringboot.entity.Cart;
import com.example.shoppingbackendspringboot.entity.Order;
import com.example.shoppingbackendspringboot.entity.ProductQuantity;
import com.example.shoppingbackendspringboot.repository.CartRepository;
import com.example.shoppingbackendspringboot.repository.OrderRepository;
import com.example.shoppingbackendspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.example.shoppingbackendspringboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    private final UserService userService;

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        // todo: reset shopping cart content
//        for (ProductQuantity productQuantity: order.getItems()) {
//            productQuantity.setId(null);
//        }
        Cart cart = this.cartRepository.findCartByUser(order.getUser()).orElse(null);
        this.cartRepository.delete(cart);
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getOrdersByUserId(Long id) {
        User user = this.userService.getUserById(id);
        return orderRepository.findAllByUser(user);
    }

    public List<ProductQuantity> getItemsByUser(User user) {
        Cart cart = cartRepository.findCartByUser(user).orElse(null);
        ArrayList<ProductQuantity> products = new ArrayList<>();
        for (ProductQuantity productQuantity: cart.getItems()) {
            products.add(new ProductQuantity(null, productQuantity.getProduct() ,productQuantity.getQuantity()));
        }
        return products;
    }

}