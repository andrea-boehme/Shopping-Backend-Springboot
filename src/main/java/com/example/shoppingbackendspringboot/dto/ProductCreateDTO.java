package com.example.shoppingbackendspringboot.dto;

import com.example.shoppingbackendspringboot.enumeration.Availability;
import com.example.shoppingbackendspringboot.enumeration.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ProductCreateDTO {
    @NotBlank
    private final String name;

    private final String description;

    private Float price;
    private Category category;

    private Availability available;
}

