package com.example.shoppingbackendspringboot.dto;

import com.example.shoppingbackendspringboot.enumeration.ShippingState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@RequiredArgsConstructor
public class OrderUpdateDTO {

    @NotNull
    @Positive
    private final Long id;
    @NotNull
    private final Boolean status= false;

    @NotBlank
    private final String user;

    //private Map<Product, Integer> items;
    private Boolean paid;
    private ShippingState shippingState;

    private Date date;
}
