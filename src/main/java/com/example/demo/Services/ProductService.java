package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Dto.ProductRequestDto;
import com.example.demo.Dto.ProductResponseDto;
import com.example.demo.Entities.ProductEntity;
import com.example.demo.Entities.User;
import com.example.demo.Mapper.ProductDtoMapper;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductDtoMapper productDtoMapper;    

    public ProductService(ProductDtoMapper productDtoMapper, ProductRepository productRepository, UserRepository userRepository) {
        this.productDtoMapper = productDtoMapper;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public ProductResponseDto createProduct( ProductRequestDto request ){
            Optional<User> userOptional = userRepository.findById(request.userId());

            if(userOptional.isEmpty()) {
                throw new 
                RuntimeException("User not found");
            }
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

    public ProductResponseDto updateProduct( Long id, ProductRequestDto request ){
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
