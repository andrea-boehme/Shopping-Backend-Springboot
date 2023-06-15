package com.example.shoppingbackendspringboot.dto;

import com.example.shoppingbackendspringboot.enumeration.ShippingState;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@RequiredArgsConstructor
public class OrderCreateDTO {

    @NotBlank
    private String user;

    //private Map<Product, Integer> items;

    private Boolean paid;
    private ShippingState shippingState;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}