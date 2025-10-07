package com.example.demo.Mapper;

import org.springframework.stereotype.Component;

import com.example.demo.Dto.ProductRequestDto;
import com.example.demo.Dto.ProductResponseDto;
import com.example.demo.Dto.UserResponseDto;
import com.example.demo.Entities.ProductEntity;
import com.example.demo.Entities.User; // adjust if your entity class is named UserEntity

@Component
public class ProductDtoMapper {
    
    public ProductEntity toEntity( ProductRequestDto request ){
        return new ProductEntity(
                null, 
                request.description(), 
                request.price(), 
                request.product_name(), 
                request.quantity(), 
                null
            );
    };

    public ProductResponseDto toResponse( ProductEntity product ){
        return new ProductResponseDto(
                product.getId(), 
                product.getProduct_name(), 
                product.getDescription(), 
                product.getPrice(), 
                product.getQuantity(),
                toUserResponseDto(product.getUser())
                );
    };

    private UserResponseDto toUserResponseDto(User user){
        if(user == null) return null;
        // Adjust constructor/fields below to match your UserResponseDto and User entity
        return new UserResponseDto(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getProduct()
        );
    }

}