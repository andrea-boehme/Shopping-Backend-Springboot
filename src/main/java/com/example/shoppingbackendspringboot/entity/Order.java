package com.example.shoppingbackendspringboot.entity;

import com.example.shoppingbackendspringboot.enumeration.Availability;
import com.example.shoppingbackendspringboot.enumeration.Category;
import com.example.shoppingbackendspringboot.enumeration.ShippingState;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String user;

    //private Map<Product, Integer> items;
    private Boolean paid;
    private ShippingState shippingState;

    private Date date;

    // getters and setters
}
