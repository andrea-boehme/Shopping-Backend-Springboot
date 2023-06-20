package com.example.shoppingbackendspringboot.entity;

import com.example.shoppingbackendspringboot.enumeration.Availability;
import com.example.shoppingbackendspringboot.enumeration.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProductQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @OneToOne
    private Product product;
    private Integer quantity;
}
