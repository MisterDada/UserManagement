package com.example.demo.Services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Dto.ProductRequestDto;
import com.example.demo.Dto.ProductResponseDto;
import com.example.demo.Entities.ProductEntity;
import com.example.demo.Mapper.ProductDtoMapper;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;
    private final ProductDtoMapper productDtoMapper;    

    public ProductService(ProductDtoMapper productDtoMapper, ProductRepository productRepository) {
        this.productDtoMapper = productDtoMapper;
        this.productRepository = productRepository;
    }

    public ProductResponseDto createProduct( ProductRequestDto request ){
        // convert dto to entity
            ProductEntity product = productDtoMapper.toEntity(request);

        // Save product
            ProductEntity newProduct = productRepository.save(product);

        //  convert entity to dto
            return productDtoMapper.toResponse(newProduct);

    }

    public List<ProductResponseDto> getProducts(){
            List<ProductEntity> products = productRepository.findAll();

            return products.stream()
                .map( product -> 
                    productDtoMapper.toResponse(product))
                        .toList();
    }

    public ProductResponseDto getProductsById( Long id ){
            ProductEntity existingProduct = productRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product does not exist")
                 );

            return productDtoMapper.toResponse(existingProduct);
    }

    
    public void deleteProduct( Long id ){
        // Check if product exists
        ProductEntity existingProduct = productRepository.findById(id)
            .orElseThrow( () -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Product does not exist") 
            );

            productRepository.delete(existingProduct);
    }

    public ProductResponseDto updateUser( Long id, ProductRequestDto request ){
            // check if product exists

                 ProductEntity existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new 
            RuntimeException("User not found"));

            // Edit fields
            existingProduct.setProduct_name(request.product_name());
            existingProduct.setDescription(request.description());
            existingProduct.setPrice(request.price());
            existingProduct.setQuantity(request.quantity());
            
            // Save product
             productRepository.save(existingProduct);

                return productDtoMapper.toResponse(existingProduct);


        }

}
