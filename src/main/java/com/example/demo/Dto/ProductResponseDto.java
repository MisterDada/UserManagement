package com.example.demo.Dto;

import java.util.List;

import com.example.demo.Entities.User;

public record ProductResponseDto(

    Long Id,
    String product_name,
    String decription,
    double price,
    int quantity,
    List<User> seller

) {
    
}
