package com.example.shoppingbackendspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @OneToOne
    private User user;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<ProductQuantity> items = new ArrayList<>();
}
