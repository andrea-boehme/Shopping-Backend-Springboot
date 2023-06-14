package com.example.shoppingbackendspringboot.repository;

import com.example.shoppingbackendspringboot.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
