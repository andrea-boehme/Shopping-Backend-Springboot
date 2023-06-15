package com.example.shoppingbackendspringboot.repository;

import com.example.shoppingbackendspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
