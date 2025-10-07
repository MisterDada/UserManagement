package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.ProductRequestDto;
import com.example.demo.Dto.ProductResponseDto;
import com.example.demo.Services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getProducts( @RequestBody ProductRequestDto request ){
        return
            ResponseEntity.ok( productService.getProducts() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById( @PathVariable Long id ){
        return 
            ResponseEntity.ok( productService.getProductsById(id) );
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct( @RequestBody ProductRequestDto request ){
        return new 
            ResponseEntity<>( productService.createProduct(request), HttpStatus.CREATED );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct( @PathVariable Long id ){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct( @PathVariable @RequestBody Long id, ProductRequestDto request ){
        return 
            ResponseEntity.ok( productService.updateProduct(id, request) );
    }
}
