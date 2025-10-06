package com.example.demo.Dto;

import com.example.demo.Entities.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDto(

    @NotNull
    User id,

    @NotBlank( message = "Product name cannot be blank" )
    String product_name,

    @NotBlank( message = "Product description cannot be blank" )
    String description,

    @NotBlank( message = "Product quantity cannot be blank" )
    int quantity,

    @NotBlank( message = "Product price cannot be blank" )
    double price

) {
    
}
