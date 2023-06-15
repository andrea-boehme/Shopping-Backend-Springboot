package com.example.shoppingbackendspringboot.controller;

import com.example.shoppingbackendspringboot.dto.ProductCreateDTO;
import com.example.shoppingbackendspringboot.dto.ProductUpdateDTO;
import com.example.shoppingbackendspringboot.dto.UserCreateDTO;
import com.example.shoppingbackendspringboot.dto.UserUpdateDTO;
import com.example.shoppingbackendspringboot.entity.Product;
import com.example.shoppingbackendspringboot.entity.User;
import com.example.shoppingbackendspringboot.service.ProductService;
import com.example.shoppingbackendspringboot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final ProductService productService;
    private final UserService userService;
    private final ModelMapper modelMapper;


    @GetMapping
    @PreAuthorize("hasRole('USER_READ_ALL')")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER_READ_ALL BY PRODUCT ID')")
    public User getUserById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER_CREATE')")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        return new ResponseEntity<>(this.userService.createUser(modelMapper.map(userCreateDTO, User.class)), HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER_UPDATE')")
    public User updateUser(@Valid @RequestBody UserUpdateDTO userUpdateDTO) {
        User user = this.userService.getUserById(userUpdateDTO.getId());
        modelMapper.map(userUpdateDTO, user);
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER_DELETE')")
    public void deleteUser(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);
    }

}