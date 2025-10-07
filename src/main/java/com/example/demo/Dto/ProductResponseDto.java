package com.example.demo.Dto;

public record ProductResponseDto(

    Long Id,
    String product_name,
    String decription,
    double price,
    int quantity,
    UserResponseDto user

) {
    
}
