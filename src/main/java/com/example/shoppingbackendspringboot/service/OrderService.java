package com.example.shoppingbackendspringboot.service;

import com.example.shoppingbackendspringboot.entity.Order;
import com.example.shoppingbackendspringboot.repository.OrderRepository;
import com.example.shoppingbackendspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.example.shoppingbackendspringboot.entity.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    private final UserService userService;

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
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
}