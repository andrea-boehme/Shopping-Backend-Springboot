package com.example.shoppingbackendspringboot.repository;

import com.example.shoppingbackendspringboot.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
