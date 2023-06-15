package com.example.shoppingbackendspringboot.dto;

import com.example.shoppingbackendspringboot.entity.Address;
import com.example.shoppingbackendspringboot.enumeration.Availability;
import com.example.shoppingbackendspringboot.enumeration.Category;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class UserUpdateDTO {
    @NotNull
    @Positive
    private final Long id;
    @NotBlank
    private final String email;

    @NotBlank
    private final String firstname;

    @NotBlank
    private final String surname;

    private String password;
    @OneToOne
    private Address address;

}