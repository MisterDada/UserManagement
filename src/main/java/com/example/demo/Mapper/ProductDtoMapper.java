package com.example.demo.Mapper;


import com.example.demo.Dto.ProductRequestDto;
import com.example.demo.Dto.ProductResponseDto;
import com.example.demo.Entities.ProductEntity;

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
                null //this should not be null i think
                );
    };

}
