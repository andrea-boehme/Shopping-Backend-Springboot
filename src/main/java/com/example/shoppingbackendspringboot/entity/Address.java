package com.example.shoppingbackendspringboot.entity;

import com.example.shoppingbackendspringboot.enumeration.Availability;
import com.example.shoppingbackendspringboot.enumeration.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String country;
    private String postalCode;
    private String city;
    private String street;

    // getters and setters
}
