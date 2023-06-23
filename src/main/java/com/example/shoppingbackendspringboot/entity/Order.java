package com.example.shoppingbackendspringboot.entity;

import com.example.shoppingbackendspringboot.enumeration.Availability;
import com.example.shoppingbackendspringboot.enumeration.Category;
import com.example.shoppingbackendspringboot.enumeration.ShippingState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    @OneToOne
    private User user;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ProductQuantity> items = new ArrayList<>();
    private Boolean paid;
    private ShippingState shippingState;

    @CreatedDate
    private Date date;

}
