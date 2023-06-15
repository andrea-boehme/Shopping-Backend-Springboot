package com.example.shoppingbackendspringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

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
    private final String title;
    @NotBlank
    private final String description;
}