package com.example.demo.Dto;

import com.example.demo.Entities.User;

public record ProductResponseDto(

    Long Id,
    String product_name,
    String decription,
    double price,
    int quantity,
    User seller

) {
    
}
