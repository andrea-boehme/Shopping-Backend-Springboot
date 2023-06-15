package com.example.shoppingbackendspringboot.service;

import com.example.shoppingbackendspringboot.entity.Product;
import com.example.shoppingbackendspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import com.example.shoppingbackendspringboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
