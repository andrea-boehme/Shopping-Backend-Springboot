package com.example.shoppingbackendspringboot.repository;

import com.example.shoppingbackendspringboot.entity.Product;
import com.example.shoppingbackendspringboot.entity.ProductQuantity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductQuantityRepository extends CrudRepository<ProductQuantity, Long> {
}
