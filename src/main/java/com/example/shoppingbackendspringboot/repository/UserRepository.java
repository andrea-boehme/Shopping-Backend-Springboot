package com.example.shoppingbackendspringboot.repository;

import com.example.shoppingbackendspringboot.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
