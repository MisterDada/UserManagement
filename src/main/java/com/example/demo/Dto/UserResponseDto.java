package com.example.demo.Dto;

import java.util.List;

import com.example.demo.Entities.ProductEntity;

// This dto represents what we send to the user / frontend
public record UserResponseDto(
    Long id,
    String name,
    String email,
    List<ProductEntity> createdProducts
) {

    
}
