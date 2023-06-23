package com.example.shoppingbackendspringboot.controller;

import com.example.shoppingbackendspringboot.dto.OrderCreateDTO;
import com.example.shoppingbackendspringboot.dto.OrderUpdateDTO;
import com.example.shoppingbackendspringboot.entity.Order;
import com.example.shoppingbackendspringboot.entity.Product;
import com.example.shoppingbackendspringboot.entity.User;
import com.example.shoppingbackendspringboot.enumeration.ShippingState;
import com.example.shoppingbackendspringboot.service.OrderService;
import com.example.shoppingbackendspringboot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final ModelMapper modelMapper;


    @GetMapping
    //@PreAuthorize("hasRole('ORDER_READ_ALL')")
    public List<Order> getAllOrders() {
        return this.orderService.getAllOrders();
    }

//    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('ORDER_READ BY ORDER ID')")
//    public Order getOrderById(@PathVariable("id") Long id) {
//        return this.orderService.getOrderById(id);
//    }

    @PostMapping
    @PreAuthorize("hasRole('ORDER_CREATE')")
    public ResponseEntity<Order> createOrder(@AuthenticationPrincipal User user) {
        Order newOrder = new Order(null, user, this.orderService.getItemsByUser(user),false, ShippingState.PENDING, null);
        return new ResponseEntity<>(this.orderService.createOrder(newOrder), HttpStatus.CREATED);
    }


    @PutMapping
    @PreAuthorize("hasRole('ORDER_UPDATE')")
    public Order updateOrder(@Valid @RequestBody OrderUpdateDTO orderUpdateDTO) {
        Order order = this.orderService.getOrderById(orderUpdateDTO.getId());
        modelMapper.map(orderUpdateDTO, order);
        return this.orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ORDER_DELETE')")
    public void deleteOrder(@PathVariable("id") Long id) {
        this.orderService.deleteOrder(id);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ORDER_READ_ALL BY USER ID')")
    public List<Order> getOrdersByUserId(@PathVariable("id") Long id) {
        return this.orderService.getOrdersByUserId(id);
    }


//    @GetMapping("/listCompleted") // GET (lesen)
//    @PreAuthorize("hasRole('ORDER_READ_ALL')")
//    public List<ToDo> getCompletedOrders() {
//        return this.orderService.getCompletedOrder();
//    }
//
//    @GetMapping("/listNotCompleted") // GET (lesen)
//    @PreAuthorize("hasRole('ORDER_READ_ALL')")
//    public List<ToDo> getNotCompletedOrders() {
//        return this.orderService.getNotCompletedOrder();
//    }

//    @GetMapping("/countCompleted") // GET (lesen)
//    @PreAuthorize("hasRole('TODO_READ_ALL')")
//    public Long countCompletedToDos() {
//        return this.toDoService.countCompletedToDos();
//    }
//
//    @GetMapping("/countNotCompleted") // GET (lesen)
//    @PreAuthorize("hasRole('TODO_READ_ALL')")
//    public Long countNotCompletedToDos() {
//        return this.toDoService.countNotCompletedToDos();
//    }


}
